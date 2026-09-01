<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="exam.bean.ProductVO" %>

<%
	// 상품 목록 생성
	ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

	// 상품 데이터 추가
	productList.add(new ProductVO("P001", "갤럭시S25", 1200000, "삼성전자"));
	productList.add(new ProductVO("P002", "아이폰16", 1300000, "애플"));
	productList.add(new ProductVO("P003", "그램 프로", 1500000, "LG전자"));
	productList.add(new ProductVO("P004", "맥북에어", 1700000, "애플"));

	// 데이터 바인딩
	request.setAttribute("productList", productList);

	// 결과 페이지로 포워딩
	RequestDispatcher rd =
			request.getRequestDispatcher("c_forEach_ArrayList_result_ex.jsp");

	rd.forward(request, response);
%>