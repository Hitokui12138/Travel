package com.gsd.dao;

import com.gsd.entity.Hotel;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelSqlBuilder.java
 * @Description 这个是通过反射获取的,不能携程内部类
 * @createTime 2023年09月14日 13:23:00
 */

//用动态sql写Where条件
public class HotelSqlBuilder {

    public String builderFindAll(final Hotel hotel){
        String sql = new SQL() {{   //两个大括号?
            SELECT("hotelid,hotelname,in_time,out_time,pic,hotelareaid,roomtypeid,context,collection,favorite,room_count,site,hotelphone,price");
            FROM("t_hotel");
//            if (hotel.getHotelname() != null && !hotel.getHotelname().equals("")) {
//                WHERE("hotelname like '%${hotelname}%'");
//            }
            //spring core提供的工具类,可以简化写法
            //注意这里第一条不能写AND()
            if(StringUtils.isEmpty(hotel.getHotelname())){
                WHERE("hotelname like '%${hotelname}%'");
            }
            if (StringUtils.isEmpty(hotel.getHotelareaid())) {
                AND();
                WHERE("hotelareaid = #{hotelareaid}");
            }
            ORDER_BY("hotelid desc");
        }}.toString();
        System.out.println("builderFindAll:" + sql);
        return sql;
    }
}
