package com.code.hb;

/**
 * Hello world!
 *
 */
import org.hibernate.SessionFactory;

public class App {
    public static void main(String[] args) {
        // Get SessionFactory and open a session
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //new CreateCategory(sessionFactory);
        //new CreateProduct(sessionFactory);
        //new CreateUsers(sessionFactory);
        //new CreateOrders(sessionFactory);
        //new Fetch(sessionFactory);
    }
}
