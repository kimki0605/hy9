package bookcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private Connection conn;

    public BookDAO(Connection conn) {
        this.conn = conn;
    }

    // 도서 등록
    public int insert(Book book) {

        String sql = "INSERT INTO BOOK "
                   + "(BOOKNO, BOOKNAME, BOOKAUTHOR, BOOKPRICE, BOOKDATE, BOOKSTOCK, PUBNO) "
                   + "VALUES (?, ?, ?, ?, SYSDATE, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, book.getBookNo());
            pstmt.setString(2, book.getBookName());
            pstmt.setString(3, book.getBookAuthor());
            pstmt.setInt(4, book.getBookPrice());
            pstmt.setInt(5, book.getBookStock());
            pstmt.setString(6, book.getPubNo());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // 전체 도서 조회
    public List<Book> selectAll() {

        List<Book> list = new ArrayList<>();

        String sql = "SELECT BOOKNO, BOOKNAME, BOOKAUTHOR, "
                   + "BOOKPRICE, BOOKDATE, BOOKSTOCK, PUBNO "
                   + "FROM BOOK "
                   + "ORDER BY BOOKNO";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Book book = new Book();

                book.setBookNo(rs.getString("BOOKNO"));
                book.setBookName(rs.getString("BOOKNAME"));
                book.setBookAuthor(rs.getString("BOOKAUTHOR"));
                book.setBookPrice(rs.getInt("BOOKPRICE"));
                book.setBookDate(rs.getDate("BOOKDATE"));
                book.setBookStock(rs.getInt("BOOKSTOCK"));
                book.setPubNo(rs.getString("PUBNO"));

                list.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 도서번호로 도서 조회
    public Book selectOne(String bookNo) {

        String sql = "SELECT BOOKNO, BOOKNAME, BOOKAUTHOR, "
                   + "BOOKPRICE, BOOKDATE, BOOKSTOCK, PUBNO "
                   + "FROM BOOK "
                   + "WHERE BOOKNO = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bookNo);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                Book book = new Book();

                book.setBookNo(rs.getString("BOOKNO"));
                book.setBookName(rs.getString("BOOKNAME"));
                book.setBookAuthor(rs.getString("BOOKAUTHOR"));
                book.setBookPrice(rs.getInt("BOOKPRICE"));
                book.setBookDate(rs.getDate("BOOKDATE"));
                book.setBookStock(rs.getInt("BOOKSTOCK"));
                book.setPubNo(rs.getString("PUBNO"));

                return book;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 도서 수정
    public int update(Book book) {

        String sql = "UPDATE BOOK "
                   + "SET BOOKNAME = ?, "
                   + "BOOKAUTHOR = ?, "
                   + "BOOKPRICE = ?, "
                   + "BOOKSTOCK = ?, "
                   + "PUBNO = ? "
                   + "WHERE BOOKNO = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getBookAuthor());
            pstmt.setInt(3, book.getBookPrice());
            pstmt.setInt(4, book.getBookStock());
            pstmt.setString(5, book.getPubNo());
            pstmt.setString(6, book.getBookNo());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // 도서 삭제
    public int delete(String bookNo) {

        String sql = "DELETE FROM BOOK WHERE BOOKNO = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bookNo);

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // 도서명 LIKE 검색
    public List<Book> searchByBookName(String bookName) {

        List<Book> list = new ArrayList<>();

        String sql = "SELECT BOOKNO, BOOKNAME, BOOKAUTHOR, "
                   + "BOOKPRICE, BOOKDATE, BOOKSTOCK, PUBNO "
                   + "FROM BOOK "
                   + "WHERE BOOKNAME LIKE '%' || ? || '%' "
                   + "ORDER BY BOOKNO";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bookName);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Book book = new Book();

                book.setBookNo(rs.getString("BOOKNO"));
                book.setBookName(rs.getString("BOOKNAME"));
                book.setBookAuthor(rs.getString("BOOKAUTHOR"));
                book.setBookPrice(rs.getInt("BOOKPRICE"));
                book.setBookDate(rs.getDate("BOOKDATE"));
                book.setBookStock(rs.getInt("BOOKSTOCK"));
                book.setPubNo(rs.getString("PUBNO"));

                list.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}