<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr bgcolor="#CCCCCC">
            <td align="center"><strong>Фамилия</strong></td>
            <td align="center"><strong>Имя</strong></td>
        </tr>
        <c:forEach var="client" items="${userList}">
            <tr>
                <td><c:out value="${ client.lastName }" /></td>
                <td><c:out value="${ client.firstName }" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
