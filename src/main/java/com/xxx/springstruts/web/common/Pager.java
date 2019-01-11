package com.xxx.springstruts.web.common;

import java.util.List;
import java.util.Map;


public class Pager {
	public static final int MAX_PAGE_SIZE=50;
	private int page=1;
	private int size=10;
	private List<?> content;
	private long total = 0;
	private int pageCount=0;
	private Map<String, Object> searchProps;
	public enum OrderType{
		asc,
		desc
	}
	private String orderBy = "createDate";
	private OrderType orderType = OrderType.desc;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page<1) {
			page = 1;
		}
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if(size<1) {
			size = 1;
		}else if(size>MAX_PAGE_SIZE) {
			size = MAX_PAGE_SIZE;
		}
		this.size = size;
	}
	public List<?> getContent() {
		return content;
	}
	public void setContent(List<?> content) {
		this.content = content;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	public int getPageCount() {
		pageCount = (int)total/size;
		if(total % size > 0) {
			pageCount++;
		}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Map<String, Object> getSearchProps() {
		return searchProps;
	}
	public void setSearchProps(Map<String, Object> searchProps) {
		this.searchProps = searchProps;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
}
