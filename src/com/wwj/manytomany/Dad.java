package com.wwj.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Dad {
		@Id
		@GeneratedValue
		private int did;
		private String dadName;
		
		@ManyToMany(cascade = {CascadeType.ALL})
		@JoinTable(name="dad_son",
		joinColumns={@JoinColumn(name="did")},
		inverseJoinColumns={@JoinColumn(name="sid")})
		private List<Son> sons = new ArrayList<>();
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

		public List<Son> getSons() {
			return sons;
		}

		public void setSons(List<Son> sons) {
			this.sons = sons;
		}
      
		
}
