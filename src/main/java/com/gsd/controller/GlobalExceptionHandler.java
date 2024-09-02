package com.gsd.controller;

import com.gsd.exception.UserNameException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName GlobalExceptionHandler.java
 * @Description TODO
 * @createTime 2023年09月18日 09:50:00
 */
/*
现在这种是返回页面,国内用JSON比较多
如果需要写入日志的话,
和Operatelog二选一
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //从上往下匹配
    @ExceptionHandler(UserNameException.class)
    public String UserNameException(Exception e, Model model){
        System.out.println("发生UserNameException");
        model.addAttribute("e", e.getMessage());
        return "index";//发生任何异常都跳转到这个页面

    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model){
        System.out.println("发生通用异常");
        model.addAttribute("e", e.getMessage());
        return "500";//发生任何异常都跳转到这个页面,反正不能跳到自带的500错误页面

    }

}
