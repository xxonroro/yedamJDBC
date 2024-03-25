package com.yedam.java.emp;

import java.sql.Date;

// VO 클래스
public class Employee {
	// 필드
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;

	// 기본 생성자
	public Employee() {
	}

	// 메서드 => getter/setter + toString
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId="
				+ departmentId + "]";
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public double getSalary() {
		return salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public int getManagerId() {
		return managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}
}
