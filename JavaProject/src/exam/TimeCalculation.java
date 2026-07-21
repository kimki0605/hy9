package exam;

import java.util.Scanner;

public class TimeCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time;
		
		System.out.println("시간 입력 (초) : ");
		time = sc.nextInt();
		
		int hour = time / 3600;
		int minute = (time % 3600) / 60;
		int second = time % 60;
		
		System.out.println(time + "초는" + hour + "시간" + minute + "분" + second + "초입니다.");
		
		sc.close();

	}

}
