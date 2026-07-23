package exam;

import java.util.Scanner;

public class ArrayInputEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[5];
		//int maxnum = num[0];
		
		System.out.println("숫자 입력");
		for(int i=0; i<num.length; i++) {
			System.out.printf("num[%d] : ", i);
			num[i] = sc.nextInt();
		}
		
		int maxnum = num[0];
		
		System.out.print("입력된 값 : ");
		for(int i=0; i<num.length; i++) {
			System.out.printf(num[i] + " ");
			
			if(num[i] > maxnum) {
				maxnum = num[i];
			}
		}
		System.out.println(" ");
		System.out.println("최대값 : " + maxnum);

	}

}
