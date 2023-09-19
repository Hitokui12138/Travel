package com.gsd.service;

import com.gsd.dao.AreaDao;
import com.gsd.entity.Area;
import com.gsd.entity.Scenery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AreaService.java
 * @Description TODO
 * @createTime 2023年09月11日 14:55:00
 */

@Service
public class AreaService {
    @Autowired
    AreaDao areaDao;

    public List<Area> findAll(){
        return areaDao.findAll();
    }
}
