package com.service;

import com.dao.commentDao;
import com.pojo.Comment;

import java.util.List;

public class commentService {

    commentDao commentDao=new commentDao();
    public int addComment(String username, String pname, String content, String date) {
        return commentDao.addComment(username,pname,content,date);
    }

    public List<Comment> findCommentByPid(String pname) {
        return commentDao.findCommentByPid(pname);
    }
}
