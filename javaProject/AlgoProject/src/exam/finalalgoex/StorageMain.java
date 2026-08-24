package exam.finalalgoex;

import java.util.Scanner;

public class StorageMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BinarySearchTreeStorage<Product> storage =
                new BinarySearchTreeStorage<Product>();

        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("        재고 관리 프로그램");
            System.out.println("================================");
            System.out.println("1. 새 품목 등록");
            System.out.println("2. 재고 품목 반출");
            System.out.println("3. 재고 확인");
            System.out.println("4. 종료");
            System.out.println("================================");

            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {

            // =====================
            // 1. 새 품목 등록
            // =====================
            case 1:

                System.out.print("품목명 입력 : ");
                String name = sc.nextLine();

                System.out.print("재고 수량 입력 : ");
                int stock = sc.nextInt();
                sc.nextLine();

                Product newProduct =
                        new Product(name, stock);

                boolean result =
                        storage.add(newProduct);

                if (result) {
                    System.out.println(
                            "새 품목이 등록되었습니다."
                    );
                } else {
                    System.out.println(
                            "이미 등록된 품목입니다."
                    );
                }

                break;

            // =====================
            // 2. 재고 품목 반출
            // =====================
            case 2:

                System.out.print("반출할 품목명 입력 : ");
                String outName = sc.nextLine();

                System.out.print("반출 수량 입력 : ");
                int quantity = sc.nextInt();
                sc.nextLine();

                Product outProduct =
                        new Product(outName);

                int resultStock =
                        storage.updateStock(
                                outProduct,
                                quantity
                        );

                if (resultStock == 1) {

                    System.out.println(
                            "재고 반출 완료"
                    );

                } else if (resultStock == 0) {

                    System.out.println(
                            "재고가 0이 되어 해당 품목을 삭제합니다."
                    );

                    storage.remove(outProduct);

                } else if (resultStock == -1) {

                    System.out.println(
                            "재고 반출 수량이 부족합니다."
                    );

                } else if (resultStock == -2) {

                    System.out.println(
                            "반출하려는 품목이 창고에 없습니다."
                    );
                }

                break;

            // =====================
            // 3. 재고 확인
            // =====================
            case 3:

                System.out.println("현재 재고");

                if (storage.isEmpty()) {

                    System.out.println(
                            "등록된 품목이 없습니다."
                    );

                } else {

                    storage.preorder();
                    System.out.println();
                }

                break;

            // =====================
            // 4. 종료
            // =====================
            case 4:

                System.out.println(
                        "재고 관리 프로그램을 종료합니다."
                );

                sc.close();

                return;

            default:

                System.out.println(
                        "잘못된 메뉴입니다. 다시 선택하세요."
                );
            }
        }
    }
}