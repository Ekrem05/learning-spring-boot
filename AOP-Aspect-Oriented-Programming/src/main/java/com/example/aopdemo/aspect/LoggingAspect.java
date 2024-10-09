package com.example.aopdemo.aspect;

import com.example.aopdemo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    private void generalPointcutLogg() {}

    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    private void setter() {}

    @Before("generalPointcutLogg() && !(getter()||setter())")
    public void basicLog() {
        System.out.println("Basic logging..");
    }

    @Before("generalPointcutLogg() && !(getter()||setter())")
    public void logSignature(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();

        System.out.println("Arguments:");

        for (Object arg : args) {
            System.out.print(arg+" ");
        }

        System.out.println();
        System.out.println("Method: "+signature);
    }


    //Runs on successful execution
    @AfterReturning(pointcut = "execution(public * com.example.aopdemo.dao.AccountDAO.findAccount(..))",
    returning = "result")
    public void FindingAccount(JoinPoint joinPoint, Account result ) {
        System.out.println("Finding account result: "+result);
    }


    //Runs if exception is thrown
    @AfterThrowing(pointcut = "execution(public * com.example.aopdemo.dao.AccountDAO.findAccount(..))",
    throwing = "excep")
    public void FindingAccountException(JoinPoint joinPoint, Exception excep ) {
        System.out.println("Finding account exception: "+excep.getMessage());
    }


    //Runs always
    @After("execution(public * com.example.aopdemo.dao.AccountDAO.findAccount(..))")
    public void FindingAccountLog() {
        System.out.println("Finding Logg");
    }
}
