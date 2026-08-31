<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 로그인 페이지로 이동하는 여러가지 방법 -->
		<a href="http://localhost:8080/JSP01/el/login.jsp">로그인 1</a><br>
		<a href="/JSP01/el/login.jsp">로그인 2</a><br>
		<a href="<%=request.getContextPath() %>/el/login.jsp">로그인 3</a><br>
		<a href="${pageContext.request.contextPath }/login.jsp">로그인 4</a><br>
	</body>
</html>