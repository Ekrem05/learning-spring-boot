package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    private void generalPointcutLogg() {}

    @Before("generalPointcutLogg()")
    public void basicLog() {
        System.out.println("Basic logging..");
    }

    @Before("generalPointcutLogg()")
    public void logTime() {
        System.out.println(Instant.now().toString());
    }
}
