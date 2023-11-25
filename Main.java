package com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import com.jdbc.registration.Registration;
import com.jdbc.addProduct.AddProduct;
import com.jdbc.login.Login;


public class Main {

	
	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("================== E - COMMERCE ======================");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/amazondb";
			String userName = "root";
			String password = "pass@word1";
			connection = DriverManager.getConnection(dbUrl,userName,password);
		} catch (Exception e) {
			System.out.println("Error connecting with DB");
			return;
		}
		
		// Registration object initiate
		Registration registration = new Registration();
		// Login object initiate
		Login login = new Login();
		// Product object initiate
		AddProduct addProduct = new AddProduct();
		try {
			addProduct.insertRecord(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			//Starting code flow
			System.out.println("Welcome to e-Commerce");
			System.out.println("Select one option");
			System.out.println("1 for Login");
			System.out.println("2 for Registration");
			int choice = Integer.parseInt(scanner.nextLine());

			switch(choice) {
			case 1:
				// Login flow
				login.searchRecord(connection);
			break;
			case 2:
				// Registration flow
				registration.insertRecord(connection);
			break;	
			default:
				System.out.println("Invalid input");
			break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
