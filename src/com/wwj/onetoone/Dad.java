package com.wwj.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Dad {
		@Id
		@GeneratedValue
		private int did;
		private String dadName;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="sonId",unique=true)
		private Son son;
		public int getDid() {
			return did;
		}
		
		public void setDid(int did) {
			this.did = did;
		}
		public String getDadName() {
			return dadName;
		}
		public void setDadName(String dadName) {
			this.dadName = dadName;
		}
		public Son getSon() {
			return son;
		}
		public void setSon(Son son) {
			this.son = son;
		}
		
}
