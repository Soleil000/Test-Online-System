package com.hp.onlinexam.po;

import java.io.Serializable;
import java.util.List;

public class Pager {
	private int currentPage;
    private int totalPage;
    private int count;
    private List content;
    private int totalCount;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public List getContent() {
		return content;
	}
	public void setContent(List content) {
		this.content = content;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
    
}
