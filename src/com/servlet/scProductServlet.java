package com.servlet;

import com.pojo.Product;
import com.service.collectService;
import com.service.productService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class scProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        collectService collectService=new collectService();
        String pid = request.getParameter("pid");
        String username=request.getParameter("username");
        productService productService = new productService();
        Product product = productService.findProductByPid(pid);
        String str=request.getParameter("str");
        request.setAttribute("product",product);
        if (username==null|| username.equals("")){
            response.sendRedirect("login.jsp");
        }else {
            if("add".equals(str)){
                if (collectService.addCollect(username,pid)>0){
                    request.setAttribute("msg","notNull");
                    request.getRequestDispatcher("/product_info.jsp").forward(request,response);
                }
            }else {
                if(collectService.deleteCollect(username,pid)>0){
                    request.setAttribute("msg",null);
                    request.getRequestDispatcher("/product_info.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","notNull");
                    request.getRequestDispatcher("/product_info.jsp").forward(request,response);
                }
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
