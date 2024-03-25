package com.yedam.java.app;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.emp.EmpDAO;
import com.yedam.java.emp.Employee;

public class EmpManagement {
	private Scanner scanner = new Scanner(System.in);
	private EmpDAO empDAO = EmpDAO.getInstance();
	private boolean run = true;

	public void run() {
		while (run) {
			menuPrint();

			int menuNo = menuSelect();

			if (menuNo == 1) {
				insertEmp();
			}
			if (menuNo == 2) {
				updateEmp();
			}
			if (menuNo == 3) {
				deleteEmp();
			}
			if (menuNo == 4) {
				selectEmpInfo();
			}
			if (menuNo == 5) {
				selectEmpAll();
			}
			if (menuNo == 9) {
				run = false;
			}
		}
		end();
	}

	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void menuPrint() {
		System.out.println("");
		System.out.println("====================================================");
		System.out.println("1.등록   2.수정  3.삭제  4.사원조회  5.사원전체조회  9.종료");
		System.out.println("====================================================");
	}

	private int menuSelect() {
		int menuNo = 0;

		try {
			System.out.print("선택>> ");
			menuNo = scanner.nextInt();
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주시기 바랍니다.");
		}

		return menuNo;
	}

	private void insertEmp() {
		Employee emp = inputAll();

		empDAO.insertEmpInfo(emp);
	}

	private void updateEmp() {
		Employee emp = inputInfo();

		empDAO.updateEmpInfo(emp);
	}

	private void deleteEmp() {
		int employeeId = inputEmpId();
		
		empDAO.deleteEmpInfo(employeeId);
	}

	private void selectEmpInfo() {
		int employeeId = inputEmpId();
		
		Employee emp = empDAO.selectEmpInfo(employeeId);
		System.out.println(emp);
	}

	private void selectEmpAll() {
		List<Employee> list = empDAO.selectEmpAll();
		for (Employee data : list) {
			System.out.println(data);
		}
	}

	private Employee inputAll() {
		Employee emp = new Employee();
		System.out.println("사번>>");
		emp.setEmployeeId(scanner.nextInt());
		System.out.println("이름>>");
		emp.setFirstName(scanner.next());
		System.out.println("성>>");
		emp.setLastName(scanner.next());
		System.out.println("이메일>>");
		emp.setEmail(scanner.next());
		System.out.println("전화번호>>");
		emp.setPhoneNumber(scanner.next());
		// 입력형식 : YYYY-MM-DD
		System.out.println("입사일>>");
		emp.setHireDate(Date.valueOf(scanner.next()));
		System.out.println("직급>>");
		emp.setJobId(scanner.next());
		System.out.println("연봉>>");
		emp.setSalary(scanner.nextInt());
		System.out.println("상여>>");
		emp.setCommissionPct(scanner.nextDouble());
		System.out.println("상사>>");
		emp.setManagerId(scanner.nextInt());
		System.out.println("부서>>");
		emp.setDepartmentId(scanner.nextInt());

		return emp;
	}

	private int inputEmpId() {
		System.out.println("사번>>");
		int employeeId = scanner.nextInt();

		return employeeId;
	}

	private Employee inputInfo() {
		Employee emp = new Employee();
		System.out.println("사번>>");
		emp.setEmployeeId(scanner.nextInt());
		System.out.println("연봉>>");
		emp.setSalary(scanner.nextInt());

		return emp;
	}
}
