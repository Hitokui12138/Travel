package com.gsd.aop;

import com.gsd.annotation.OperateLog;


import com.gsd.entity.Exceptions;
import com.gsd.entity.Operatelog;
import com.gsd.service.ExceptionsService;
import com.gsd.service.OperateLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OperatelogAspect.java
 * @Description TODO
 * @createTime 2023年09月18日 08:54:00
 */

//定义一个切面类,需要修改SpringMVC配置文件
@Component
@Aspect //
public class OperatelogAspect {

    //1. 切面表达式
    //扫描的是注解而不是方法,因此不能使用execute表达式
    //只能拦截
    @Pointcut("@annotation(com.gsd.annotation.OperateLog)")
    public void pc(){};

    @Autowired
    OperateLogService service;

    /*
    ProceedingJoinPoint 环绕用的,有四个方法
    这里用父类JoinPoint
    用反射取得
     */
    //2. 前置通知
    @Before("pc()")
    public void before(JoinPoint jp){
        /**
         * 先取得方法,然后再取得它的注解
         * method的父接口signature
         * 拿到一个Methodsignture,里面有需要的方法getmethod
         */
        System.out.println("切面类,取得注解,将log保存到数据库中");
        MethodSignature signature = (MethodSignature)jp.getSignature();
        Method method = signature.getMethod();

        //获取注解
        com.gsd.annotation.OperateLog annotation = method.getAnnotation(OperateLog.class);

        //获取注解信息
        //所有带Operate
        Operatelog operatelog = new Operatelog();
        operatelog.setOperatemsg(annotation.operatemsg());
        operatelog.setLogtype(annotation.logtype());
        operatelog.setRequestmethod(annotation.requestmethod());
        service.insert(operatelog);
        System.out.println("切面类,正常log保存完毕");
    }

    //3. 异常通知(这是其中一种异常处理方法,spring)
    //spring自带的
    /*
        写一个公共异常
        1. @ControllerAdvicer 对控制层生成代理对象,出异常后匹配方法,最后返回一个页面
        2. @RestControllerAdivcer 返回一个JSON
     */
    //需要数据量特别大的时候需要自己写
    @Autowired
    HttpServletRequest req;
    @Autowired
    HttpServletResponse resp;
    @Autowired
    ExceptionsService exceptionsService;

    @AfterThrowing("execution(* com.gsd.controller.*.*(..))")
    public void AfterThrowing(JoinPoint jp){
        try {
            System.out.println("切面类,异常通知");
            //获取方法,log注解
            MethodSignature signature = (MethodSignature)jp.getSignature();
            Method method = signature.getMethod();
            com.gsd.annotation.OperateLog annotation = method.getAnnotation(OperateLog.class);
            System.out.println(annotation);

            Exceptions exceptions = new Exceptions();
            exceptions.setId(0);
            exceptions.setMethodname(method.getName());
            exceptions.setMethodtype(annotation.logtype());
            exceptions.setRequesttype(annotation.requestmethod());
            exceptions.setIp(req.getRemoteAddr());
            exceptions.setUrl(req.getRequestURI());

            exceptionsService.insertSelective(exceptions);
            System.out.println("切面类,异常保存完毕");
            //resp.sendRedirect("/500.jsp");只能拦截,不能跳转
        }catch(Exception e){
            e.printStackTrace();//重定向需要try catch
        }
    }

}
