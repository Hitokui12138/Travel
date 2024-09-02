package com.gsd.dao;

import com.gsd.entity.Scenery;


import java.util.List;

/**
 * 使用MyBatis的时候Dao层不需要@Repository注解
 */

public interface SceneryDao {
    public List<Scenery> findAll(Scenery scenery);

    public List<Scenery> findAllSeason();

    public int addScenery(Scenery scenery);

    //选择性地添加
    public int addScenerySelective(Scenery scenery);

    public int updateScenery(Scenery scenery);

    public int updateScenerySelective(Scenery scenery);

    public Scenery findSceneryBysceid(Long sceid);

    public int deleteById(Long sceid);

    public int batchDelete(int ... sceids);//这样没有数组时也不需要传值

}
