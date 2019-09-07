<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>DropDB</title>
</head>
<body>
<p>Удалить базу данных:</p><br>
<form action="dbDrop" method="post">
    <table>
        <tr>
            <td>Введите название базы данных:</td>
            <td><input type="text" name="nameDB"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="drop"/></td>
        </tr>
    </table>
</form>
<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
</body>
</html>