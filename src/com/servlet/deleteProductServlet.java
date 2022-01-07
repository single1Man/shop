package com.servlet;

import com.service.productService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class deleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pid=request.getParameter("pid");
        productService productService = new productService();
        if (productService.deleteProduct(pid)>0){
            request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
