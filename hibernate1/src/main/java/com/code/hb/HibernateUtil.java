package com.code.hb;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.code.entity.Category;
import com.code.entity.OrderDetails;
import com.code.entity.Orders;
import com.code.entity.Product;
import com.code.entity.Users;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Category.class)
        .addAnnotatedClass(Product.class)
        .addAnnotatedClass(Orders.class)
        .addAnnotatedClass(Users.class)
        .addAnnotatedClass(OrderDetails.class)
        .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}



