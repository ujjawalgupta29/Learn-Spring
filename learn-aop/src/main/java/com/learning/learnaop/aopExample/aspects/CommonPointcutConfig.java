package com.learning.learnaop.aopExample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    @Pointcut("execution(* com.learning.learnaop.aopExample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.learning.learnaop.aopExample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.learning.learnaop.aopExample.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}
}
