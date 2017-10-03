package net.zonia3000.servletdemo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@WebFilter(urlPatterns = "/*")
public class Filtro implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getHeader("user-agent").contains("Chrome")) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Usa Firefox!");
        } else {
            chain.doFilter(request, response);
        }
    }
    
    @Override
    public void destroy() {
        
    }
    
}
