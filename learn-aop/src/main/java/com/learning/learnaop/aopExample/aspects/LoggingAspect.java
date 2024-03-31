package com.learning.learnaop.aopExample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger((getClass()));

    //PointCut -> When to do?
    @Before("com.learning.learnaop.aopExample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBefore(JoinPoint joinPoint) {
        logger.info("Before Aspect - {} is called with args {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.learning.learnaop.aopExample.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfter(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed", joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.learning.learnaop.aopExample.aspects.CommonPointcutConfig.dataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("After Throwing Aspect - {} has thrown an exception {}", joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.learning.learnaop.aopExample.aspects.CommonPointcutConfig.dataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue) {
        logger.info("After Returning Aspect - {} has executed and returned {}", joinPoint, resultValue);
    }
}
