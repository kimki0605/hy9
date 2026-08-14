package exam;

import java.util.Scanner;

import datastructure.stack.Stack;

public class StackParking {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 주차 가능 대수 입력
		System.out.println("주차장을 구성합니다");
		System.out.print("주차면을 입력하세요 : ");
		int parkingSize = sc.nextInt();

		// 내가 만든 Stack 클래스 사용
		Stack parking = new Stack(parkingSize);

		System.out.println(parkingSize + "대를 주차할 수 있는 주차장이 구성되었습니다");

		while (true) {

			System.out.println();
			System.out.println("===== 주차관리 프로그램 =====");
			System.out.println("0. 주차현황");
			System.out.println("1. 자동차 주차");
			System.out.println("2. 자동차 출차");
			System.out.println("3. 만차여부");
			System.out.println("4. 종료");
			System.out.print("메뉴 선택 : ");

			int menu = sc.nextInt();

			// 0. 주차현황
			if (menu == 0) {

				System.out.println("\n[주차현황]");

				if (parking.isEmpty()) {
					System.out.println("현재 주차된 자동차가 없습니다.");
				} else {
					parking.showStack();
				}

				System.out.println("현재 주차 대수 : " + parking.size());
				System.out.println("전체 주차 가능 대수 : " + parking.getCapacity());
			}

			// 1. 자동차 주차
			else if (menu == 1) {

				if (parking.isFull()) {
					System.out.println("주차장이 만차입니다.");
				} else {

					System.out.print("주차할 자동차 번호 입력 : ");
					char car = sc.next().charAt(0);

					parking.push(car);

					System.out.println(car + " 자동차가 주차되었습니다.");
					System.out.println("현재 주차 대수 : " + parking.size());
				}
			}

			// 2. 자동차 출차
			else if (menu == 2) {

				if (parking.isEmpty()) {
					System.out.println("주차장에 주차된 자동차가 없습니다.");
				} else {

					char car = parking.pop();

					System.out.println(car + " 자동차가 출차되었습니다.");
					System.out.println("현재 주차 대수 : " + parking.size());
				}
			}

			// 3. 만차여부
			else if (menu == 3) {

				if (parking.isFull()) {
					System.out.println("주차장이 만차입니다.");
				} else {
					System.out.println("주차장이 만차가 아닙니다.");
					System.out.println("현재 주차 대수 : "
							+ parking.size() + " / "
							+ parking.getCapacity());
				}
			}

			// 4. 종료
			else if (menu == 4) {

				System.out.println("주차관리 프로그램을 종료합니다.");
				break;

			}

			// 잘못된 메뉴
			else {
				System.out.println("잘못된 메뉴입니다.");
			}
		}

		sc.close();
	}
}