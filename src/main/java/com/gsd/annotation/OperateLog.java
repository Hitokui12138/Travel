package com.gsd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

//注解的代码看一下@SuppressWarning
//用这个注解来保存数据 @OperateLog(operatemsg = "查询所有景点", logtype = "查询",requestmethod = "get")
@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateLog {
    String operatemsg();
    String logtype();
    String requestmethod();
}
