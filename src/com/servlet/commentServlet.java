package com.servlet;

import com.pojo.Comment;
import com.service.commentService;
import com.service.productService;
import com.utils.timeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class commentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String pid = request.getParameter("pid");
        String content = request.getParameter("content");
        String pname = new productService().findProductByPid(pid).getPname();
        commentService commentService=new commentService();
        String date=new timeUtils().getTime(new Date());
        commentService.addComment(username,pname,content,date);
        List<Comment> commentList = commentService.findCommentByPid(pname);
        JSONObject object = new JSONObject();
        try {
            object.put("comments",commentList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray comments=new JSONArray();
        try {
            comments = object.getJSONArray("comments");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(comments);
        response.getWriter().write(comments.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
