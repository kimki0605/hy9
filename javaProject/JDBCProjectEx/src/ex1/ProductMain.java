package ex1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ProductMain {

    public static void main(String[] args) {

        // Connection 사용자 정의 클래스 활용 db 접속 테스트
        PrdJDBConn dbCon = new PrdJDBConn();
        Connection con = dbCon.getConnection();

        Statement stmt = null;
        ResultSet rs = null;

        if (con == null) { // db 접속 실패

            System.out.println("db 생성 실패");

        } else { // db 접속 성공

            System.out.println("db 생성 성공");

            try {

                // 쿼리
                String query = "SELECT * FROM productfin";

                // 쿼리를 저장하고 전달, 실행 담당 객체 생성
                stmt = con.createStatement();

                // 쿼리 실행
                rs = stmt.executeQuery(query);

                System.out.println("-------------전체 가전 제품 조회---------------");
                System.out.printf("%-5s %-25s %10s %-15s %-12s %5s%n",
                        "번호", "제품명", "가격", "제조사", "색상", "재고");

                // ResultSet을 이용해서 한 행씩 조회
                while(rs.next()) {
                    String prdNo = rs.getString(1);
                    String prdname = rs.getString(2);
                    String prdPrice = rs.getString(3);
                    String prdmaker = rs.getString(4);
                    String prdColo = rs.getString(5);
                    int ctgNo = rs.getInt(6);

                    // 한 행씩 출력
                    System.out.printf("%-5s %-25s %10s %-15s %-12s %5d%n",
                            prdNo, prdname, prdPrice, prdmaker, prdColo, ctgNo);
                }

                rs.close();
                stmt.close();
                con.close();

            } catch (Exception e) {

                System.out.println("오류발생");
                e.printStackTrace();
            }
        }
    }
}