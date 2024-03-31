package com.learning.learnaop.aopExample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
//    @Around("com.learning.learnaop.aopExample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    @Around("com.learning.learnaop.aopExample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Start a timer
        long startTimeMillis = System.currentTimeMillis();

        //Execute a method
        Object returnValue = proceedingJoinPoint.proceed();

        //Stop the time
        long stopTimeMillis = System.currentTimeMillis();

        long executionTimeMillis = stopTimeMillis - startTimeMillis;

        logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionTimeMillis);

        return returnValue;
    }
}
