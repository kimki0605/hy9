package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.Util;

public class ProductDAO {
	  // 전체 상품 조회
    public ArrayList<ProductDTO> getProductList() {

        ArrayList<ProductDTO> list = new ArrayList<>();

        String sql = "SELECT prdNo, prdName, prdPrice, " +
                     "prdCompany, prdStock, prdDate " +
                     "FROM product " +
                     "ORDER BY prdNo";

        try (
            Connection conn = DBConnect.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()
        ) {

            while (rs.next()) {

                ProductDTO product = new ProductDTO();

                product.setPrdNo(rs.getString("prdNo"));
                product.setPrdName(rs.getString("prdName"));
                product.setPrdPrice(rs.getInt("prdPrice"));
                product.setPrdCompany(rs.getString("prdCompany"));
                product.setPrdStock(rs.getInt("prdStock"));
                product.setPrdDate(rs.getDate("prdDate"));

                list.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
}
