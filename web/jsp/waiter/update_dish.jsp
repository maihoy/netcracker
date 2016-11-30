<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Dish update</title>
</head>
<body>
<form name="updateDishForm" method="POST" action="controller">
    <input type="hidden" name="command" value="update_dish" />
<input type="hidden" name="dishId" value="${dishToEdit.id}">
    <table>
        <tr>
            <td>Название:</td>
            <td><input type="text" name="dishName" value="${dishToEdit.name}" size="20" required/></td>
        </tr>
        <tr>
            <td>Стоимость:</td>
            <td><input type="text" name="dishPrice" value="${dishToEdit.price}" size="20" required  /></td>
        </tr>
        <tr>
            <td></td>
        </tr>
    </table>
     <br />
    <input type="submit" value="Обновить" />
    <a href="controller?command=back">Вернуться обратно</a>
</form>


</body>
</html>