package com.filter;

import com.pojo.User;
import com.service.userService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // place your code here
        //强制
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse rep=(HttpServletResponse) response;
        //用户登录的信息
        String username = (String) req.getSession().getAttribute("username");
        //如果已经登陆 ,放行,不需要自动登陆
        if(username !=null){
            chain.doFilter(request, response);
            return;
        }
        // 如果session没有值,看cookie中有没有值
        Cookie[] cookies = req.getCookies();
        Cookie userCookie=null;
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if("autoLoginCookie".equals(cookie.getName())){
                    userCookie=cookie;
                    break;
                }
            }
        }
        //判断自动登陆cookie是否存在,如果没有cookie ,不需要自动登陆
        if(userCookie==null){
            chain.doFilter(request, response);
            return;
        }
        //cookie有值 ,取出cookie里面的值,然后进行登陆判断
        String[] u = userCookie.getValue().split("@");
        String usernamec=u[0];
        String passwordc=u[1];
        userService userService=new userService();
        User user = userService.findUserByUsername(usernamec);
        //判断用户名和密码是否成功
        //失败
        if(usernamec.equals(user.getUsername())&&passwordc.equals(user.getPassword())){
            chain.doFilter(request, response);
            return;
        }
        //自动登陆
        req.getSession().setAttribute("username", user.getUsername());
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
}
