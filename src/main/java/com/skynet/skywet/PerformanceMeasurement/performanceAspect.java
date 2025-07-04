package com.skynet.skywet.PerformanceMeasurement;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class performanceAspect {
    @Around("execution(* com.skynet.skywet.Service.*.*(..))")
    public Object measurePerformance(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Execution time of " + methodName + ": " + duration + " ms");
        return result;
    }
}
