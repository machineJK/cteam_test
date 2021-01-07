<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyInfo</title>
</head>
<body>
	<h3>회원정보</h3>
	<table border="1">
		<tr>
			<th>성명</th>
			<th>나이</th>
			<th>성별</th>
			<th>이메일</th>
			<th>방법</th>
		</tr>
		<tr>
			<td>${name }</td>
			<td>${age }</td>
			<td>${gender }</td>
			<td>${email }</td>
			<td>${method }</td>
		</tr>
	</table>
	<br>
	<table border="1">
		<tr>
			<th>성명</th>
			<th>나이</th>
			<th>성별</th>
			<th>이메일</th>
			<th>방법</th>
		</tr>
		<tr>
			<td>${vo.name }</td>
			<td>${vo.age }</td>
			<td>${vo.gender }</td>
			<td>${vo.email }</td>
			<td>${method }</td>
		</tr>
	</table>
	<a href='<c:url value="/"/>member'>회원가입</a>
</body>
</html>