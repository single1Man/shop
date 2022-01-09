package com.pojo;

public class Comment {
    private Integer comment_id;
    private String username;
    private String pname;
    private String content;
    private String date;

    public Comment() {
    }

    public Comment(Integer comment_id, String username, String pname, String content, String date) {
        this.comment_id = comment_id;
        this.username = username;
        this.pname = pname;
        this.content = content;
        this.date = date;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
