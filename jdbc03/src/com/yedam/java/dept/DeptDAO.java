package com.yedam.java.dept;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class DeptDAO extends DAO {
	private static DeptDAO dao = null;

	private DeptDAO() {
	};

	public static DeptDAO getInstance() {
		if (dao == null) {
			dao = new DeptDAO();
		}
		return dao;
	}

	// 1) 전체조회
	public List<Department> selectDeptAll() {
		List<Department> list = new ArrayList<>();

		try {
			connect();

			String sql = "SELECT * FROM departments ORDER BY department_id";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Department dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));

				list.add(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회
	public Department selectDeptInfo(int deptId) {
		Department dept = null;
		try {
			connect();

			String sql = "SELECT * FROM departments WHERE department_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dept;
	}

	// 등록
	public int insertDeptInfo(Department dept) {
		int result = 0;

		try {
			connect();

			String sql = "INSERT INTO departments VALUES (?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setInt(3, dept.getManagerId());
			pstmt.setInt(4, dept.getLocationId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 수정
	public int updateDeptInfo(Department dept) {
		int result = 0;

		try {
			connect();

			String sql = "UPDATE departments SET department_name = ? WHERE department_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setInt(2, dept.getDepartmentId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	// 삭제
	public int deleteDeptInfo(int deptId) {
		int result = 0;

		try {
			connect();

			String sql = "DELETE FROM departments WHERE department_id = " + deptId;
			
			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

}
