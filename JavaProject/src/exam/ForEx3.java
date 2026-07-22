package exam;

import java.util.Scanner;

public class ForEx3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		int sum = 0;
		
		System.out.print("start 입력 : ");
		num1 = sc.nextInt();
		System.out.print("end 입력 : ");
		num2 = sc.nextInt();

		for(int i=num1; i<=num2; i++) {
			sum += i;
		}
		System.out.println(num1 + "~" + num2 + "의 합 : "  + sum);
		sc.close();

	}

}
