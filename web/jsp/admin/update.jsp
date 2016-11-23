<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>update</title>
</head>
<body>
<form name="updateUserForm" method="POST" action="controller">
    <input type="hidden" name="command" value="update_user" />
    ваши данные:<br/>
    <table>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="firstName" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><input type="text" name="lastName" value="" size="20" /></td>
        </tr>
        <tr>
            <td>Почта:</td>
            <td><input type="text" name="email" value="${user.email}" size="20" disabled /></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" value="" size="20" /></td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>
                <select name="idRole">
                    <option value="3">ADMIN</option>
                    <option value="2">WAITER</option>
                    <option value="1">USER</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>State</td>
            <td>
                <select name="idState">
                    <option value="1">ACTIVE</option>
                    <option value="2">DELETED</option>
                </select>
            </td>
        </tr>
    </table>
    ${operationMessage}
    ${errorUserExsists} <br />
    <input type="submit" value="Update" />
    <a href="controller?command=back">Вернуться обратно</a>
</form>


</body>
</html>