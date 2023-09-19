package com.gsd.controller;

import com.gsd.exception.UserNameException;
import com.gsd.vo.Result;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
//这次返回一个JSON试一试,用assignableTypes约束一下作用范围
//@RestController
@RestControllerAdvice(assignableTypes = {AdminController.class})
public class AdminExceptionHandler {
    //从上往下匹配
    @ExceptionHandler(UserNameException.class)
    //@ResponseBody @RestControllerAdvice是个复合注解,已经带有ResponseBody了
    public Result UserNameException(Exception e, Model model){
        model.addAttribute("e", e.getMessage());
        return new Result(false,e.getMessage());//发生任何异常都跳转到这个页面
    }
}
