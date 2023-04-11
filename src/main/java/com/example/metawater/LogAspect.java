package com.example.metawater;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);
//aop사용할 때 참고
//    @Around("execution(* com.example.metawater.post.PostService.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("start- 시작 " + pjp.getSignature().getDeclaringTypeName() + "/" + pjp.getSignature().getName());
        Object result = pjp.proceed();
        logger.info("finished- 끝 " + pjp.getSignature().getDeclaringTypeName() + "/" + pjp.getSignature().getName());
        return result;
    }
}
