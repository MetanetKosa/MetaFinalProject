package com.example.metawater.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component("LogAspect")
public class LogAspect {

    @Around("execution(* com..service.*Service.*(..))")
    public Object loggin(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();
        log.info("* ==> LogAspect Root: " + pjp.getSignature().getDeclaringTypeName());
        log.info(("** ==> LogAspect Method: " + pjp.getSignature().getName()));
        return result;
    }
}
