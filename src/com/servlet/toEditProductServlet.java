package com.servlet;

import com.pojo.Category;
import com.pojo.Product;
import com.service.categoryService;
import com.service.productService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class toEditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pid=request.getParameter("pid");
        productService productService = new productService();
        Product product = productService.findProductByPid(pid);
        categoryService categoryService = new categoryService();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("allCategory",categoryList);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/admin/product/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
