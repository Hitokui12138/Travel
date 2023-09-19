package com.gsd.service;

import com.gsd.dao.HotelDao;
import com.gsd.dao.RoomTypeDao;
import com.gsd.entity.Hotel;
import com.gsd.entity.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RoomTypeService.java
 * @Description TODO
 * @createTime 2023年09月12日 08:12:00
 */

/*
    @Transactional,把事务控制在业务层了
    可以写在类上或者方法上(一般就写在每个Service类上面)
        1. readOnly = false; 是否是只读,对于查询,可以改成true从而不用开启事务,只有增删改需要事务
        2. isolation = default; 隔离级别,有的引擎Mysam不支持事务,mysam的时候才需要设置这个
        3. propagation= Propagation.REQUIED或者REQUIED_NEW,事务的传播特性
            1. Propagation.REQUIED,默认,dao的默认没有事务,因此自动开一个事务(只有一个事务),存钱+日志
            2. 假如操作一个日志表,即使存钱失败,也要记录
                - 在upodateLog()方法上使用REQUIED_NEW,表示无论其他事务成不成功,这个一定要执行(总是开启一个新事务)
        4. TIMEOUT = -1, 两个事务一起执行时,默认永久等待

        几个回滚相关的
        默认是只有出现了`运行时异常`才会回滚,编译的那种可以throws,throws的那种才会触发异常,trycatch的不算
        5. rollbackfor = {Exception.class}
        6. rollbackForClass = {"java.lang.Exception"}
        7. noRollbackFor = {IOEXCEption},表示fashengIO异常不会滚
        8. noRollbackForClass
 */


@Service
@Transactional  //默认只能扫描哪四种注解,因此要开启这个注解,导包
public class RoomTypeService {
    @Autowired
    RoomTypeDao roomTypeDao;

    @Autowired
    HotelDao hotelDao;

    public List<RoomType> findAll(){
        return roomTypeDao.findAll();
    }

    public List<RoomType> findRoomtypeByHotelid(Long integer){
        return roomTypeDao.findRoomtypeByHotelid(integer);
    }


    /**
     * 事务默认是在DAO层做的,执行完sql之后立即就提交了
     * 应该在Service层开启一个事务,再
     *
     * 现在是方法和方法之间产生依赖了
     * 现在这个方法在执行之前应该有一个开启事务的方法和关闭事务的方法,回滚事务的方法
     * 但是这个方法需要connection,但我i们拿不到connection
     * 所以需要AOP
     *
     *相当于对原来的方法做增强
     *
     * ->代理
     *
     * @param roomType
     * @return
     */
    public int updateRoomtype(RoomType roomType){
        /**
         * 需要在一个事务里修改两张表
         * 1.修改当前房间
         * 2.修改对应酒店的房间数
         */
        //1.更新当前roomtype
        if(roomType.getRoomtypeid()==null){
            roomTypeDao.insertRoomtype(roomType);
        }else{
            roomTypeDao.updateByPrimaryKeySelective(roomType);
        }

        //2.计算总房间数
        List<RoomType> roomTypes = roomTypeDao.findRoomtypeByHotelid(roomType.getHotelid());
        int count =0;
        for(RoomType type : roomTypes){
            count+=type.getRoomnum();
        }
        //2.1 获取一个包含所有值的hotel对象
        Hotel hotel = hotelDao.selectByPrimaryKey(Math.toIntExact((Long) roomType.getHotelid()));
        hotel.setRoomcount((long) count);
        //3.更新hotel总房间数


        return hotelDao.updateByPrimaryKeySelective(hotel);
    }

    int updateByPrimaryKeySelective(RoomType roomType){
        return roomTypeDao.updateByPrimaryKeySelective(roomType);
    }

    int insertRoomtype(RoomType roomType){
        return roomTypeDao.insertRoomtype(roomType);
    }

    public int deleteRoomtype(Long roomTypeid){
        return roomTypeDao.deleteRoomtype(roomTypeid);
    }
    /**
     *
     * springjdbc工具类,里面有一些处理事务的方法
     * 这个类本身就是个
     *
     *
     *
     */

}
