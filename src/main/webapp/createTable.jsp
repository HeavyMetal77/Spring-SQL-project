<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>CreateTable</title>
</head>
<body>
<p>Создание таблицы:</p><br>
<form action="createTable" method="post">
    <table>
        <tr>
            <td>Введите название таблицы:</td>
            <td><input type="text" name="table"/></td>
        </tr>
        <tr>
            <td>Введите название столбца:</td>
            <td><input type="text" name="table"/></td>
        </tr>
        <tr>
            <td>Введите название столбца:</td>
            <td><input type="text" name="table"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="createTable"/></td>
        </tr>
    </table>
</form>
<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
</body>
</html>