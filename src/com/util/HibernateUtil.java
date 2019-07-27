package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sessionFactory=null;
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession(){
		Session session=sessionFactory.openSession();
		return session;
	}
}
