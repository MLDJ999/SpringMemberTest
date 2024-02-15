package com.itwbillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 
 * MySQL 연결 테스트
 *
 */
public class DBConnectTest {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb";
	private static final String DBID = "root";
	private static final String DBPW = "1234";
	
	@Test
	
	public void connect_test() {
		try {
			Class.forName(DRIVER);
			System.out.println(" 드라이버 로드 성공!!! ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
			System.out.println(" 드라이버 연결 성공 !!! " );
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
