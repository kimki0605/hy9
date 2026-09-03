<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>상품 목록</title>

<style>

table {
    border-collapse: collapse;
    width: 900px;
}

th, td {
    border: 1px solid black;
    padding: 10px;
    text-align: center;
}

th {
    background-color: #eeeeee;
}

</style>

</head>

<body>

<h1>상품 목록</h1>

<table>

    <tr>
        <th>상품번호</th>
        <th>상품명</th>
        <th>가격</th>
        <th>제조사</th>
        <th>재고</th>
        <th>등록일</th>
    </tr>

<%
    ArrayList<ProductDTO> list =
        (ArrayList<ProductDTO>) request.getAttribute("productList");

    if (list != null && !list.isEmpty()) {

        for (ProductDTO product : list) {
%>

    <tr>
        <td><%= product.getPrdNo() %></td>
        <td><%= product.getPrdName() %></td>
        <td><%= product.getPrdPrice() %></td>
        <td><%= product.getPrdCompany() %></td>
        <td><%= product.getPrdStock() %></td>
        <td><%= product.getPrdDate() %></td>
    </tr>

<%
        }

    } else {
%>

    <tr>
        <td colspan="6">
            등록된 상품이 없습니다.
        </td>
    </tr>

<%
    }
%>

</table>

<br>

<a href="${pageContext.request.contextPath}/view/main.jsp">
    메인으로
</a>

</body>
</html>