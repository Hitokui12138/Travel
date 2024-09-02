package com.gsd.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DynamicsProxy.java
 * @Description TODO
 * @createTime 2023年09月15日 10:19:00
 */
public class DynamicsProxy {
    public static void main(String[] args) {
        /**
         * 1.怎么生成代理对象
         * 2.怎么调用代理对象的方法
         * 动态代理,代理对象和目标带想应该实现同样的接口
         *
         */

        /**
         * 三个参数
         * 1.为了生成代理类,因此需要一个类加载器
         * 2.获取目标对象的所有接口()
         * 3.实现InvocationHandler()的匿名内部类
         */
        //1.生成目标对象
        HotelServiceImpl service = new HotelServiceImpl();
        //2.生成代理对象,被这个类加载器加载了
        HotelService hs = (HotelService)Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * proxy就是hs,代理对象
                 * method 调用的方法
                 * args 如果有参数的话,这个时参数
                 */
                //但我门需要调用目标的对应的方法
//                System.out.println("InvocationHandler取得的方法名: "+method.getName());
//                Object res = method.invoke(service, args);//再使用反射去调用这个目标对象的这个方法
//                return res;
                Object res=null;
                try{
                    System.out.println("开启事务,commit改手动");
                    res = method.invoke(service, args);
                    System.out.println("提交事务");
                }catch (Exception e){
                    System.out.println("回滚事务");
                }finally {
                    System.out.println("commit改回来");
                }
                return res;
            }
        });

        System.out.println("代理对象: "+hs.getClass().getName());
        System.out.println(hs.add(10));//代理对象的方法`任何方法`都会去调用invoke()方法,实际上调用的时invoke()

    }
}

/**
 * 代理对象需要同样的接口
 * 在内存生成一个代理类 class $Proxy implements HotelService
 * 不能修改,不能new,是在运行时生成的
 */