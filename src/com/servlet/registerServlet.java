package com.servlet;

import com.pojo.User;
import com.service.userService;
import com.utils.checkUserUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        userService userService=new userService();
        System.out.println("hello");
        User user=new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String confirmPassword=request.getParameter("confirmPassword");
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        user.setUid(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        if (new checkUserUtils().checkUser(user, confirmPassword)){
            if (userService.register(user)>0){
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else {
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
