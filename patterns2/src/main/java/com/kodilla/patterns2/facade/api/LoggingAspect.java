package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logBeforeProcessOrder(JoinPoint joinPoint) {
        LOGGER.info("Executing method: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            LOGGER.info("Argument: " + arg);
        }
    }
}