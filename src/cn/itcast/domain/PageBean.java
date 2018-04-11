package cn.itcast.domain;

import org.apache.struts2.components.If;

import java.util.List;

public class PageBean<T> {
	//当前页数
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//总页数
	private Integer totalPage;
	//每页显示多少数目
	private Integer pageSize;
	//分页数据
	private List<T> pageBean;
	//要求初始化时对3变量赋值
	public PageBean(Integer currentPage,Integer pageSize,Integer totalCount) {
		if( currentPage==null||currentPage <1 ){
			this.currentPage=1;
		}else{
			this.currentPage = currentPage;
		}
		if (pageSize==null||pageSize==0){
			this.pageSize=3;
		}else {
			this.pageSize=pageSize;
		}
		this.totalCount = totalCount;
		this.totalPage = (this.totalCount + this.pageSize - 1)/this.pageSize;
		if(this.currentPage > totalPage){
			this.currentPage = totalPage;
		}
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getPageBean() {
		return pageBean;
	}

	public void setPageBean(List<T> pageBean) {
		this.pageBean = pageBean;
	}

	public int getStart(){
		return (this.currentPage-1)*pageSize;
	}
}
