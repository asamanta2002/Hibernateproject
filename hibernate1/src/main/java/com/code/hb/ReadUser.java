package com.code.hb;


import com.code.entity.Users;
import org.hibernate.*;

public class ReadUser {
	SessionFactory sessionFactory;
	public ReadUser(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Users readData(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Users user = session.get(Users.class, id);
		session.getTransaction().commit();
		session.close();
		return user;
	}
}
