package exam;

import java.util.Scanner;

public class Product {

    // 멤버 필드
    String prdName;
    int prdPrice;
    int prdSold;
    int prdStock;

    Scanner sc = new Scanner(System.in);

    // 상품 정보 입력
    void inputPrdInfo() {
        System.out.println("****상품 정보 입력****");

        System.out.print("상품명 : ");
        prdName = sc.next();

        System.out.print("가격 : ");
        prdPrice = sc.nextInt();

        System.out.print("판매 수량 : ");
        prdSold = sc.nextInt();

        System.out.print("재고 수량 : ");
        prdStock = sc.nextInt();
    }

    // 상품 정보 출력
    void showPrdInfo() {
        System.out.println("\n****상품 정보 출력****");
        System.out.println("상품명 : " + prdName);
        System.out.println("가격 : " + prdPrice);
        System.out.println("판매 수량 : " + prdSold);
        System.out.println("재고 수량 : " + prdStock);
    }

    // 매출액 계산
    void salesAmount() {
        int sales = prdPrice * prdSold;
        System.out.println("매출액 : " + sales);
    }

    // 재고액 계산
    void stockAmount() {
        int stock = prdPrice * prdStock;
        System.out.println("재고액 : " + stock);
    }

    public static void main(String[] args) {

        Product p = new Product();

        p.inputPrdInfo();
        p.showPrdInfo();
        p.salesAmount();
        p.stockAmount();
    }
}