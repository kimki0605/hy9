<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>폼에 입력된 값으로 빈 속성값 설정</title>
	</head>
	<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<!-- StudentBean 사용 모든 프로퍼티에 값 설정 StudentBean 클래스 필스 값 저장, 필드명과 파라미터명을 매칭해서 자동 저장까지 진행-->
	<jsp:useBean id="student" class="bean.StudentBean" scope="page">
		<jsp:setProperty property="*" name="student"/>
	</jsp:useBean>
	</body>
</html>