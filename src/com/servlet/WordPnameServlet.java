package com.servlet;

import com.pojo.Product;
import com.service.productService;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WordPnameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String word = request.getParameter("word");
        productService productService =new productService();
        List<Product> allProduct=productService.findallByWordPname(word);
        //转换为json数组对象 发送给前端
        JSONObject object = new JSONObject();
        try {
            object.put("products",allProduct);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        org.json.JSONArray products=new org.json.JSONArray();
        try {
            products = object.getJSONArray("products");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().write(products.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
