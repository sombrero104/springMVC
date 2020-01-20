package sombrero.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TestAspect {

    // sombrero
    @Before("execution(* sombrero.*(..))")
    public void before(JoinPoint joinPoint) {

    }


}
