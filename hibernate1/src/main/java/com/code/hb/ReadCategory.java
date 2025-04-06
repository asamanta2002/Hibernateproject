package com.code.hb;

import com.code.entity.Category;
import org.hibernate.*;

public class ReadCategory {
	SessionFactory sessionFactory;
	public ReadCategory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Category readData(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = session.get(Category.class, id);
		session.getTransaction().commit();
		session.close();
		return category;
	}
}
