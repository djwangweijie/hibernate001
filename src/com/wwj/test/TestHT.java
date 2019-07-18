package com.wwj.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wwj.model.Person;

/**
 * 
 * @author wwj 
 * 1: 读取全局配置文件 
 * 2:构建 sessionFactory 
 * 3: 创建 session(会话)
 * 4: 开启transcation
 * 5: 操作数据   （CRUD）
 * 6: 提交事务 transcation
 * 7: 关闭 session
 *
 */
public class TestHT {
	
	public static void main(String[] args) throws ParseException {
		//先处理下时间
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		String format = sf1.format(new Date());
		Date parse = sf1.parse(format);
		// 读取配置文件，实例化 默认的寻找 名字为 hibernate.cfg.xml
		Configuration cfg = new Configuration().configure();
		// 构建 session 工厂
		SessionFactory sf = cfg.buildSessionFactory();
		// 创建 session
		Session session = sf.openSession();
		// 操作数据 (insert delete update) 手动开启事务
		Transaction bt = session.beginTransaction();
		// 操作数据
		Person per = new Person();
		per.setPname("张三");
		per.setBir(parse);
		// CRUD操作
		// --1 .增加
		session.save(per);
		// --2 .查询 （如果查询多个,需要用到hql语句）
		Person p = (Person) session.get(Person.class, 1);
		// --3. 修改需要先查
		p.setPname("小李");
		session.update(p);
		// -- 删除
		session.delete(p);
		// -- 查询所有
		Query createQuery = session.createQuery("from Person");
		List<Person> list = createQuery.list();
		for(Person pp:list) {
		System.out.println(pp.getPname());
		}
		// 提交事务
		bt.commit();
		session.close();
	}

}
