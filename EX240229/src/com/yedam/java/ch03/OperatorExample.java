package com.yedam.java.ch03;

import java.util.Scanner;

public class OperatorExample {

	public static void main(String[] args) {
		// 부호 연산자
		int a = -100;
		int result1 = -a, result2 = +a;

		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);

		byte b = -100;
		byte result3 = (byte) -b;
		System.out.println("result3 : " + result3);
		System.out.println("-----------------");

		// 증감 연산자
		int x = 10, y = 10, z;

		x++;
		System.out.println("x : " + x);
		++x;
		System.out.println("x : " + x);

		y--;
		System.out.println("y : " + y);
		--y;
		System.out.println("y : " + y);
		System.out.println("-----------------");

		z = x++;
		System.out.printf("z : %d, x : %d", z, x);
		System.out.println();
		z = ++x;
		System.out.printf("z : %d, x : %d", z, x);
		System.out.println();
		System.out.println("-----------------");

		x = 5;
		y = 5;
		z = ++x + y--;
		System.out.printf("z : %d, x : %d, y : %d", z, x, y);
		System.out.println();
		System.out.println("-----------------");

		// 산술 연산자
		int e = 10, f = 3, g;

		g = e / f;
		System.out.println("g : " + g);

		g = e % f;
		System.out.println("y : " + y);
		System.out.println("-----------------");

		// 비교 연산자 & 논리 연산자
		Scanner scanner = new Scanner(System.in);

		System.out.print("입력: ");
		String value = scanner.nextLine();

		for (int i = 0; i < value.length(); i++) {
			char charVal = value.charAt(i);

			if (65 <= charVal && charVal <= 95) {
				System.out.println((i + 1) + "번째 문자는 대문자이다");
			} else if (97 <= charVal && charVal <= 122) {
				System.out.println((i + 1) + "번째 문자는 소문자이다");
			} else if(48 <= charVal && charVal <= 57){
				System.out.println((i + 1) + "번째 문자는 숫자이다");
			} else {
				System.out.println((i + 1) + "번째 문자는 공백이거나 특수 문자이다");
			}
		}
		scanner.close();
		System.out.println("-----------------");
		
		// 복합 대입 연산자
		int res = 10;
		
		res += 10;
		res *= 2;
		res /= 3;
		res %= 4;
		
		// 삼항 연산자
		String result = res > 10 ? "A" : "B";
		
		System.out.println("result : " + result);
			
		
	}
}
