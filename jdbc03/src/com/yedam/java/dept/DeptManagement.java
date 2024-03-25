package com.yedam.java.dept;

import java.util.List;
import java.util.Scanner;

public class DeptManagement {
	private Scanner sc = null;
	private DeptDAO deptDAO = null;

	public DeptManagement() {
		sc = new Scanner(System.in);
		deptDAO = DeptDAO.getInstance();
	}

	public void run() {
		while (true) {
			menuPrint();

			int menu = selectMenu();

			if (menu == 1) {
				insertDept();
			} else if (menu == 2) {
				updateDept();
			} else if (menu == 3) {
				deleteDept();
			} else if (menu == 4) {
				selectDeptOne();
			} else if (menu == 5) {
				selectDeptAll();
			} else if (menu == 9) {
				end();
				break;
			} else {
				showError();
			}
		}
	}

	private void showError() {
		System.out.println("메뉴에서 선택해주시기 바랍니다.");

	}

	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void menuPrint() {
		String menu = "";
		menu += "1. 부서등록 ";
		menu += "2. 부서수정 ";
		menu += "3. 부서삭제 ";
		menu += "4. 부서조회 ";
		menu += "5. 전체조회 ";
		menu += "9. 종료 ";

		System.out.println("==================================");
		System.out.println(menu);
		System.out.println("==================================");
	}

	private int selectMenu() {
		System.out.print("선택 > ");
		return inputNumber();
	}

	private int inputNumber() {
		int num = 0;

		try {
			num = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자로 입력해주시기 바랍니다.");
		}
		return num;
	}

	private void selectDeptAll() {
		List<Department> list = deptDAO.selectDeptAll();

		if (list.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다.");
		} else {
			System.out.println("부서번호 | 부서이름 | 부서장 | 위치번호");
			for (Department dept : list) {
				System.out.println(dept);
			}
		}
	}

	private void selectDeptOne() {
		int deptId = inputDeptId();

		Department dept = deptDAO.selectDeptInfo(deptId);

		if (dept == null) {
			System.out.println("해당 부서는 존재하지 않습니다.");
		} else {
			System.out.println(dept);
		}
	}

	private int inputDeptId() {
		System.out.print("부서번호: ");
		return inputNumber();
	}

	private void deleteDept() {
		int deptId = inputDeptId();

		boolean isDeleted = checkDeptDelete(deptId);

		if (!isDeleted) {
			return;
		}

		int result = deptDAO.deleteDeptInfo(deptId);

		if (result > 0) {
			System.out.println("정상적으로 삭제되었습니다.");
			System.out.println("부서번호 : " + deptId);
		} else {
			System.out.println("해당 부서는 존재하지 않습니다.");
			System.out.println("정보를 확인해주세요.");
		}
	}

	private boolean checkDeptDelete(int deptId) {
		Department dept = deptDAO.selectDeptInfo(deptId);

		System.out.println("부서번호 | 부서이름 | 부서장 | 위치번호");
		System.out.println(dept);

		boolean isSeleted = false;
		System.out.println("삭제를 진행하시겠습니까? Y/N: ");
		String result = sc.nextLine();

		if (result.equalsIgnoreCase("Y")) {
			isSeleted = true;
		}
		return isSeleted;
	}

	private void updateDept() {
		Department dept = inputDeptInfo();

		int result = deptDAO.updateDeptInfo(dept);

		if (result > 0) {
			System.out.println("정상적으로 수정되었습니다.");
		} else {
			System.out.println("정상적으로 수정되지 않았습니다.");
			System.out.println("정보를 확인해주세요.");
		}
	}

	private Department inputDeptInfo() {
		System.out.print("부서번호: ");
		int deptId = Integer.parseInt(sc.nextLine());

		System.out.print("부서이름: ");
		String deptName = sc.nextLine();

		Department dept = new Department();
		dept.setDepartmentId(deptId);
		dept.setDepartmentName(deptName);
		return dept;
	}

	private Department inputDeptAll() {
		Department dept = new Department();
		System.out.print("부서번호 : ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서이름 : ");
		dept.setDepartmentName(sc.nextLine());
		System.out.print("부서장 : ");
		dept.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.print("위치번호 : ");
		dept.setLocationId(Integer.parseInt(sc.nextLine()));

		return dept;
	}
	
	private void insertDept() {
		Department dept = inputDeptAll();
		
		int result = deptDAO.insertDeptInfo(dept);
		
		if (result > 0) {
			System.out.println("정상적으로 등록되었습니다.");
		} else {
			System.out.println("정상적으로 등록되지 않았습니다.");
			System.out.println("정보를 확인해주세요.");
		}
	}
}
