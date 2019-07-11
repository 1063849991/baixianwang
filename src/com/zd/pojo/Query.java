package com.zd.pojo;

public class Query {
		//根据名字查询
		private String qename;
		//封装查询条件
		private Integer qdeptno;
		public String getQename() {
			return qename;
		}
		public void setQename(String qename) {
			this.qename = qename;
		}
		public Integer getQdeptno() {
			return qdeptno;
		}
		public void setQdeptno(Integer qdeptno) {
			this.qdeptno = qdeptno;
		}
}
