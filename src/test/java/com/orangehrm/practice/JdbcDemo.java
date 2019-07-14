package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";

	// @Test
	public void dbConnection() throws SQLException {
		// create connection
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		// create a statement
		Statement st = con.createStatement();
		// execute query and store the results from database in a resultset object
		ResultSet result = st.executeQuery("Select * from Countries");
		// get value from result
		result.next();
		String colData = result.getString("Country_Name");
		System.out.println(colData);

		result.next();
		colData = result.getString("Country_Name");
		System.out.println(colData);

		System.out.println("-----print value usin loop----");
		while (result.next()) {
			colData = result.getString("Country_Name");
			System.out.println(colData);

		}

		// close all db collection
		result.close();
		st.close();
		con.close();

		// dsiplay deparment id, deparment name

	}

	@Test()
	public void dbConnection2() throws SQLException {

		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("Select * from Departments");

		while (result.next()) {
			int dep_id = result.getInt("DEPARTMENT_ID");
			String dep_name = result.getString("DEPARTMENT_NAME");

			System.out.println(dep_id + " " + dep_name);
		}

		result.close();
		st.close();
		con.close();

	}

}
