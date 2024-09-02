package cglib;

import dynamics.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DynamicsProxy.java
 * @Description 使用继承来实现
 * @createTime 2023年09月15日 10:19:00
 */
public class CGlibProxy {

    @Test
    public void test() {
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
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HotelServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * 1.代理对象本神
             * 2.方法
             * 3,参数
             * 4.代表被代理的目标对象的方法,并不是目标对象
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName());
                System.out.println(methodProxy.getClass().getName());
                Object res = null;

                try {
                    System.out.println("前置通知");
                    res = methodProxy.invoke(service,objects);
                    System.out.println("后置通知");
                }catch (Exception e){
                    System.out.println("回滚事务");
                }finally {
                    System.out.println("改回自动提交");
                }
                return res;
            }
        });
        HotelServiceImpl proxy = (HotelServiceImpl)enhancer.create();//用父类去接收

        System.out.println(proxy.getClass().getName());
        proxy.add(10);
    }

/**
 * class $CGLIProxy extend HotelServcieImpl
 */
}
