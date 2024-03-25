package com.yedam.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	// Oracle(DB) 연결 정보
	protected String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	protected String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	protected String connectedId = "hr";
	protected String connectedPwd = "hr";

	// 각 메서드에서 공통적으로 사용하는 전역 필드
	protected Connection conn = null;
	protected Statement stmt = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	protected DAO() {
	}

	// 1) DB와 연결
	protected void connect() {
		try {
			// 1. JDBC Driver 로딩
			Class.forName(jdbcDriver);

			// 2. DB 서버에 접속
			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver Loading Fail");
		} catch (SQLException e) {
			System.out.println("DB Connect Fail");
			System.out.println(e.getMessage());
		}
	}

	// 2) DB와 해제
	protected void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
