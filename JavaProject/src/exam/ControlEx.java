package exam;

import java.util.Scanner;

public class ControlEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int info;

		System.out.println("*******상품 정보*******");
		System.out.println("1 노트북 : 1,200,000");
		System.out.println("2 디지털카메라 : 400,000");
		System.out.println("*********************");
		System.out.print("상품번호 입력 : ");
		info = sc.nextInt();

		int ea; // 주문 수량
		int orderPrice1 = 1200000; // 노트북 가격
		int orderPrice2 = 400000; // 카메라 가격
		int orderPrice; // 주문금액
		int discount; // 할인액
		int totalPrice; // 총지불액

		if (info == 1 || info == 2) {

			System.out.print("주문 수량 입력 : ");
			ea = sc.nextInt();

			if (info == 1) { // 노트북

				orderPrice = orderPrice1 * ea;

				System.out.println("상품명 : 노트북");
				System.out.println("가격 : " + orderPrice1);
				System.out.println("주문 수량 : " + ea);
				System.out.println("주문액 : " + orderPrice);

				if (orderPrice >= 1000000) {
					discount = orderPrice * 10 / 100;
				} else if (orderPrice >= 500000) {
					discount = orderPrice * 5 / 100;
				} else {
					discount = 0;
				}

				System.out.println("할인액 : " + discount);

				totalPrice = orderPrice - discount;

				System.out.println("총지불액 : " + totalPrice);

			} else { // 디지털카메라

				orderPrice = orderPrice2 * ea;

				System.out.println("상품명 : 디지털카메라");
				System.out.println("가격 : " + orderPrice2);
				System.out.println("주문 수량 : " + ea);
				System.out.println("주문액 : " + orderPrice);

				if (orderPrice >= 1000000) {
					discount = orderPrice * 10 / 100;
				} else if (orderPrice >= 500000) {
					discount = orderPrice * 5 / 100;
				} else {
					discount = 0;
				}

				System.out.println("할인액 : " + discount);

				totalPrice = orderPrice - discount;

				System.out.println("총지불액 : " + totalPrice);
			}

		} else {
			System.out.println("잘못 입력하였습니다. 종료합니다.");
		}

		sc.close();
	}

}