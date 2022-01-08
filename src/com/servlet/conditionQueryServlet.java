package com.servlet;

import com.pojo.Category;
import com.service.categoryService;
import com.service.productService;
import com.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class conditionQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接收分页传过来的参数
        String pageNumberStr = request.getParameter("pageNumber");
        Integer pageSize=5;
        int pageNumber;
        if(pageNumberStr==null){
            pageNumber=1;
        }else{
            pageNumber=Integer.parseInt(pageNumberStr);
        }
//		接收查询条件的参数
        String cid = request.getParameter("cid");
        String pname = request.getParameter("pname");
        categoryService categoryService = new categoryService();
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("allCategory",categoryList);
        productService productService = new productService();
        PageBean pageBean = productService.findProductsByCondition(cid, pname, pageNumber, pageSize);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("cid",cid);
        request.setAttribute("pname",pname);
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
