package com.servlet;

import com.service.productService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class productPagingServlet extends HttpServlet {
    productService productService=new productService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接收分页传过来的参数
        String pageNumberStr = request.getParameter("pageNumber");
        int pageSize=5;
        int pageNumber;
        if(pageNumberStr==null){
            pageNumber=1;
        }else{
            pageNumber=Integer.parseInt(pageNumberStr);
        }
        request.setAttribute("pageBean", productService.findPaging(pageNumber,pageSize));
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
