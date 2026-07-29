package exam.book_interface;

public class BookMain {

    public static void main(String[] args) {

        BookDAO dao = new BookDAO();

        BookDTO book = new BookDTO(
                "자바 프로그래밍",
                "남궁성",
                "도우출판",
                35000,
                800);

        dao.insert(book);

        dao.update(book);

        BookDTO result = dao.search("자바 프로그래밍");

        System.out.println("도서명 : " + result.getTitle());
        System.out.println("저자 : " + result.getAuthor());
        System.out.println("출판사 : " + result.getPublisher());
        System.out.println("가격 : " + result.getPrice());
        System.out.println("페이지 : " + result.getPage());

        dao.delete("자바 프로그래밍");

        dao.printAll();

    }

}