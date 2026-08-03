package thread;

import java.awt.Toolkit;

public class BeePrint {

	public static void main(String[] args) {
		// 자바 프로그램에서 무조건 생성되는 thread : main
		// 기능을 추가 : main 스레드에 포함시킴
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //현재 시스템의 기본설정된 자원을 반환
		
		//비프음 5번 출력하는 코드
		for(int i =0;i<5;i++) {
			toolkit.beep();
			try {Thread.sleep(500);}catch(Exception e) {}
		}
		
		//띵 문자 5번 출력하는 코드
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch(Exception e) {}
		}

	}

}
