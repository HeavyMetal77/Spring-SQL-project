<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update</title>
</head>
<body>
<p>Обновление значений таблицы:</p><br>
<form action="update" method="post">
    <table>
        <tr>
            <td>Введите название таблицы:</td>
            <td><input type="text" name="table"/></td>
        </tr>
        <tr>
            <td>Введите название столбца1:</td>
            <td><input type="text" name="table"/></td>
        </tr>
        <tr>
            <td>Введите значение столбца1:</td>
            <td><input type="text" name="table"/></td>
        </tr>
        <tr>
        <tr>
            <td>Введите название столбца2:</td>
            <td><input type="text" name="table"/></td>
        </tr>
        <tr>
            <td>Введите значение столбца2:</td>
            <td><input type="text" name="table"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="update"/></td>
        </tr>
    </table>
</form>
<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
<a href="find">Find</a> <br>
</body>
</html>