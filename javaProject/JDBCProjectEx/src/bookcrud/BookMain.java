package bookcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class BookMain {

    // Oracle DB 접속 정보
	static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	static final String USER = "SQLSELECT";
	static final String PASSWORD = "1234";

    public static void main(String[] args) {

        Connection conn = null;

        try {

            // Oracle JDBC 드라이버 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // DB 연결
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("DB 연결 성공!");

            // Service 객체 생성
            BookService service = new BookService(conn);

            while (true) {

                int menu = BookIO.menu();

                switch (menu) {

                // 1. 도서 등록
                case 1:

                    Book book = BookIO.inputBook();

                    if (service.insert(book)) {
                        System.out.println("도서 등록 성공!");
                    } else {
                        System.out.println("도서 등록 실패!");
                        System.out.println("이미 존재하는 도서번호입니다.");
                    }

                    break;

                // 2. 전체 도서 조회
                case 2:

                    List<Book> list = service.selectAll();

                    BookIO.printList(list);

                    break;

                // 3. 도서 조회
                case 3:

                    String bookNo = BookIO.inputBookNo();

                    Book searchBook = service.selectOne(bookNo);

                    BookIO.printBook(searchBook);

                    break;

                // 4. 도서 수정
                case 4:

                    String updateNo = BookIO.inputBookNo();

                    Book updateBook = service.selectOne(updateNo);

                    if (updateBook == null) {
                        System.out.println("해당 도서가 없습니다.");
                        break;
                    }

                    System.out.println("수정할 도서 정보를 입력하세요.");

                    Book newBook = BookIO.inputBook();

                    // 기존 도서번호 유지
                    newBook.setBookNo(updateNo);

                    if (service.update(newBook)) {
                        System.out.println("도서 수정 성공!");
                    } else {
                        System.out.println("도서 수정 실패!");
                    }

                    break;

                // 5. 도서 삭제
                case 5:

                    String deleteNo = BookIO.inputBookNo();

                    if (service.delete(deleteNo)) {
                        System.out.println("도서 삭제 성공!");
                    } else {
                        System.out.println("해당 도서가 없습니다.");
                    }

                    break;

                // 6. 도서명 검색
                case 6:

                    String bookName = BookIO.inputBookName();

                    List<Book> searchList =
                            service.searchByBookName(bookName);

                    BookIO.printList(searchList);

                    break;

                // 0. 종료
                case 0:

                    System.out.println("프로그램을 종료합니다.");

                    return;

                default:

                    System.out.println("잘못된 메뉴입니다.");
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}