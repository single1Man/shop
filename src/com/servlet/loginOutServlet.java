package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class loginOutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用户注销
        request.getSession().removeAttribute("user");
        // 从客户端删除自动登录的cookie
        Cookie cookie = new Cookie("autoLoginCookie", "msg");
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        Cookie [] cookies = request.getCookies();
        for(Cookie rememberUsernameCookie:cookies){
            if (rememberUsernameCookie.getName().equals("rememberUsernameCookie")){
                HttpSession session = request.getSession();
                session.setAttribute("username",rememberUsernameCookie.getValue());
            }
        }
        // 转发
        response.sendRedirect("login.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
