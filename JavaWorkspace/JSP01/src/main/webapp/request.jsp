<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>클라이언트 요청 정보 확인</title>
	</head>
	<body>
		<%
			//내장 객체 : out (톰캣 버퍼쪽으로 출력(응답)데이터를 전송하는 객체)
			out.print("서버 : " +request.getServerName() + "<br>");
			out.print("포트번호 : " +request.getServerPort() + "<br>");
			out.print("요청방식 : " +request.getMethod() + "<br>");
			out.print("프로토콜 : " +request.getProtocol() + "<br>");
			out.print("URL : " +request.getRequestURL() + "<br>");
			out.print("URI : " +request.getRequestURI() + "<br>");
			out.print("ContextPath : " +request.getContextPath() + "<br>");
			out.print("ServletPath : " +request.getServletPath() + "<br>");
		%>
	</body>
</html>