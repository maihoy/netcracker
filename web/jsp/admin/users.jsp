<%@ page import="javax.jms.Session" %>
<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Все пользователи</title>
	</head>
	<body>
		<table border="1px" >
			<tr >
					<td >Фамилия</td>
					<td >Имя</td>
				<td>Почта</td>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td><c:out value="${ user.lastName }" /></td>
					<td><c:out value="${ user.firstName }" /></td>
					<td><c:out value="${user.email}"/></td>
					<td><c:out value="${user.idState}"/></td>
					<td><a href="controller?command=gotoupdate?email=${user.email}" >Update</a></td>
					<td><a href="">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<a href="controller?command=backadmin">Вернуться обратно</a>
		<a href="controller?command=logout">Выйти из системы</a>
		<%!
		ServletRequest request;
			Enumeration<String> sessiong= (request.getAttributeNames());
		%>
	<c:out
	</body>
</html>