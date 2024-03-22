package com.yedam.app.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Database에 실제 접속하는 클래스
public class EmpDAO {
	// Oracle(DB) 연결 정보
	String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String connectedId = "hr";
	String connectedPwd = "hr";

	// 각 메서드에서 공통적으로 사용하는 전역 필드
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 싱글톤
	private static EmpDAO empDAO = null;

	private EmpDAO() {
	}

	public static EmpDAO getInstance() {
		if (empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}

	// 메서드
	// 1) DB와 연결
	private void connect() {
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
	private void disconnect() {
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

	// 3) 전체 조회
	public List<Employee> selectEmpAll() {
		List<Employee> list = new ArrayList<>();

		try {
			connect();

			stmt = conn.createStatement();

			String select = "SELECT * FROM employees ORDER BY employee_id";

			rs = stmt.executeQuery(select);

			while (rs.next()) {
				Employee emp = new Employee();

				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	// 4) 단건 조회
	public Employee selectEmpInfo(int employeeId) {
		Employee emp = null;
		
		try {
			connect();
			
			String select = "SELECT * FROM employees WHERE employee_id = ? ";
			
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, employeeId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Employee();
				
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return emp;
	}
	
	
	// 5) 등록
	public void insertEmpInfo(Employee emp) {

		try {
			// 1. DB 연결
			connect();

			// 2. 객체 생성
			String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)"; // 미완성 상태

			pstmt = conn.prepareStatement(insert);

			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHireDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setDouble(8, emp.getSalary());
			pstmt.setDouble(9, emp.getCommissionPct());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());
			// => 실제 쿼리문이 완성됨

			// 3. SQL 실행
			int result = pstmt.executeUpdate();

			// 4. 결과 처리
			System.out.println("Insert 결과 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원해제
			disconnect();
		}

	}

	// 6) 수정
	public void updateEmpInfo(Employee emp) {
		try {
			connect();

			String update = "UPDATE employees SET salary = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);

			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeId());

			int result = pstmt.executeUpdate();
			System.out.println("Update 결과 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}

	}

	// 7) 삭제
	public void deleteEmpInfo(int employeeId) {
		try {
			// 1. DB 연결
			connect();

			// 2. 객체 생성
			String delete = "DELETE FROM employees WHERE employee_id = " + 1000;

			stmt = conn.createStatement();

			// 3. SQL 실행
			int result = stmt.executeUpdate(delete);

			// 4. 결과 처리
			System.out.println("Delete 결과 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원해제
			disconnect();
		}
	}

}
