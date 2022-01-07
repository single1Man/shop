package com.service;

import com.dao.categoryDao;
import com.pojo.Category;

import java.util.List;

public class categoryService {
    categoryDao categoryDao=new categoryDao();
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
