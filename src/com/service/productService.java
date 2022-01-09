package com.service;

import com.dao.productDao;
import com.pojo.Product;
import com.vo.PageBean;

import java.util.ArrayList;
import java.util.List;

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

    public  PageBean findProductsByCondition(String cid, String pname, int pageNumber, Integer pageSize) {
        //平凑的sql语句 格式 and  属性 符号
        StringBuilder builder=new StringBuilder();
        //拼凑的实际参数
        List<Object> paramsList=new ArrayList<>();
        //分类不为空
        if(cid!=null && !cid.equals("")){
            builder.append(" and  cid=?");
            paramsList.add(cid);
        }
        //商品名称不为空
        if(pname!=null && !pname.equals("")){
            builder.append(" and pname like ?");
            paramsList.add("%"+pname+"%");
        }
        //转换成需要的类型
        String condition = builder.toString();
        //分页查询
        Object[] params1=paramsList.toArray();
        Integer totalRecord=productDao.findProductCountByCondition(condition,params1);
        PageBean pageBean=new PageBean(pageNumber,pageSize,totalRecord);

        paramsList.add(pageBean.getStartIndex());
        paramsList.add(pageBean.getPageSize());

        Object[] params = paramsList.toArray();

        List<Product> data=productDao.findAll(condition, params);
        pageBean.setData(data);
        return pageBean;
    }
    public List<Product> findallByWordPname(String word) {
        // TODO Auto-generated method stub
        return productDao.findallByWordPname(word);
    }
}
