package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. JDBC Driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. DB 서버에 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";

		Connection conn = DriverManager.getConnection(url, id, pwd);
		conn.setAutoCommit(false);
		conn.commit();
		conn.rollback();
		// 3. Statement or PreparedStatement 객체 생성
		String sql = "SELECT * FROM employees";

		Statement stmt = conn.createStatement();

		// 4. SQL 실행 - SELECT 문
		ResultSet rs = stmt.executeQuery(sql);

		// 5. 결과 값 처리
		while (rs.next()) {
			String name = "이름 : " + rs.getString("first_name") + ", " + rs.getString(3);
			System.out.println(name);
		}

		// 6. 자원 해제
		if (rs != null) {
			rs.close();
		}

		if (stmt != null) {
			stmt.close();
		}

		if (conn != null) {
			conn.close();
		}

	}

}
