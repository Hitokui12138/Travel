package com.gsd.controller;

import com.gsd.entity.Admin;
import com.gsd.service.AdminService;
import com.gsd.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminController.java
 * @Description TODO
 * @createTime 2023年09月18日 13:01:00
 */
@Controller
@RequestMapping("admin")
@SessionAttributes("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 登录
     * @param username
     * @param password
     * @param model
     * @return
     */
    @GetMapping("login")
    @ResponseBody
    public Result login(String username, String password, Model model){
        Admin admin = adminService.login(username, password);
        System.out.println("用户B也提交");
        System.out.println("用户A修改Bug");
        System.out.println("在Brach上提交");
        //失败的话已经被处理掉了,走到这里一定是成功了
        model.addAttribute("admin", admin);//也给Session保存一份
        return new Result("登录成功",admin);
    }

    /**
     * 退出
     */
    @GetMapping("logout")
    public void logout(SessionStatus status){
        status.setComplete();//销毁Session
    }

}
