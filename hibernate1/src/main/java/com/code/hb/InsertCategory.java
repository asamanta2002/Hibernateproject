package com.code.hb;


import org.hibernate.*;
import com.code.entity.Category;

public class InsertCategory {
	SessionFactory sessionFactory;
	Session session;
	public InsertCategory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void insertData(String name, String description) {
		if(name.length() > 20 && description.length() > 50) {
			System.out.println("Length(s) out of permissible limit.");
			return;
		}
		this.session = this.sessionFactory.getCurrentSession();
		this.session.beginTransaction();
		Category category = new Category(name, description);
		this.session.persist(category);
		this.session.getTransaction().commit();
		this.session.close();
		System.out.println("New Category Inserted:\n"+category.toString());
	}
}
