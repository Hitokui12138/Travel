package com.gsd.aop;

import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelServiceImpl.java
 * @Description 目标类
 * @createTime 2023年09月15日 10:16:00
 */

//@Service
public class HotelServiceImpl{

    /**
     * Spring创建对象,没法自己写代理
     * 也不能给每一个类加上代理
     *
     *
     * Spring需要知道
     * 1哪些类哪些方法需要增强
     * 2增强什么
     *
     * 1.写一个切面类
     *
      */

    public int add(int i) {
        System.out.println("add "+i);
        return i;
    }


    public void del() {

    }
}
