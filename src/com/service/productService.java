package com.service;

import com.dao.productDao;
import com.pojo.Product;
import com.vo.PageBean;

public class productService {
    productDao productDao=new productDao();
    public PageBean findPaging(int pageNumber, int pageSize) {
        Integer totalRecord = productDao.findAllProductCount();
        PageBean pageBean=new PageBean(pageNumber,pageSize,totalRecord);
        int startIndex = pageBean.getStartIndex();
        pageBean.setData(productDao.findPaging(startIndex,pageSize));
        return pageBean;
    }

    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    public int deleteProduct(String pid) {
        return productDao.deleteProduct(pid);
    }

    public Product findProductByPid(String pid) {
        return productDao.findProductByPid(pid);
    }

    public int deleteProducts(String[] pids) {
        StringBuilder pidBuilder=new StringBuilder();
        pidBuilder.append("(");
        for (String pid : pids) {
            pidBuilder.append(pid);
        }
        pidBuilder.append(")");
        return productDao.deleteProducts(pidBuilder);
    }

    public int editProduct(Product product) {
        return productDao.editProduct(product);
    }
}
