package com.gsd.service;

import com.gsd.dao.ExceptionsDao;
import com.gsd.entity.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ExceptionsService.java
 * @Description TODO
 * @createTime 2023年09月18日 10:16:00
 */
@Service
public class ExceptionsService {

    @Autowired
    ExceptionsDao exceptionsDao;

    public int insertSelective(Exceptions exceptions){
        return exceptionsDao.insertSelective(exceptions);
    }
}
