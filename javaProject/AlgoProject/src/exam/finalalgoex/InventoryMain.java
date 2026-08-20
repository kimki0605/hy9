package exam.finalalgoex;

import java.util.Scanner;

public class InventoryMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BinarySearchTree<Product> tree = new BinarySearchTree<>();

        while (true) {

            System.out.println();
            System.out.println("===== 재고 관리 =====");
            System.out.println("1. 새 품목 등록");
            System.out.println("2. 재고 품목 반출");
            System.out.println("3. 재고 목록");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();

            switch (menu) {

            case 1:

                System.out.print("품목명 : ");
                String name = sc.next();

                System.out.print("재고수량 : ");
                int stock = sc.nextInt();

                Product product =
                        new Product(name, stock);

                boolean result =
                        tree.add(product);

                if (result) {

                    System.out.println(
                            "품목 등록 완료");

                } else {

                    System.out.println(
                            "이미 등록된 품목입니다.");
                }

                break;

            case 2:

                System.out.print(
                        "반출할 품목명 : ");

                String outName =
                        sc.next();

                Product searchProduct =
                        tree.search(
                                new Product(
                                        outName,
                                        0));

                if (searchProduct == null) {

                    System.out.println(
                            "등록되지 않은 품목입니다.");

                    break;
                }

                System.out.println(
                        "현재 재고 : "
                        + searchProduct.getStock());

                System.out.print(
                        "반출 수량 : ");

                int count =
                        sc.nextInt();

                if (count <= 0) {

                    System.out.println(
                            "반출 수량은 1개 이상이어야 합니다.");

                    break;
                }

                if (count >
                        searchProduct.getStock()) {

                    System.out.println(
                            "재고가 부족합니다.");

                    break;
                }

                searchProduct.release(count);

                System.out.println(
                        "반출 완료 / 남은 재고 : "
                        + searchProduct.getStock()
                        + "개");

                if (searchProduct.getStock()
                        == 0) {

                    tree.remove(
                            searchProduct);

                    System.out.println(
                            "재고가 0이므로 "
                            + "해당 품목을 삭제합니다.");
                }

                break;

            case 3:

                System.out.println(
                        "===== 현재 재고 =====");

                if (tree.isEmpty()) {

                    System.out.println(
                            "등록된 품목이 없습니다.");

                } else {

                    tree.inorder();
                }

                break;

            case 4:

                System.out.println(
                        "재고 관리 프로그램 종료");

                sc.close();

                return;

            default:

                System.out.println(
                        "잘못된 메뉴입니다.");
            }
        }
    }
}