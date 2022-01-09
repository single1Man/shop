package com.service;

import com.dao.collectDao;
import com.dao.productDao;
import com.pojo.Collect;
import com.pojo.Product;

import java.util.List;

public class collectService {
    productDao productDao=new productDao();
    collectDao collectDao=new collectDao();
    public int addCollect(String username, String pid) {
        Product product = productDao.findProductByPid(pid);
        return collectDao.addCollect(username,pid,product.getPname());
    }

    public int deleteCollect(String username, String pid) {
        return collectDao.deleteCollect(username,pid);
    }

    public List<Collect> findCollectsByUsername(String username) {
        return collectDao.findCollectsByUsername(username);
    }

    public int findCollect(String username, String pid) {
        if (collectDao.findCollect(username,pid)!=null){
            return 1;
        }
        return 0;
    }
}
