package com.vo;

import com.pojo.Product;

import java.util.List;

public class PageBean {
	
	private int pageNumber;//当前页
	private int pageSize;//每页显示个数 固定值,也可以是浏览器传递过来
	private int totalRecord;//总记录数  数据库查询
	private int totalPage;//总分页数
	private int startIndex;//开始索引
	private List<Product> data;//分页数据  数据库查询
	
	public PageBean(int pageNumber, int pageSize, int totalRecord ){
			this.pageNumber=pageNumber;
			this.pageSize=pageSize;
			this.totalRecord=totalRecord;
			//计算总分页数
			this.totalPage =(this.totalRecord+this.pageSize-1)/this.pageSize;
			//开始索引
			this.startIndex=(this.pageNumber-1)*pageSize;
	}
	public PageBean(){
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public List<Product> getData() {
		return data;
	}
	public void setData(List<Product> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PageBean [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", startIndex=" + startIndex + ", data=" + data + "]";
	}
	
	
}
