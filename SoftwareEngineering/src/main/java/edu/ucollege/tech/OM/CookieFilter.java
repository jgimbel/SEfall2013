package edu.ucollege.tech.OM;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        
        Cookie[] cookies = ((HttpServletRequest) req).getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if(ck.getName().toString().equals("lang")){
                    req.setAttribute("languageCookie", ck.getValue());
                } else {
                    req.setAttribute("languageCookie", "en");
                };
            }
            chain.doFilter(req, res);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }
    public void destroy() {
        // TODO Auto-generated method stub
    }
}