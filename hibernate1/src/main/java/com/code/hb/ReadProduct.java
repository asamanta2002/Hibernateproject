package com.code.hb;

import org.hibernate.*;
import com.code.entity.Product;

public class ReadProduct {
	SessionFactory sessionFactory;
	public ReadProduct(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Product readData(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Product product = session.get(Product.class, id);
		session.getTransaction().commit();
		session.close();
		return product;
	}
}