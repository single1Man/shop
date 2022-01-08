package com.servlet;

import com.service.collectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class findCollectsByUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        collectService collectService=new collectService();
        if (username!=null){
            request.setAttribute("collects",collectService.findCollectsByUsername(username));
            request.getRequestDispatcher("/favorite.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
