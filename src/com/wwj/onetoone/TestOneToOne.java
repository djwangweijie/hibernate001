package com.wwj.onetoone;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wwj.model.Person;

public class TestOneToOne {
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
			s.setSname("儿子");
			d.setSon(s);
			s.setDad(d);
			session.save(d);
			session.save(s);
			Dad  dd = (Dad) session.get(Dad.class, 1);
			System.out.println("出来======"+dd.getSon().getSname());
			// 提交事务
			bt.commit();
			session.close();
		}
}
