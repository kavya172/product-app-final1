package com.training.pms.galaxe.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspects {
    
    @Before(value = "execution(* com.training.pms.galaxe.service.ProductserviceImpl.*(..))")
    public void dologging() {
        System.out.println("###Logged in at :"+new Date()+" By Aspects");
    }
    
    @After(value = "execution(* com.training.pms.galaxe.service.ProductserviceImpl.*(..))")
    public void dologging1() {
        System.out.println("###Logged in at :"+new Date()+" By Aspects");
    }
    @Around(value = "execution(* com.training.pms.galaxe.service.ProductserviceImpl.*(..))")
    public Object dosomeWork(ProceedingJoinPoint joinpoint) throws Throwable {
        System.out.println("#Before the method s called :"+new Date()+" By Aspects");
        joinpoint.proceed();
        Object retval = joinpoint.proceed();
        System.out.println("#Before the method s called :"+new Date()+" By Aspects");
        
        return retval;
    }
    
    
    
    @Before(value = "execution(* com.training.pms.galaxe.service.ProductserviceImpl.*(..))")
    public void doLogin() {
        System.out.println("###Logged in at :"+new Date()+" By Aspects");
    }
    @After(value = "execution(* com.training.pms.galaxe.service.ProductserviceImpl.*(..))")
    public void dologout() {
        System.out.println("###Logged out at :"+new Date()+" By Aspects");
    }


}
