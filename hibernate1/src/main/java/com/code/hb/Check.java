package com.code.hb;


import com.code.entity.*;
import com.code.hb.*;
import jakarta.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class Check
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
    	// Reading Category
    	Category category = new ReadCategory(sessionFactory).readData(1);
    	System.out.println(category);
    	
    	// Reading Product
    	Product product = new ReadProduct(sessionFactory).readData(1);
    	System.out.println(product.toString());
    	
    	// Reading Users
    	Users user = new ReadUser(sessionFactory).readData(1);
    	System.out.println(user);
    	
    	
    	//Creating New Categories
 	try {
    	InsertCategory insertCategory = new InsertCategory(sessionFactory);
	    	insertCategory.insertData("Hatchback","Small sized and compact vehicles for shorter distances");
	    	insertCategory.insertData("Sedan","Flat and long sized vehicles for long rides");
	    	insertCategory.insertData("Bus", "Large vehicles for transporting passengers");
    	}catch(Exception e) {
    		System.out.println("Error occured while inserting category data");
   	}
    	
    	// Creating New Products
    	 Category category1 = new Category("Hatchback","Small sized and compact vehicles for shorter distances");
 	try {
   	Category category11 = new ReadCategory(sessionFactory).readData(1);
   	InsertProduct insertProduct = new InsertProduct(sessionFactory);
  	insertProduct.insertData("Maruti Baleno", 850000.00f, 1000, category11);
  	insertProduct.insertData("Swift Dzire", 650000.00f, 3000, category11);
	    	insertProduct.insertData("Tata Tiago", 690000.00f, 1500, category11);
	    	insertProduct.insertData("Maruti Wagon R", 750000.00f, 2000, category11);
    	}catch(Exception e) {
   		System.out.println("Error occured while inserting First proudct data");
   	}
    	try {
	    	Category category11 = new ReadCategory(sessionFactory).readData(2);
	    	InsertProduct insertProduct = new InsertProduct(sessionFactory);
	    	insertProduct.insertData("Honda Civic", 750000.00f, 250, category11);
	    	insertProduct.insertData("Honda City", 700000.00f, 250, category11);
    	insertProduct.insertData("Maruti Ciaz", 800000.00f, 400, category11);
	    	insertProduct.insertData("Skoda Slavia", 950000.00f, 300, category11);
    	insertProduct.insertData("BMW i7", 6800000.00f, 120, category11);
	    	insertProduct.insertData("Audi A6", 4800000.00f, 200, category11);
   	insertProduct.insertData("Mercedes Maybach", 10000000.00f, 250, category11);
  	}catch(Exception e) {
    		System.out.println("Error occured while inserting second product data");
    	}
   	try {
	    	Category category11 = new ReadCategory(sessionFactory).readData(3);
	    	InsertProduct insertProduct = new InsertProduct(sessionFactory);
	    	insertProduct.insertData("Traveller 26", 1400000.00f, 200, category11);
   	insertProduct.insertData("Starbus City", 1700000.00f, 250, category11);
    	insertProduct.insertData("Volvo 9400 B11R", 9000000.00f, 200, category11);
    	insertProduct.insertData("Tata Ultra EV 9", 1745000.00f, 250, category11);
	    	insertProduct.insertData("Tata Magna Coach", 9900000.00f, 100, category11);
  	}catch(Exception e) {
   		System.out.println("Error occured while inserting third product data");
    	}
    }
}