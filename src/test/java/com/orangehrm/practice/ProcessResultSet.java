package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;

public class ProcessResultSet {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";

	//@Test
	public void getResultSetData() throws SQLException {

		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select first_name, last_name from employees where job_id='IT_PROG'");

		List<Map<String, String>> rsList = new ArrayList<>();

		while (rs.next()) {
			Map<String, String> rsMap = new LinkedMap<>();
			rsMap.put("first_name", rs.getString("first_name"));
			rsMap.put("last_name", rs.getString("last_name"));

			rsList.add(rsMap);

		}

		System.out.println(rsList);

		rs.close();
		st.close();
		con.close();

	}

	@Test
	public void getMapdata() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from jobs");
		ResultSetMetaData metaData = rs.getMetaData();

		List<Map<String, String>> mpList = new ArrayList<>();
		
		while(rs.next()) {
			Map<String,String> rsMap=new HashMap<>();
			int colNum=metaData.getColumnCount();
		 
			for (int i = 1; i <=colNum; i++) {
				String colName=metaData.getColumnName(i);
				String rsName=rs.getString(i);
				rsMap.put(colName, rsName);
				
				
			}
			mpList.add(rsMap);
			
		}
		System.out.println(mpList);

	}

}
