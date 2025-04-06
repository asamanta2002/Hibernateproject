package com.code.hb;

import com.code.entity.Orders;
import org.hibernate.*;

public class ReadOrders {
	SessionFactory sessionFactory;
	public ReadOrders(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Orders readData(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Orders order = session.get(Orders.class, id);
		session.getTransaction().commit();
		session.close();
		return order;
	}
}