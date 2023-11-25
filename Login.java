package com.jdbc.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.product.DashBoard;


public class Login {

	private static Scanner scanner = new Scanner(System.in);
	
	
	public void searchRecord(Connection connection) throws SQLException{
		System.out.println("================== LOGIN ======================");
		
		System.out.println("Enter your email.");
		String mail = scanner.nextLine();
		
		System.out.println("Enter your Password.");
		String password = scanner.nextLine();


		String sql = "select * from user WHERE email = '" +  mail + "' and password = '" + password+ "'" ;
		
		// Statement class object for SQL execution
		Statement statement = connection.createStatement();
		
		// fetching query
		ResultSet result = statement.executeQuery(sql);
		
		if(result.next()) {
			System.out.println("Hello " +  result.getString("first_name"));
			DashBoard ap = new DashBoard();
			ap.showCategories(connection);
		}else{
			System.out.println("Incorrect Username & Password.");
		}
	}
}