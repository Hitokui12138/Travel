package com.gsd.dao;

import com.gsd.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminDao {
    //登陆方法
    //admin,name是关键字,注意需要用单引号转义
    //有两个参数的时候需要绑定参数
    //  AND admin_pwd = #{password}
    @Select("Select adminid, admin_name, `admin`, admin_pwd, telephone, admin_sex FROM t_admin WHERE `admin` = #{username}")
    public Admin login(@Param("username") String username);//,@Param("password") String password);



}