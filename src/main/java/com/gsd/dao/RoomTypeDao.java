package com.gsd.dao;

import com.gsd.entity.Hotel;
import com.gsd.entity.HotelArea;
import com.gsd.entity.RoomType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoomTypeDao {
    public List<RoomType> findAll();

    @Select("SELECT roomtypeid,roomtype,roomprice,roomnum,acquiescence,hotelid,roomsize,intime,outtime FROM t_roomtype WHERE hotelid = #{hotelid}")
    public List<RoomType> findRoomtypeByHotelid(Long hotelid);

    public int updateByPrimaryKeySelective(RoomType roomType);


    @Insert("INSERT into t_roomtype (roomtypeid,roomtype,roomprice,roomnum,hotelid,intime,outtime) VALUES (#{roomtypeid},#{roomtype},#{roomprice},#{roomnum},#{hotelid},#{intime},#{outtime})")
    public int insertRoomtype(RoomType roomType);

    @Delete("DELETE FROM t_roomtype WHERE roomtypeid = #{roomtypeid}")
    public int deleteRoomtype(Long roomtypeid);
}
