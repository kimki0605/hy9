package exam.book_interface;

public class BookDTO {

    private String title;      // 도서명
    private String author;     // 저자
    private String publisher;  // 출판사
    private int price;         // 가격
    private int page;          // 페이지 수

    public BookDTO() {
    }

    public BookDTO(String title, String author, String publisher, int price, int page) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}