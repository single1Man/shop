package com.servlet;

import com.pojo.User;
import com.service.userService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userService userService = new userService();
        User user = userService.findUserByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("product_list.jsp");
            } else {
                request.setAttribute("passwordError", "密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("noUserMsg", "没有这个用户");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
