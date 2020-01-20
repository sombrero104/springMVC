package sombrero.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP 테스트.
 *
 * 예제로 사용할 대상은 'sombrero.service.*.*(..)'
 * => sombrero.service 패키지의 모든 클래스의 모든 메소드
 */
@Aspect
@Component
@Slf4j
public class TestAspect {

    /**
     * @Before
     * 메서드의 실행 전에 공통로직을 적용하고 싶을 때 사용.
     */
    @Before("execution(* sombrero.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("##### [TestAspect] ----------- Before -----------");
    }

    /**
     * @After
     * 메서드의 실행 후에 공통로직을 적용하고 싶을 때 사용.
     */
    @After("execution(* sombrero.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("##### [TestAspect] ----------- After -----------");
    }

    @AfterReturning(pointcut = "execution(* sombrero.service.*.*(..))", returning = "str")
    public void afterReturning(JoinPoint joinPoint, Object str) {
        log.info("##### [TestAspect] ----------- AfterReturning, str: " + str + " -----------");
    }

    /**
     * @AfterThrowing
     * 대상 객체의 메서드를 실행하는 도중 예외가 발생한 경우에 공통 기능을 실행.
     */
    @AfterThrowing(pointcut = "execution(* sombrero.service.*.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.info("##### [TestAspect] ----------- AfterThrowing, ex: " + ex + " -----------");
    }

    @Pointcut("execution(* sombrero.service.*.*(..))")
    public void pointcut(JoinPoint joinPoint) {
        log.info("##### [TestAspect] ----------- Pointcut -----------");
    }

    /**
     * @Around
     * 메서드의 실행 전/후에 공통로직을 적용하고 싶을 때 사용.
     */
    @Around("execution(* sombrero.service.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("##### [TestAspect] ----------- Around start "
                + joinPoint.getSignature().getDeclaringTypeName()
                + joinPoint.getSignature().getName()
                + " -----------");
        joinPoint.proceed();
        log.info("##### [TestAspect] ----------- Around end "
                + joinPoint.getSignature().getDeclaringTypeName()
                + joinPoint.getSignature().getName()
                + " -----------");
    }

}
