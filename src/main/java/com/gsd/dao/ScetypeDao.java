package com.gsd.dao;

import com.gsd.entity.Scenery;
import com.gsd.entity.Scetype;

import java.util.List;

/**
 * 使用MyBatis的时候Dao层不需要@Repository注解
 */

public interface ScetypeDao {

    public List<Scetype> findAll();

    public Scetype findOne(Long id);
}
