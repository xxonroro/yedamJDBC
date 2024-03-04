package com.yedam.java.ch04;

public class ConditionalExample {

	public static void main(String[] args) {

		int score = 63;

		if (score >= 90) {
			System.out.println("점수가 90점이상입니다.");
			System.out.println("등급은 A입니다.");
		} else {
			System.out.println("점수가 80점이상입니다.");
			System.out.println("등급은 B입니다.");
		}

		// if ~ else if
		if (score >= 90) {
			System.out.println("점수가 90점이상입니다.");
			System.out.println("등급은 A입니다.");
		} else if (score >= 80) {
			System.out.println("점수가 80점이상입니다.");
			System.out.println("등급은 B입니다.");
		} else if (score >= 70) {
			System.out.println("점수가 70점이상입니다.");
			System.out.println("등급은 C입니다.");
		} else if (score >= 60) {
			System.out.println("점수가 60점이상입니다.");
			System.out.println("등급은 D입니다.");
		} else {
			System.out.println("점수가 50점이상입니다.");
			System.out.println("등급은 F입니다.");
		}

		// 정수 1에서 6사이의 정수 값을 랜덤하게 가져오는 연산식
		int num = (int) (Math.random() * 6) + 1;

		if (num == 1) {
			System.out.println("현재 값은 1입니다.");
		} else if (num == 2) {
			System.out.println("현재 값은 2입니다.");
		} else if (num == 3) {
			System.out.println("현재 값은 3입니다.");
		} else if (num == 4) {
			System.out.println("현재 값은 4입니다.");
		} else if (num == 5) {
			System.out.println("현재 값은 5입니다.");
		} else {
			System.out.println("현재 값은 6입니다.");
		}

		switch (num) {
		case 1:
			System.out.println("현재 값은 1입니다.");
			break;
		case 2:
			System.out.println("현재 값은 2입니다.");
			break;
		case 3:
			System.out.println("현재 값은 3입니다.");
			break;
		case 4:
			System.out.println("현재 값은 4입니다.");
			break;
		case 5:
			System.out.println("현재 값은 5입니다.");
			break;
		default:
			System.out.println("현재 값은 6입니다.");
		}

		char grade = 'B';

		switch (grade) {
		case 'A':
		case 'a':
			System.out.println("우수 회원입니다.");
			break;
		case 'B':
		case 'b':
			System.out.println("일반 회원입니다.");
			break;
		default:
			System.out.println("손님입니다.");
		}

	}

}
