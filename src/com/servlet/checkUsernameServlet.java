package com.servlet;

import com.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class checkUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        userService userService=new userService();
        if (userService.findUserByUsername(username)!=null){
            response.getWriter().write("不可以使用");
        }else {
            response.getWriter().write("可以使用");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
