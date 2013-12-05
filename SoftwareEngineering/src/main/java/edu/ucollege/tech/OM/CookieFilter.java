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
                if( ck.getName().toString().equals("Role")){
                	
                    req.setAttribute("Role", ck.getValue());
                } else if(ck.getName().toString().equals("AccountID")){
                	
                    req.setAttribute("AccountID", ck.getValue());
            	}else{
                    req.setAttribute("AccountID", "0");
                    req.setAttribute("Role", "0");
                }
               
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