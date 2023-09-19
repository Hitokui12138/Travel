package com.gsd.service;

import com.gsd.dao.OperatelogDao;
import com.gsd.entity.Operatelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OperateLogService.java
 * @Description TODO
 * @createTime 2023年09月18日 08:52:00
 */
@Service
public class OperateLogService {
    @Autowired
    OperatelogDao operatelogDao;

    public int insert(Operatelog operatelog){
        return operatelogDao.insertSelective((operatelog));
    }
}
