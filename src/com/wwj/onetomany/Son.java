package com.wwj.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Son {
	@Id
	@GeneratedValue
	private  int sid;
	private  String sname;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dadId")
	private  Dad  dad;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Dad getDad() {
		return dad;
	}
	public void setDad(Dad dad) {
		this.dad = dad;
	}
	
}
