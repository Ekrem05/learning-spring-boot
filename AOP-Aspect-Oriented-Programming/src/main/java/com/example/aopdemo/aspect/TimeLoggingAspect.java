package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
@Order(1)
public class TimeLoggingAspect {
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    private void generalPointcutLogg() {}

    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    private void setter() {}

    @Before("generalPointcutLogg() && !(getter()||setter())")
    public void logTime() {
        System.out.println(Instant.now().toString());
    }
}
