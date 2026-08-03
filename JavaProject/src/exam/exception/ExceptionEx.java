package exam.exception;

import java.util.Scanner;

public class ExceptionEx {

	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("정수1 입력 : ");
	        int num1 = sc.nextInt();

	        System.out.print("정수2 입력 : ");
	        int num2 = sc.nextInt();

	        try {
	            int result = num1 / num2;
	            System.out.println("나누기 결과 : " + result);
	        } catch (ArithmeticException e) {
	            System.out.println("0으로 나눌 수 없습니다.");
	            e.printStackTrace();   // 시스템에서 제공하는 예외 추적 정보 출력
	        }

	        sc.close();
	    }
	}