package fr.astek.gex.server.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author sdaclin
 * Adapted from http://solutionsfit.com/blog/2010/04/18/serving-up-jsonp-from-your-jax-rs-web-services/
 */
public class JSONPRequestFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            throw new ServletException("This filter can only process HttpServletRequest requests");
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (isJSONPRequest(httpRequest)) {
            ServletOutputStream out = response.getOutputStream();

            out.println(getCallbackMethod(httpRequest) + "(");
            chain.doFilter(request, response);
            out.println(");");

            response.setContentType("text/javascript");
        } else {
            chain.doFilter(request, response);
        }
    }

    private String getCallbackMethod(HttpServletRequest httpRequest) {
        return httpRequest.getParameter("jsonp");
    }

    private boolean isJSONPRequest(HttpServletRequest httpRequest) {
        String callbackMethod = getCallbackMethod(httpRequest);
        return (callbackMethod != null && callbackMethod.length() > 0);
    }

    public void init(FilterConfig fc) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
