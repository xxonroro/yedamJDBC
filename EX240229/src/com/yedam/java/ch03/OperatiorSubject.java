package com.yedam.java.ch03;

public class OperatiorSubject {

	public static void main(String[] args) {
		//문제1) 아래와 같이 각 변수를 초기화하였을 때 각 문제에 맞게 구현하세요.
		int x = 10;
		int y = 10;
		int result;
		
		//1-1) 부호연산자를 이용하여 변수 x의 값을 음수로 출력하세요. 단, 변수 x의 값은 변하지 말아야 한다.
		result = -x;
		System.out.printf("x : %d , y: %d , result : %d\n", x, y, result);
		
		//1-2) 변수 x와 y의 값을 더한 후 y의 값을 증가시키는 연산식을 한줄로 작성하여라.
		result = x + y++;
		System.out.printf("x : %d , y: %d , result : %d\n", x, y, result);
		
		//1-3) 변수 x와 y의 값을 더한 값이 20이 되도록 변수 x와 y 중 하나의 변수에 증감연산자를 사용하여 연산식을 한줄로 작성하여라.
		result = x + --y;
		System.out.printf("x : %d , y: %d , result : %d\n", x, y, result);
		
		//문제2) 책 129 페이지 6번, 365 -> 300 (산술연산자만 사용)
		int value = 356;
		result = (int)(Math.floor((double)value / 100) * 100);
		System.out.println(result);
		
		//문제3) 책 131페이지 12번,  다음 결과를 차례대로 true 와 false를 출력하도록 구현하라.
		int m = 10;
		int n = 5;
		
		System.out.println( (m>7) && (n<=5));
		System.out.println( ( m%3 == 0) || (n%2 == 0));
		
		//문제4) 책 131페이지 13번, 각 연산식을 대입 연산자 하나로 구성된 실행문으로 변경하세요.		
		int val = (10 - 10) * 10 / 10;

		System.out.println(val);
		
		//문제5) 변수 val의 값이 양수일 경우엔 변수 값을 아닐 경우엔 0을 담는 변수를 선언하라(단, 삼항연산자를 사용)
		result = val > 0 ? val : 0;	
	}
}
