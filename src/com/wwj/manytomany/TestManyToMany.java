package com.wwj.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestManyToMany {
		public static void main(String[] args) {
			// 读取配置文件，实例化 默认的寻找 名字为 hibernate.cfg.xml
			Configuration cfg = new Configuration().configure();
			// 构建 session 工厂
			SessionFactory sf = cfg.buildSessionFactory();
			// 创建 session
			Session session = sf.openSession();
			// 操作数据 (insert delete update) 手动开启事务
			Transaction bt = session.beginTransaction();
			// 操作数据
			Dad d1 = new Dad();
			d1.setDadName("baba1");
			Dad d2 = new Dad();
			d2.setDadName("baba2");
			//---
			Son s1 = new Son();
			s1.setSname("erzi1");
			Son s2 = new Son();
			s2.setSname("erzi2");
			//---
			d1.getSons().add(s1);
			d1.getSons().add(s2);
			d2.getSons().add(s1);
			d2.getSons().add(s2);
			//---
			session.save(d1);
			session.save(d2);
			// 提交事务
			bt.commit();
			session.close();
		}
}
