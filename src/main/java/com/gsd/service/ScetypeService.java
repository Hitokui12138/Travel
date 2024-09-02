package com.gsd.service;

import com.gsd.dao.ScetypeDao;
import com.gsd.entity.Scetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ScetypeService.java
 * @Description TODO
 * @createTime 2023年09月11日 12:49:00
 */
@Service
public class ScetypeService {
    @Autowired
    ScetypeDao scetypeDao;

    public List<Scetype> findAll(){
        return scetypeDao.findAll();
    }
}
