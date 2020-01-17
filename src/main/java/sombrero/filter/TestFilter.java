package sombrero.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/test/*")
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init TestFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("----------- before filter -----------");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("----------- after filter -----------");
    }

    @Override
    public void destroy() {
        log.info("destroy TestFilter");
    }

}
