package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;
import model.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class productlist
 */
@WebServlet("/productlist")
public class ProductControl extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new ProductDAO();
    }

    // GET 방식 처리
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        productList(request, response);
    }

    // POST 방식 처리
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        productList(request, response);
    }

    // 상품 목록 조회
    private void productList(HttpServletRequest request,
                             HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ProductDTO> list = dao.getProductList();

        request.setAttribute("productList", list);

        RequestDispatcher rd =
                request.getRequestDispatcher("/view/ProductListView.jsp");

        rd.forward(request, response);
    }
}
