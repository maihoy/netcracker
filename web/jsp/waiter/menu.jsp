<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Меню</title>
</head>
<body>
<table border="1px"  title="Menu">
    <tr >
        <td >Название</td>
        <td >Стоимость</td>
    </tr>
    <c:forEach var="dish" items="${dishList}">
        <tr>
            <td><c:out value="${ dish.name }" /></td>
            <td><c:out value="${ dish.price }" /></td>
            <td><a href="controller?command=gotoeditdish&dishId=${dish.id}">Изменить</a></td>
            <td><a href="controller?command=delete_dish&dishId=${dish.id}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<a href="controller?command=gotoadd_dish">Добавить в меню</a>
<a href="controller?command=backwaiter">Вернуться обратно</a>
<a href="controller?command=logout">Выйти из системы</a>


</body>
</html>