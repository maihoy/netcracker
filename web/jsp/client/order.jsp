<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ваш заказ</title>
</head>
<body>
<table border="1px"  title="Menu">
    <tr >
        <td >Название</td>
        <td >Стоимость</td>
    </tr>
    <c:forEach var="dish"  items="${order}">
        <tr>
            <td><c:out value="${dish.dishName}" /></td>
            <td><c:out value="${dish.dishPrice}" /></td>
            <td><a href="controller?command=delete_from_order&orderId=${dish.id} ">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="controller?command=goaddto_order">Lобавить в заказ</a>
<a href="controller?command=backuser">Вернуться обратно</a>
<a href="controller?command=logout">Выйти из системы</a>


</body>
</html>