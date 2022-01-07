package com.servlet;

import com.pojo.Category;
import com.service.categoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class toAddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        categoryService categoryService = new categoryService();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("allCategory",categoryList);
        request.getRequestDispatcher("/admin/product/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
