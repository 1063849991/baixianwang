package com.zd.pojo;

public class FenYe {
	//当前请求的页码
	private Integer page;
	//每一页显示多少条
	private Integer rows=2;
	//符合要求的记录总数
	private Integer rowCount;
	//一共分多少页
	private Integer pageCount;
	//开始条数
	private Integer startRow;
	//结束条数
	private Integer endRow;
	//封装查询条件
	private Query query;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		if(getRowCount()%getRows()==0) {
			pageCount=getRowCount()/getRows();
		}else {
			pageCount=getRowCount()/getRows()+1;
		}
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		
		this.pageCount = pageCount;
	}
	public Integer getStartRow() {
		startRow=(getPage()-1)*getRows();
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		endRow=getPage()*getRows();
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	@Override
	public String toString() {
		return "FenYe [page=" + page + ", rows=" + rows + ", rowCount=" + rowCount + ", pageCount=" + pageCount
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", query=" + query + "]";
	}
	
}
