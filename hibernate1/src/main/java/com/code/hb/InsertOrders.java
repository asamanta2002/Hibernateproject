package com.code.hb;



import com.code.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class InsertOrders {
    private SessionFactory sessionFactory;
    
    public InsertOrders(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void insertData(Timestamp orderDate, float totalAmount, Users user, List<OrderDetails> orderDetailsList) {
        // Validate input data
        if (orderDate == null) {
            System.out.println("Order date cannot be null.");
            return;
        }
        
        if (totalAmount <= 0) {
            System.out.println("Total amount must be greater than 0.");
            return;
        }
        
        if (user == null) {
            System.out.println("User cannot be null.");
            return;
        }
        
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        
        try {
            // Check if the user exists
            Users existingUser = session.get(Users.class, user.getId());
            if (existingUser != null) {
                user = existingUser; // Use the managed entity
            } else {
                session.persist(user); // Persist if new
            }
            
            // Create new order
            Orders order = new Orders();
            order.setOrderDate(orderDate);
            order.setTotalAmount(totalAmount);
            order.setUser(user);
            
            // Handle order details if provided
            if (orderDetailsList != null && !orderDetailsList.isEmpty()) {
                List<OrderDetails> managedOrderDetails = new ArrayList<>();
                
                for (OrderDetails od : orderDetailsList) {
                    // Check if product exists for each order detail
                    Product product = session.get(Product.class, od.getProduct().getId());
                    if (product == null) {
                        System.out.println("Product with ID " + od.getProduct().getId() + " not found.");
                        continue;
                    }
                    
                    OrderDetails orderDetail = new OrderDetails();
                    orderDetail.setQuantity(od.getQuantity());
                    orderDetail.setUnitPrice(od.getUnitPrice());
                    orderDetail.setOrder(order);
                    orderDetail.setProduct(product);
                    
                    session.persist(orderDetail);
                    managedOrderDetails.add(orderDetail);
                }
                
                order.setOrderDetils(managedOrderDetails);
            }
            
            session.persist(order);
            session.getTransaction().commit();
            
            System.out.println("New Order Inserted:\n" + order.toString());
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Error inserting Order: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}