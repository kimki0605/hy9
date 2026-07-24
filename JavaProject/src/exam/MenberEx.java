package exam;

import java.util.Scanner;

public class MenberEx {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        // 기본 생성자
	        Member m1 = new Member();
	        m1.showMember();

	        // 입력
	        System.out.print("아이디 입력 : ");
	        String id = sc.next();

	        System.out.print("성명 입력 : ");
	        String name = sc.next();

	        System.out.print("나이 입력 : ");
	        int age = sc.nextInt();

	        System.out.print("전화번호 입력 : ");
	        String phone = sc.next();

	        sc.nextLine(); // 버퍼 제거

	        System.out.print("주소 입력 : ");
	        String address = sc.nextLine();

	        // 생성자로 초기화
	        Member m2 = new Member(id, name, age, phone, address);

	        m2.showMember();

	}

}
