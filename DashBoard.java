


package com.jdbc.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.jdbc.Checkout.Checkout;

public class DashBoard {
	
	private static Scanner scanner = new Scanner(System.in);


	public void showCategories(Connection connection) throws SQLException {
		
		System.out.println("================== BUY PRODUCT ======================");


		String sql = "select distinct(category) from product ";

		Statement statement = connection.createStatement();
		
		// Getting result from SQL
		ResultSet result = statement.executeQuery(sql);
		
		HashMap<Integer, String> categories = new HashMap<>();
		int count = 0;

		System.out.println("Choose category to buy eg. 1,2,3");
		
		// Adding categories to map
		while (result.next()) {
			categories.put(++count, result.getString("category"));
		}

		for (@SuppressWarnings("rawtypes") Map.Entry m : categories.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		
		int catInput = scanner.nextInt();
		
		String sql1 = "select * from product where category = '" + categories.get(catInput) + "'";
		
		// fetching all products from selected category
		ResultSet result1 = statement.executeQuery(sql1);
		
		// printing product list
		while(result1.next()) {
			System.out.println(result1.getString("id") + " " +  result1.getString("product_name")+ " " +result1.getString("product_desc"));
		}
		
		System.out.println("Enter id to add item in cart.");
		
		int productId = scanner.nextInt();
		
		Checkout checkout = new  Checkout();
		checkout.showCheckoutDetails(connection, productId);
		
	}

}


