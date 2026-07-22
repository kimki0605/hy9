package loop;

import java.util.Scanner;

public class ForEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("단 수 입력 : ");
		num = sc.nextInt();
		
		for(int m=num; m<=num; m++) {
			for(int n=1; n<=9; n++) {
				System.out.println(m + "x" + n + '=' + m*n);
			}
		}

	}

}
