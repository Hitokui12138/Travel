package com.gsd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gsd.dao.HotelDao;
import com.gsd.entity.Hotel;
import com.gsd.util.FileUtils;
import com.gsd.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelService.java
 * @Description TODO
 * @createTime 2023年09月12日 07:06:00
 */
@Service
public class HotelService {
    @Autowired
    HotelDao hotelDao;

    public List<Hotel> findAll2(){
        return hotelDao.findAll2();
    }

    public List<Hotel> findAll3(Hotel hotel){
        return hotelDao.findAll3(hotel);
    }

    public PageBean page(int curPage, int pageSize, Hotel hotel){
        Page<Hotel> page = PageHelper.startPage(curPage, pageSize);//没有默认值的话会报空指针
        //List<Hotel> hotelList = hotelDao.findAll2();
        hotelDao.findAll(hotel);
        PageBean pb = new PageBean();
        pb.setCurPage(page.getPageNum());
        pb.setPages(page.getPages());
        pb.setList(page.getResult());
        return pb;
    }

    @Autowired
    HttpServletRequest request;

    public int addHotel(Hotel hotel, MultipartFile file) throws IOException {
        //应该在业务层封装上传文件，controller只要接收数据和返回结果
        hotel.setPic(FileUtils.up(file,request));
        return hotelDao.addHotel(hotel);
    }

    public Hotel findHotelByHotelid(Long hotelid){
        return hotelDao.findHotelByHotelid(hotelid);
    }

    public int updateByPrimaryKeySelective(Hotel hotel,MultipartFile file) throws IOException {
        hotel.setPic(FileUtils.up(file,request));
        return hotelDao.updateByPrimaryKeySelective(hotel);
    }

    public int deleteByPrimaryKey(Long id){
        long i = id;
        return hotelDao.deleteByPrimaryKey((int)i);
    }
}
