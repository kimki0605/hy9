package variable;

import java.util.Scanner;

public class InputEx {

	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);
		
		String name; 
		int year; 
		double grade; 
		String average;
		
		System.out.println("이름 입력 : ");
		name = sc.next();
		System.out.println("학년 입력 : ");
		year = sc.nextInt();
		System.out.println("점수 입력 : ");
		grade = sc.nextDouble();
		System.out.println("학점 입력 : ");
		average = sc.next();
		
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + year);
		System.out.println("점수 : " + grade);
		System.out.println("학점 : " + average);

	}

}
