package sombrero.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 필터 만들기.
 */
@Slf4j
@WebFilter(urlPatterns = "/test/*")
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("##### [TestFilter] init TestFilter!!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("##### [TestFilter] ----------- before filter -----------");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("##### [TestFilter] ----------- after filter -----------");
    }

    @Override
    public void destroy() {
        log.info("##### [TestFilter] destroy TestFilter!!");
    }

}
