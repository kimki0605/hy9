package bookcrud;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class BookIO {

    static Scanner sc = new Scanner(System.in);

    // 메뉴 출력
    public static int menu() {

        System.out.println();
        System.out.println("========== 서점 관리 프로그램 ==========");
        System.out.println("1. 도서 등록");
        System.out.println("2. 전체 도서 조회");
        System.out.println("3. 도서 조회");
        System.out.println("4. 도서 수정");
        System.out.println("5. 도서 삭제");
        System.out.println("6. 도서명 검색");
        System.out.println("0. 프로그램 종료");
        System.out.println("========================================");

        System.out.print("메뉴 선택 : ");

        return sc.nextInt();
    }

    // 도서 등록 정보 입력
    public static Book inputBook() {

        sc.nextLine();

        System.out.print("도서번호 : ");
        String bookNo = sc.nextLine();

        System.out.print("도서명 : ");
        String bookName = sc.nextLine();

        System.out.print("저자 : ");
        String bookAuthor = sc.nextLine();

        System.out.print("가격 : ");
        int bookPrice = sc.nextInt();

        System.out.print("재고 : ");
        int bookStock = sc.nextInt();

        sc.nextLine();

        System.out.print("출판사번호 : ");
        String pubNo = sc.nextLine();

        // BOOKDATE는 DAO에서 SYSDATE로 자동 입력
        return new Book(
                bookNo,
                bookName,
                bookAuthor,
                bookPrice,
                null,
                bookStock,
                pubNo
        );
    }

    // 도서번호 입력
    public static String inputBookNo() {

        sc.nextLine();

        System.out.print("도서번호 : ");

        return sc.nextLine();
    }

    // 도서명 입력
    public static String inputBookName() {

        sc.nextLine();

        System.out.print("검색할 도서명 : ");

        return sc.nextLine();
    }

    // 도서 목록 출력
    public static void printList(List<Book> list) {

        System.out.println();
        System.out.println("========== 도서 목록 ==========");

        if (list.isEmpty()) {
            System.out.println("검색된 도서가 없습니다.");
            return;
        }

        for (Book book : list) {
            System.out.println(book);
        }

        System.out.println("==============================");
    }

    // 도서 한 권 출력
    public static void printBook(Book book) {

        System.out.println();

        if (book == null) {
            System.out.println("해당 도서가 없습니다.");
            return;
        }

        System.out.println("========== 도서 정보 ==========");
        System.out.println(book);
        System.out.println("==============================");
    }
}