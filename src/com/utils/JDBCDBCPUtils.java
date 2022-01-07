package com.utils;

import org.apache.commons.dbcp.BasicDataSource;


public class JDBCDBCPUtils {
	private static final String drivers ="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/shop?serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8";
	private static final String user="root";
	private static final String password="123456";
	//创建连接池对象
	public static BasicDataSource datasource=new BasicDataSource();

	static {
		try {
			
			//对连接池对象进行基本的配置
			datasource.setDriverClassName(drivers);
			datasource.setUrl(url);
			datasource.setUsername(user);
			datasource.setPassword(password);
			//最大连接数
			datasource.setMaxActive(10);
			//最小空闲连接
			datasource.setMinIdle(2);
			//最大空闲连接
			datasource.setMaxIdle(5);
			//初始化连接
			datasource.setInitialSize(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//返回连接池对象
	public static  BasicDataSource getDataSource(){
		return datasource;
	}

}
