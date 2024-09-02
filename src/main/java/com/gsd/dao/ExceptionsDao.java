package com.gsd.dao;

import com.gsd.entity.Exceptions;

public interface ExceptionsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Exceptions record);

    int insertSelective(Exceptions record);

    Exceptions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exceptions record);

    int updateByPrimaryKey(Exceptions record);
}