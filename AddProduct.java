package com.jdbc.addProduct;

import java.sql.Connection;
import java.sql.SQLException;

public class AddProduct {
	
	public void insertRecord(Connection connection) throws SQLException {
		
		

		String deleteAll = "delete from product";
		

		String product1 = "insert into product(product_name, product_desc, category, asin, quantity, price, discount)"
				+ " values ('Mac Book','13.3 inch + M2','Electronics','ASIN123456', 2 , '1023' , 0 )";
		
		String product2 = "insert into product(product_name, product_desc, category, asin, quantity, price, discount)"
				+ " values ('iPhone 13','6 inch','Electronics','ASIN789012', 1 , '5023' , 5)";
		
		String product3 = "insert into product(product_name, product_desc, category, asin, quantity, price, discount)"
				+ " values ('Curtains','6 Foot','HouseHold','ASIN345678', 10 , '55' , 4)";
		
		String product4 = "insert into product(product_name, product_desc, category, asin, quantity, price, discount)"
				+ " values ('Toaster','Grill + Sandwich maker','Appliances','ASIN901234', 6 , '531' , 3)";
		
		String product5 = "insert into product(product_name, product_desc, category, asin, quantity, price, discount)"
				+ " values ('Ball pen','Set of 24','Stationary','ASIN567890', 17 , '240' , 10)";
		
		
		String product6 = "insert into product(product_name, product_desc, category, asin, quantity, price, discount)"
				+ " values ('Eraser','Set of 5','Stationary','ASIN567890', 10 , '210' , 12)";
		
		
		// Delete all previous products on a new run
		connection.createStatement().executeUpdate(deleteAll);
		
		// Add all products
		connection.prepareStatement(product1).executeUpdate();
		connection.prepareStatement(product2).executeUpdate();
		connection.prepareStatement(product3).executeUpdate();
		connection.prepareStatement(product4).executeUpdate();
		connection.prepareStatement(product5).executeUpdate();
		connection.prepareStatement(product6).executeUpdate();


	}
	
}








