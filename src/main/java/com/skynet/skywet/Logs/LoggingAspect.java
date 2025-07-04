package com.skynet.skywet.Logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.skynet.skywet.Service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        joinPoint.getSignature().getName();
        logger.info("method "+joinPoint.getSignature().getName() + " is called Before execution");
    }
    @AfterThrowing("execution(* com.skynet.skywet.Service.*.*(..))")
    public void logAfterError(JoinPoint joinPoint) {
        joinPoint.getSignature().getName();
        logger.info("method "+joinPoint.getSignature().getName() + " has caused an error");
    }
    @AfterReturning("execution(* com.skynet.skywet.Service.*.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
        joinPoint.getSignature().getName();
        logger.info("method "+joinPoint.getSignature().getName() + " has returned successfully");
    }
    @After("execution(* com.skynet.skywet.Service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        joinPoint.getSignature().getName();
        logger.info("method "+joinPoint.getSignature().getName() + " is called After execution");
    }
}
