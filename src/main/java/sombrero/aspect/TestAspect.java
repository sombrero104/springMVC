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

    /**
     * 'sombrero.service.*.*(..)'
     * => sombrero.service 패키지의 모든 클래스의 모든 메소드
     */
    @Before("execution(* sombrero.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("##### [TestAspect] ----------- before -----------");
    }

}
