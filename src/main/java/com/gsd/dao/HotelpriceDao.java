package com.gsd.dao;

import com.gsd.entity.Hotelprice;
import com.gsd.entity.HotelpriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelpriceDao {
    //查总数
    long countByExample(HotelpriceExample example);

    int deleteByExample(HotelpriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hotelprice record);

    int insertSelective(Hotelprice record);

    List<Hotelprice> selectByExample(HotelpriceExample example);

    Hotelprice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hotelprice record, @Param("example") HotelpriceExample example);

    int updateByExample(@Param("record") Hotelprice record, @Param("example") HotelpriceExample example);

    int updateByPrimaryKeySelective(Hotelprice record);

    int updateByPrimaryKey(Hotelprice record);
}