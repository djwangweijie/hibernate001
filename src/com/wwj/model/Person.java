package com.wwj.model;

import java.util.Date;

public class Person {
		private  int  pid;
		private  String pname;
		private  Date   bir;
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public Date getBir() {
			return bir;
		}
		public void setBir(Date bir) {
			this.bir = bir;
		}
		
}
