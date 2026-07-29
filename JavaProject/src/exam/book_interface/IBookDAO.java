package exam.book_interface;

public interface IBookDAO {

    void insert(BookDTO book);      // 등록

    void update(BookDTO book);      // 수정

    void delete(String title);      // 삭제

    BookDTO search(String title);   // 검색

    void printAll();                // 전체 출력
}