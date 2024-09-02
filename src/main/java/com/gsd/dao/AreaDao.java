package com.gsd.dao;

import com.gsd.entity.Area;

import java.util.List;

/**
 * 使用MyBatis的时候Dao层不需要@Repository注解
 */

public interface AreaDao {
    public List<Area> findAll();




}
