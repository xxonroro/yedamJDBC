package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExample {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB 서버에 접속
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pwd = "hr";

			conn = DriverManager.getConnection(url, id, pwd);
			/**************************** INSERT ****************************/
			// 3. Statement or PreparedStatement 객체 생성
			String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)"; // 미완성 상태

			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, 1000);
			pstmt.setString(2, "kil-Dong");
			pstmt.setString(3, "Hong");
			pstmt.setString(4, "kdHong@google.com");
			pstmt.setString(5, "82.10.1234.1234");
			pstmt.setString(6, "21/11/05");
			pstmt.setString(7, "SA_REP");
			pstmt.setInt(8, 6000);
			pstmt.setDouble(9, 0.15);
			pstmt.setInt(10, 146);
			pstmt.setInt(11, 80);
			// => 실제 쿼리문이 완성됨
			
			// 4. SQL 실행
			int result = pstmt.executeUpdate(); // SQL에서 몇 행이 수정되었습니다 할 때, 그 행의 갯수가 저장된다.
			
			// 5. 결과 값 처리
			System.out.println("Insert 결과 : " + result);			
			/**************************** UPDATE ****************************/
			// 3. Statement or PreparedStatement 객체 생성
			String update = "UPDATE employees SET last_name = ? WHERE employee_id = ?";
			
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, "Kang");
			pstmt.setInt(2, 1000);
			
			// 4. SQL 실행
			result = pstmt.executeUpdate();
			
			// 5. 결과 값 처리
			System.out.println("Update 결과 : " + result);
			
			/**************************** SELECT ****************************/
			// 3. Statement or PreparedStatement 객체 생성
			stmt = conn.createStatement();
			
			String select = "SELECT * FROM employees ORDER BY employee_id DESC";
			
			// 4. SQL 실행
			rs = stmt.executeQuery(select);
			
			// 5. 결과 값 처리 (테이블의 행을 위에서 아래로 순차적으로 접근한다.)
			while(rs.next()) { 
				String info = "사원번호 : " + rs.getInt("employee_id") + ", 이름 : " + rs.getString("first_name") + ", 성 : " + rs.getString("last_name");
				System.out.println(info);
			}
			
			/**************************** DELETE ****************************/
			// 3. Statement or PreparedStatement 객체 생성
			String delete = "DELETE FROM employees WHERE employee_id = 1000";
			
			stmt = conn.createStatement();
			
			// 4. SQL 실행
			result = stmt.executeUpdate(delete);
			
			// 5. 결과 값 처리
			System.out.println("Delete 결과 : " + result);
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver Loading Fail");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			// 6. 자원 해제

		}
	}

}
