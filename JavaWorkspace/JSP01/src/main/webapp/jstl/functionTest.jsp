<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="title1" value="Hello World"/>
		<c:set var="title2" value="쇼핑몰 중심 JSP 입니다"/>
		<c:set var="str1" value="중심"/>
		<h2>여러가지 문자열 함수 기능</h2>
		title1 = ${title1}<br>
		title2 = ${title2}<br>
		str1 = ${str1}<br>
		
		title1의 문자열 길이 (fn:length()) : ${fn:length(title1)}<br>
		title1 대문자로 변경 (fn:toUpperCase()) : ${fn:toUpperCase(title1)}<br>
		title1 소문자로 변경 (fn:toLoserCase()) : ${fn:toLoserCase(title1)}
		
		부분 문자열 추출<br>
		앞뒤 공백 제거<br>
		공백을 /로 변환
	</body>
</html>