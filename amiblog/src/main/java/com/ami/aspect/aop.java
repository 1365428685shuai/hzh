package com.ami.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@Aspect
@Component
public class aop {
    @Pointcut("execution(* com.ami.controller.web.TestController.*(..))")
    public void start(){
    }
    /*@Around("start()")
    public Object test(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("我是pjp，我代表："+pjp);
        Object target = pjp.getTarget();
        System.out.println("我是target："+target);
        Signature signature = pjp.getSignature();
        System.out.println("我是signature:"+signature);
        // 获取类名
        String className = pjp.getTarget().getClass().getName();
        System.out.println("类名："+className);
        // 获取方法参数
        Object[] args = pjp.getArgs();
        System.out.println("参数："+args[0]);
        // 获取方法名
        String methodName = pjp.getSignature().getName();
        System.out.println("方法名："+methodName);

        // 获取类对象
        Class<?> aClass = pjp.getTarget().getClass();

        Object proceed = pjp.proceed(args);
        return proceed;
    }*/
    // aop之获取方法对象
    @Around("start()")
    public Object test(ProceedingJoinPoint pjp) throws Throwable {
        // 1.获取方法参数
        Object[] args = pjp.getArgs();
        // 2.使用反射获取被拦截的方法所在的类对象
        Class<?> aClass = pjp.getTarget().getClass();
        // 2.1获取方法的名称
        String methodName = pjp.getSignature().getName();
        // 2.2获取方法的形参的类型
        Class<?> parmName = args[0].getClass();
        // 3.通过反射获取方法对象；
        Method[] pubMethods = aClass.getMethods();// 获取所有的public修饰的方法
        Method pubMethod = aClass.getMethod(methodName,parmName);// 获取指定方法名称或者参数的public修饰的方法
        Method[] decMethods = aClass.getDeclaredMethods();// 获取所有的方法，包括private修饰的方法
        Method decMethod = aClass.getDeclaredMethod(methodName,parmName);// 获取指定方法名称或者参数的方法，包括private修饰的方法
        // 2.正常执行方法
        Object proceed = pjp.proceed(args);
        return proceed;
    }
}
