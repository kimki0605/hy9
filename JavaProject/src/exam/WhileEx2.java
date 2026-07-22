package exam;

import java.util.Scanner;

public class WhileEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Student, grade;
		double totalgrade = 0;
		
		System.out.print("학생 수 입력 : ");
		Student = sc.nextInt();
		
		int St = 1;
		while(St<=Student) {
			St++;
			System.out.print("학생" + St + "점수 입력 :");
			grade = sc.nextInt();
			
			totalgrade += grade;
		}
		System.out.println("평군 : " + (totalgrade / Student));
		
		sc.close();

	}

}
