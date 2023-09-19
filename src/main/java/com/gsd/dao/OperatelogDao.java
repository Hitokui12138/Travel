package com.gsd.dao;

import com.gsd.entity.Operatelog;

public interface OperatelogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Operatelog record);

    int insertSelective(Operatelog record);

    Operatelog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Operatelog record);

    int updateByPrimaryKey(Operatelog record);
}