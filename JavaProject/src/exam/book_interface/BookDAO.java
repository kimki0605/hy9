package exam.book_interface;

public class BookDAO implements IBookDAO {

    @Override
    public void insert(BookDTO book) {
        System.out.println(book.getTitle() + " 도서 등록 완료");
    }

    @Override
    public void update(BookDTO book) {
        System.out.println(book.getTitle() + " 도서 수정 완료");
    }

    @Override
    public void delete(String title) {
        System.out.println(title + " 도서 삭제 완료");
    }

    @Override
    public BookDTO search(String title) {
        System.out.println(title + " 도서 검색");

        BookDTO book = new BookDTO(title, "홍길동", "한빛", 25000, 350);

        return book;
    }

    @Override
    public void printAll() {
        System.out.println("도서 전체 출력");
    }

}