package com.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class AutoLoginFilter1
 */
public class AutoLoginFilter1 implements Filter {

    /**
     * Default constructor.
     */
    public AutoLoginFilter1() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse rep=(HttpServletResponse) response;
        //用户登录的信息
        String username = (String) req.getSession().getAttribute("username");
        if(username !=null){
            chain.doFilter(request, response);
            return;
        }
        // 如果session没有值,看cookie中有没有值
        Cookie[] cookies = req.getCookies();
        Cookie userCookie=null;
        //如果已经登陆 ,放行,不需要自动登陆
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if("rememberUsernameCookie".equals(cookie.getName())){
                    userCookie=cookie;
                    break;
                }
            }
        }
        //判断自动登陆cookie是否存在,如果没有cokkie ,不需要自动登陆
        if(userCookie==null){
            chain.doFilter(request, response);
            return;
        }
        String usernamec = userCookie.getValue();


        req.getSession().setAttribute("username", usernamec);
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}