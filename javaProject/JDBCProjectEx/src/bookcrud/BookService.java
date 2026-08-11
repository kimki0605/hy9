package bookcrud;

import java.sql.Connection;
import java.util.List;

public class BookService {

    private BookDAO dao;

    public BookService(Connection conn) {
        dao = new BookDAO(conn);
    }

    // 도서 등록
    public boolean insert(Book book) {

        // 도서번호 중복 확인
        Book check = dao.selectOne(book.getBookNo());

        // 이미 같은 도서번호가 있으면 등록하지 않음
        if (check != null) {
            return false;
        }

        // 중복이 없으면 등록
        return dao.insert(book) > 0;
    }

    // 전체 도서 조회
    public List<Book> selectAll() {
        return dao.selectAll();
    }

    // 도서번호로 조회
    public Book selectOne(String bookNo) {
        return dao.selectOne(bookNo);
    }

    // 도서 수정
    public boolean update(Book book) {
        return dao.update(book) > 0;
    }

    // 도서 삭제
    public boolean delete(String bookNo) {
        return dao.delete(bookNo) > 0;
    }

    // 도서명 검색
    public List<Book> searchByBookName(String bookName) {
        return dao.searchByBookName(bookName);
    }
}