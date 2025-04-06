package com.code.hb;



import com.code.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class InsertUsers {
    private final SessionFactory sf;

    public InsertUsers(SessionFactory sf) {
        this.sf = sf;
    }

    public boolean createUser(String username, String password, String email, Role role) {
        if (username == null || password == null || email == null || role == null) {
            System.out.println("All fields are required");
            return false;
        }

        try (Session session = sf.openSession()) {
            session.beginTransaction();
            
            // Check if username or email already exists
            if (session.createQuery("FROM Users WHERE username = :un OR email = :em")
                       .setParameter("un", username)
                       .setParameter("em", email)
                       .uniqueResult() != null) {
                System.out.println("Username or email already exists");
                return false;
            }

            Users user = new Users(username, password, email, role);
            session.persist(user);
            session.getTransaction().commit();
            
            System.out.println("User created: " + user.getUsername());
            return true;
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());
            return false;
        }
    }
}
