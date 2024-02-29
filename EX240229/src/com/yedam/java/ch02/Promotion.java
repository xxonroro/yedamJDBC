package com.yedam.java.ch02;

public class Promotion {
	public static void main(String[] args) {
		// 자동타입변환 - 정수
		byte byteVal = 65;
		char charVal = (char) byteVal;
		int intVal = byteVal;

		System.out.println(intVal);

		// 자동타입변환 - 실수
		float floatVal = 1.25F;
		double doubleVal = floatVal;
		System.out.println(doubleVal);

		doubleVal = intVal;
		System.out.println(doubleVal);

		intVal = (int) floatVal;
		System.out.println(intVal);

		// 연산에서의 타입변환
		byte a = 100;
		byte b = 10;
		int result = a + b;
		long c = 10L;
		c = result + c;

		int x = 10;
		double y = 4.0;

		double total = x / y;
		System.out.println(total);

		// 문자열 결합 연산
		String str = String.valueOf(10 + 2 + 8);
		System.out.println(str);

		str = 10 + 2 + "8";
		System.out.println(str);

		str = "10" + 2 + 8;
		System.out.println(str);

		str = "10" + (2 + 8);
		System.out.println(str);

	}
}
