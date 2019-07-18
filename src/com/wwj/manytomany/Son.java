package com.wwj.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Son {
	@Id
	@GeneratedValue
	private  int sid;
	private  String sname;
	
	@ManyToMany
	@JoinTable(name="dad_son",
	joinColumns={@JoinColumn(name="sid")},
	inverseJoinColumns={@JoinColumn(name="did")})
	private  List<Dad>  dads;
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
	public List<Dad> getDads() {
		return dads;
	}
	public void setDads(List<Dad> dads) {
		this.dads = dads;
	}
	
	
}
