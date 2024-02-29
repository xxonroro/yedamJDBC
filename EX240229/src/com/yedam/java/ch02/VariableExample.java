package com.yedam.java.ch02;

public class VariableExample {

	public static void main(String[] args) {
		// 정수
		byte var1 = 127;
		short var2 = -32768;
		int var3 = 100;
		long var4 = 900000000L;

		// 문자
		char c1 = 'A';
		char c2 = (char) (c1 * 2);
		char c3 = 67;

		System.out.println((int) c1);
		System.out.println((int) c2);
		System.out.println(c3);

		// 문자열
		String c4 = "AB";
		String c5 = c4 + 1;

		System.out.println(c5);

		// 실수
		float f1 = 0.12345678912345f;
		double f2 = 0.12345678912345;

		System.out.println(f1);
		System.out.println(f2);

		// 논리
		boolean isSelected = true;

		if (isSelected) {
			System.out.println("선택한 값은 ...");
		} else {
			System.out.println("선택한 값이 존재하지 않습니다.");
		}
	}
}
