package com.yedam.java.ch04;

import java.util.Scanner;

public class ConditionalSubject {

	public static void main(String[] args) {
		// 문제1) 두 개의 정수가 주어졌을 때 두 정수의 합이 자연수이면 'Natural Number'을 출력하도록 하세요.
		int a = 1;
		int b = 1;

		if (a + b > 0) {
			System.out.println("Natural Number");
		}

		// 문제2) 두 개의 정수가 주어졌을 때 두 수의 대소관계에 따라 부등호( > or = or < )를 출력하도록 하세요.
		int x = 1;
		int y = 1;

		System.out.println(x > y ? x + ">" + y : (x < y ? x + "<" + y : x + "=" + y));

		/*
		 * 문제3) 체질량 지수인 BMI에 따라 비만도를 네가지 단계로 구분하여 결과값을 출력하도록 하세요. BMI = 체중 / ( 키 * 키 )
		 * 저체중(18.5미만), 정상(18.5 이상 25미만), 과체중(25이상 30미만), 비만(30이상)
		 */

		int weight = 50;
		int height = 160;
		double bmi = Math.floor(weight / Math.pow(height, 2) * 10) / 10;
		
		System.out.println(bmi >= 30 ? "비만" : bmi >= 25 ? "과체중" : bmi >= 18.5 ? "정상" : "저체중");
		
		if (bmi >= 30) {
			System.out.println("비만");
		} else if (bmi >= 25) {
			System.out.println("과체중");
		} else if (bmi >= 18.5) {
			System.out.println("정상");
		} else {
			System.out.println("저체중");
		}

		/*
		 * 문제4) 선택한 단의 6번째 값을 출력하도록 하세요. 예를 들어, 2단일 경우 2 X 6 = 12 단, 출력문에 변수를 사용하지 않는다.
		 */
		Scanner scanner = new Scanner(System.in);
		
		
		int dan = ;
		int num = 6;
		
		// switch
		switch(num) {
		case 1 :
			System.out.println(dan + "X" + num + "=" + (dan * num));
			break;
		case 2 :
			System.out.println(dan + "X" + num + "=" + (dan * num));
			break;
		case 3 :
			System.out.println(dan + "X" + num + "=" + (dan * num));
			break;
		case 4 :
			System.out.println(dan + "X" + num + "=" + (dan * num));
			break;
		case 5 :
			System.out.println(dan + "X" + num + "=" + (dan * num));
			break;
		case 6 :
			System.out.println(dan + "X" + num + "=" + (dan * num));
			break;
		case 7 :
			System.out.println(dan + "X" + num + "=" + (dan * num));
			break;
		case 8 :
			System.out.println(dan + "X" + num + "=" + (dan * num));
			break;
		default :
			System.out.println(dan + "X" + num + "=" + (dan * num));
		}		
		
		// if
		
	}
}
