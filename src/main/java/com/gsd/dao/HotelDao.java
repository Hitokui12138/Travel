package com.gsd.dao;

import com.gsd.entity.Hotel;
import com.gsd.entity.RoomType;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface HotelDao {
    public List<Hotel> findAll(Hotel hotel);

    public int addHotel(Hotel hotel);


//   新的
    int deleteByPrimaryKey(Integer hotelid);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    Hotel selectByPrimaryKey(Integer hotelid);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKey(Hotel record);

    //1.选择所有
    //用注解来写
    @Select("select hotelid,hotelname,in_time,out_time,pic,hotelareaid,roomtypeid,context,collection,favorite,room_count,site,hotelphone,price FROM t_hotel")
    @Results(id="HotelMap2", value={
        @Result(property="hotelarea",column = "hotelareaid",many = @Many(select = "com.gsd.dao.HotelAreaDao.findHotelAreaById")),
        @Result(property="roomtype",column = "roomtypeid",many = @Many(select = "com.gsd.dao.RoomTypeDao.findRoomTypeById"))
    })//表示resultmap,默认也是自动映射,@Many表示多对一
    public List<Hotel> findAll2();


    //2.用动态sql写多条件查询的Where条件,@Select里面太乱
    //去看HotelSqlBuilder这个类
    //@Select("select hotelid,hotelname,in_time,out_time,pic,hotelareaid,roomtypeid,context,collection,favorite,room_count,site,hotelphone,price FROM t_hotel")
    @SelectProvider(type = HotelSqlBuilder.class, method = "builderFindAll")
    @Results(id="HotelMap3", value={
            @Result(property="hotelarea",column = "hotelareaid",many = @Many(select = "com.gsd.dao.HotelAreaDao.findHotelAreaById")),
            @Result(property="roomtype",column = "roomtypeid",many = @Many(select = "com.gsd.dao.RoomTypeDao.findRoomTypeById"))
    })//表示resultmap,默认也是自动映射,@Many表示多对一
    List<Hotel> findAll3(Hotel hotel);

    //查一个
    @Select("select hotelid,hotelname,in_time,out_time,pic,hotelareaid,roomtypeid,context,collection,favorite,room_count,site,hotelphone,price FROM t_hotel WHERE hotelid = #{hotelid}")
    public Hotel findHotelByHotelid(Long hotelid);



}


