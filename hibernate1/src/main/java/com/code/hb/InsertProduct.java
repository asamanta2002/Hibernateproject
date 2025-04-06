package com.code.hb;

import com.code.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class InsertProduct {
	SessionFactory sessionFactory;
	public InsertProduct(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void insertData(String name, float price, int stockQuantity, Category category) {
		if(name.length() > 20) {
			System.out.println("Length of NAME is out of permissible length.");
			return;
		}
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		// Try to fetch the category from the database first
		// Explanation below the code on why we want to fetch the category from the database again
	    Category existingCategory = session.get(Category.class, category.getId());
	    if (existingCategory != null) {
	        category = existingCategory; // Use the fetched category
	    } else {
	        // Persist the new category if it doesn't exist
	        session.persist(category);
	    }
		Product product = new Product(name, price, stockQuantity, category);
		session.persist(product);
		session.getTransaction().commit();
		session.close();
		System.out.println("New Product Inserted:\n"+product.toString());
	}
}
