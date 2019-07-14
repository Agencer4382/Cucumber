package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataDemo {
	
	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";
	
	@Test
	public void getMetaData() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		DatabaseMetaData dbMetaData=con.getMetaData();
		
		String dbName=dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		
		String dbVersion=dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVersion);
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select*from employees where job_id='it_prog'");
		
		ResultSetMetaData rsMetaData=rs.getMetaData();
		int colNum=rsMetaData.getColumnCount();
		System.out.println(colNum);
		
		for (int i = 1; i <=colNum; i++) {
			String colName=rsMetaData.getColumnName(i);
			System.out.println(colName);
		}
	
		
		con.close();
	}

}
