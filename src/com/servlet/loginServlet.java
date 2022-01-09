package com.servlet;

import com.pojo.User;
import com.service.couponService;
import com.service.userService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberUsername=request.getParameter("rememberUsername");
        userService userService = new userService();
        couponService couponService = new couponService();
        User user = userService.findUserByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                //登陆成功
                //自动登录开始
                String autoLogin = request.getParameter("autoLogin");
                if(autoLogin!=null){
                    //使用cookie记录用户信息,使用@拼凑
                    Cookie c=new Cookie("autoLoginCookie",username+"@"+password);
                    c.setPath("/");
                    c.setMaxAge(60);
                    response.addCookie(c);
                }
                if ("on".equals(rememberUsername)){
                    Cookie rememberUsernameCookie=new Cookie("rememberUsernameCookie",username);
                    rememberUsernameCookie.setPath("/");
                    rememberUsernameCookie.setMaxAge(30);
                    response.addCookie(rememberUsernameCookie);
                }
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                StringBuilder coupon_ids = userService.findCoupon_ids(username);
                session.setAttribute("coupons",couponService.findCoupons(coupon_ids));
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
