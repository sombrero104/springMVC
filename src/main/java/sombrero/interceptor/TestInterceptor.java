package sombrero.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 인터셉터 만들기.
 */
@Slf4j
public class TestInterceptor extends HandlerInterceptorAdapter {

    /**
     * PreHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
     * 컨트롤러(즉 RequestMapping이 선언된 메서드 진입) 실행 직전에 동작.
     * 반환 값이 true일 경우 정상적으로 진행이 되고, false일 경우 실행이 멈춥니다.(컨트롤러 진입을 하지 않음)
     * 전달인자 중 Object handler는 핸들러 매핑이 찾은 컨트롤러 클래스 객체입니다.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("##### [TestInterceptor] ----------- preHandle -----------");
        return true;
    }

    /**
     * PostHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
     * 컨트롤러 진입 후 view가 랜더링 되기 전 수행이 됩니다.
     * 전달인자의 modelAndView을 통해 화면 단에 들어가는 데이터 등의 조작이 가능합니다.
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("##### [TestInterceptor] ----------- postHandle -----------");
    }

    /**
     * afterComplete(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
     * 컨트롤러 진입 후 view가 정상적으로 랜더링 된 후 제일 마지막에 실행이 되는 메서드입니다.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("##### [TestInterceptor] ----------- afterCompletion -----------");
    }

    /**
     * afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
     * Servlet 3.0부터 비동기 요청이 가능해짐에 따라 비동기 요청 시 PostHandle와 afterCompletion메서드를 수행하지 않고 이 메서드를 수행하게 됩니다. (Spring에서 제공함)
     */
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("##### [TestInterceptor] ----------- afterConcurrentHandlingStarted -----------");
    }

}
