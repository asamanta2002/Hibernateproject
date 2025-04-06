package com.code.hb;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


import com.code.entity.*;


public class InsertOrderDetails {
    private SessionFactory sessionFactory;
    
    public InsertOrderDetails(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void insertData(int quantity, float unitPrice, Orders order, Product product) {
        // Validate input data
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }
        
        if (unitPrice <= 0) {
            System.out.println("Unit price must be greater than 0.");
            return;
        }
        
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        
        try {
            // Check if the order exists
            Orders existingOrder = session.get(Orders.class, order.getId());
            if (existingOrder != null) {
                order = existingOrder; // Use the managed entity
            } else {
                session.persist(order); // Persist if new
            }
            
            // Check if the product exists
            Product existingProduct = session.get(Product.class, product.getId());
            if (existingProduct != null) {
                product = existingProduct; // Use the managed entity
            } else {
                session.persist(product); // Persist if new
            }
            
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setQuantity(quantity);
            orderDetails.setUnitPrice(unitPrice);
            orderDetails.setOrder(order);
            orderDetails.setProduct(product);
            
            session.persist(orderDetails);
            session.getTransaction().commit();
            
            System.out.println("New OrderDetails Inserted:\n" + orderDetails.toString());
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Error inserting OrderDetails: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}