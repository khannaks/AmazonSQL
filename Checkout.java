package com.jdbc.Checkout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.product.DashBoard;

public class Checkout {
	
	private static Scanner scanner = new Scanner(System.in);


	public void showCheckoutDetails(Connection connection, int selectedProductId) throws SQLException {
		
		System.out.println("================== CHECKOUT ======================");
		
		// fetching selected product
		String sql2 = "select * from product where id = " + selectedProductId;
		Statement statement = connection.createStatement();

		ResultSet result2 = statement.executeQuery(sql2);
		// calculating final price
		while (result2.next()) {
			String selectedProductItem = result2.getString("product_name");
			String selectedProductDesc = result2.getString("product_desc");
			String selectedProductPrice = result2.getString("price");
			String selectedProductDiscount = result2.getString("discount");
			System.out.println("selectedProductItem = " + selectedProductItem + "||"
					+ "selectedProductDesc = " + selectedProductDesc + "||"
					+ "selectedProductPrice = " + selectedProductPrice + "||"
					+ "selectedProductDiscount = " + selectedProductDiscount);
			
			// total Price
			double totalPrice = Double.parseDouble(selectedProductPrice) - (Double.parseDouble(selectedProductPrice) * Double.parseDouble(selectedProductDiscount))/100;
					
			System.out.println("Total Price = " + totalPrice);
						
		}
		
		System.out.println("Enter delivery address");
		scanner.nextLine();
		
		System.out.println("Enter Payment option" + " : "+ "1=> COD" + " 2=> Credit/Debit Card");
		
		String paymentType = scanner.nextLine();
		if(paymentType.equals("2")) {
			
			System.out.println("Enter your card number");

			scanner.nextLine();
			
			System.out.println("Enter card expiry.");

			scanner.nextLine();
			
			System.out.println("Enter card cvv");

			scanner.nextLine();
		}

		System.out.println("Press 1 to place order & 2 to exit");
		
		String confrimation = scanner.nextLine();
		
		// Confirming the order
		if(confrimation.equals("1")) {
			System.out.println("Your order has been placed succesfully !!");

		}else {
			// routing back to home page
			DashBoard ap = new DashBoard();
			ap.showCategories(connection);
		}
		


	}

}


