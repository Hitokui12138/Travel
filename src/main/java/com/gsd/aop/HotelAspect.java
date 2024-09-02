package com.gsd.aop;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelAspect.java
 * @Description TODO
 * @createTime 2023年09月15日 13:38:00
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ASPECT不再核心包里,导入包
 * 这个包里都是接口,哈需要第三方的实现
 * 一共两个包
 *
 *
 * 1.把目标对象和切面类导入Spring,使用@Component
 * 2. Spring只认识那四种注解,不认识@Aspect,也不知道去扫描@Pointcut之类的
 *
 * 切面类定义两个东西
 * 1使用`切面表达式`,哪些类哪些方法需要增强
 * 2使用五种通知进行`增强`
 *
 *
 */

//@Aspect //表示是一个切面类,定义增强
//@Component //让Spring扫描这个
public class HotelAspect {
    /*
    1.哪些类哪些方法需要增强,使用切面表达式,也有其他方法
        1. execution表达式,*表示 返回任意类型,功能更强大一些
        2. within  官方自带的
        3. 也有一些注解
     */

    //@Pointcut("execution(public int com.gsd.aop.HotelServiceImpl.add(int)) || execution(public void com.gsd.aop.HotelServiceImpl.del())")
    //@Pointcut("execution(* *.*.*.HotelServiceImpl.add(int))")//如过使用这种方法的话,必须有三层结构
    //@Pointcut("execution(* com..HotelServiceImpl.add(int))")//两个点表示子包,不管几层
    //@Pointcut("execution(* com..*.add(int))") //任意类
    //@Pointcut("execution(* com..*.*(int))") //任意类的任意方法,但是要求参数是int
    //@Pointcut("execution(* com..*.*(*))") //任意参数,但是必须有参
    //@Pointcut("execution(* com.gsd.aop.*.*(..))")//有参无参都可以
    //@Pointcut("execution(* *..*.*(..))")//全都匹配
    //推荐写法 @Pointcut("execution(* com.gsd.service.*.*(..))")
    @Pointcut("execution(* com.gsd.aop.*.*(..))")//有参无参都可以
    public void pc(){};//没什么用,只 是用来定义切面表达式

    /*
    通知 一共有5种通知的位置
    前置通知,后置,异常,最后,环绕
     */
//    @Before("pc()")//可以用上面定义好的,也可以写表达式单独使用
//    public void Before(){
//        System.out.println("前置通知:开启事务");
//    }
//
//    @AfterReturning("pc()")//没有异常的话提交事务
//    public void afterReturning(){
//        System.out.println("后置通知:提交事务");
//    }
//
//    @AfterThrowing(value = "pc()",throwing = "e")//可以获取到这个异常
//    public void afterThrowing(Exception e){
//        System.out.println(e.getMessage());
//        System.out.println("异常通知:回滚");
//    }
//
//    @After("pc()")
//    public void after(){
//        System.out.println("最终通知:改回自动提交");
//    }

    /*
    环绕通知,手动写增强代码
    注意返回类型和参数ProceedingJoinPoint

    和自动的一样
     */
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        Object res = null;
        try {
            System.out.println("前置通知:开启事务");
            res = pjp.proceed(pjp.getArgs());//里面都是用的反射
            System.out.println("后置通知:提交事务");
        }catch (Throwable e){
            System.out.println(e.getMessage());
            System.out.println("异常通知:回滚");
        }finally {
            System.out.println("最终通知:改回自动提交");
        }
        return res;

    }

    /**
     * JoinPoint 连接点(可以被增强的)
     * 指的是那些类的哪些方法可以被增强
     *
     * Pointcut 切入点(带小图标的) 向右边的图标
     * 哪些类和方法被增强了
     *
     * Advice 通知,需要的增强
     * 具体的增强代码
     *
     * Target 目标对象
     * 被代理的对象
     *
     * Weaving 织入
     * 把增强应用到对象,从而生成代理对象的`过程`
     *
     * Proxy 代理
     * 织入的结果,生成一个代理对象
     *
     * Aspect 切面
     * 切入点+通知的结合
     * 切面类就是定义切面的,在不改变源代码的情况下,在方法的某一个位置添加代码
     *
     *
     */

}
