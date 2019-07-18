package com.wwj.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToMany {
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
			Dad  d = new Dad();
			d.setDadName("爸爸");
			Son  s = new Son();
			s.setSname("儿子1");
			s.setDad(d);
			Son  s1= new Son();
			s1.setDad(d);
			s1.setSname("儿子2");
			d.getSons().add(s);
			d.getSons().add(s1);
			session.save(d);
			Dad  dad = (Dad) session.get(Dad.class, 1);
			System.out.println("儿子的数量为==="+dad.getSons().size());
			// 提交事务
			bt.commit();
			session.close();
		}
}
