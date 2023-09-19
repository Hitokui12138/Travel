package com.gsd.service;

import com.gsd.dao.HotelAreaDao;
import com.gsd.entity.HotelArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelAreaService.java
 * @Description TODO
 * @createTime 2023年09月12日 08:11:00
 */
@Service
public class HotelAreaService {
    @Autowired
    HotelAreaDao hotelAreaDao;

    public List<HotelArea> findAll(){
        return hotelAreaDao.findAll();
    }
}
