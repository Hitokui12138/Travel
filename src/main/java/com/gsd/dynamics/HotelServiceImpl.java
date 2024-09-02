package com.gsd.dynamics;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelServiceImpl.java
 * @Description 目标类
 * @createTime 2023年09月15日 10:16:00
 */
public class HotelServiceImpl implements HotelService{

    /**
     * 只能在不改变源代码的情况下增强
     * 方法前和方法后
      */
    @Override
    public int add(int i) {
        System.out.println("add "+i);
        return 1;
    }

    @Override
    public void del() {

    }
}
