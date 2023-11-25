package com.jdbc.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.product.DashBoard;

public class Registration {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private String mail = "";
	private String password = "";
	
	private boolean getEmail() {
		System.out.println("Enter your email.");
		mail = scanner.nextLine();
		if (!mail.matches("^[a-zA-Z0-9.]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$")
		) {
			System.out.println("Invalid Email, please try again");
			return false;
		
		}else return true;
	}
	
	private boolean getPassword() {
		System.out.println("Enter your password.");
		password = scanner.nextLine();
		if(!password.matches("^.*(?=.{8,})(?=.*[a-zA-Z0-9])(?=.*\\d)(?=.*[!#$%@&?]).*$")) {
			System.out.println("Incorrect Password format, please try again with a password containing below values.");
			System.out.println("Atleast a capital letter, a small letter, a number and a special character of minimum 8 length");
			return false;
		}else return true;
	}



	public void insertRecord(Connection connection) throws SQLException {
		
		System.out.println("================== REGISTRATION ======================");


		String sql = "insert into user(first_name,last_name,email,password,mobile) values (?,?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		System.out.println("Enter your first name.");
		String name = scanner.nextLine();
		preparedStatement.setString(1, name);

		System.out.println("Enter your last name.");
		preparedStatement.setString(2, scanner.nextLine());
		
		
		// Checking Email
		boolean isCorrectEmail = getEmail();
		while(!isCorrectEmail) isCorrectEmail = getEmail();
		preparedStatement.setString(3, mail);
				
		// Checking Password
		boolean isCorrectPass = getPassword();
		while(!isCorrectPass) isCorrectPass = getPassword();
		preparedStatement.setString(4, password);

		System.out.println("Enter your mobile.");
		preparedStatement.setString(5, scanner.nextLine());

		int rows = preparedStatement.executeUpdate();

		if(rows > 0 ) {
			System.out.println("User registered Successfully.");
			System.out.println("Hello " + name);
			DashBoard ap = new DashBoard();
			ap.showCategories(connection);
		}
		
	}

}
