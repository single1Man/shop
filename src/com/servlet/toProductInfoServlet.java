package com.servlet;

import com.pojo.Product;
import com.service.collectService;
import com.service.productService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class toProductInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pid=request.getParameter("pid");
        String username=request.getParameter("username");
        collectService collectService=new collectService();
        int isCollected = collectService.findCollect(username, pid);
        productService productService = new productService();
        Product product = productService.findProductByPid(pid);
        request.setAttribute("product",product);
        if (isCollected==0){
            request.setAttribute("isCollected",null);
        }else {
            request.setAttribute("isCollected","notNull");
        }
        request.getRequestDispatcher("/product_info.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
