package com.gsd.service;

import com.gsd.dao.AdminDao;
import com.gsd.entity.Admin;
import com.gsd.exception.UserNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminService.java
 * @Description TODO
 * @createTime 2023年09月18日 12:58:00
 */
@Service
@Transactional
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public Admin login(String usernmae, String password){
        Admin admin = adminDao.login(usernmae);
        if(admin == null){
            throw new UserNameException("用户名输入错误");
        }else{
            if(!admin.getAdminPwd().equals(password)){
                throw new UserNameException("密码输入错误");
            }
        }
        return admin;
    }
}
