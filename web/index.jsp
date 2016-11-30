<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="message_en_EN"/>
<html>
<head>
    <title><fmt:message key="login.title" /></title>
</head>
<body>
<%@include file="../WEB-INF/jspf/header.jspf"%>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login" />
    Введите ваш логин и пароль: <br/>
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="email" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" value="" size="20" /></td>
        </tr>
    </table>
    ${errorLoginOrPassword} <br />
    <input type="submit" value="Войти" />
    <a href="controller?command=gotoregistration">Регистрация</a>
</form>
</body>
</html>