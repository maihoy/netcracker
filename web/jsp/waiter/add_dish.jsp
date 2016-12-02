<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление блюда</title>
</head>
<body>
<form name="addDishForm" method="POST" action="controller">
    <input type="hidden" name="command" value="add_dish" />
    <table>
        <tr>
            <td>Название:</td>
            <td><input type="text" name="dishName" value="" size="20" required/></td>
        </tr>
        <tr>
            <td>Стоимость:</td>
            <td><input type="text" name="dishPrice" value="" size="20" required/></td>
        </tr>

        <tr>
            <td>
                <input type="hidden" name="menuId" value="1" />
            </td>
        </tr>
    </table>
    ${operationMessage}
    ${errorDishExsists} <br />
    <input type="submit" value="Добавить" />
    <a href="controller?command=backwaiter">Вернуться обратно</a>
</form>


</body>
</html>