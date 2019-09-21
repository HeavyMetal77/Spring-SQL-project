<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>CreateTable</title>
</head>
<body>
<p>Создание таблицы:</p><br>

<form:form action="createTable" method="post" modelAttribute="table">
    <table>
        <tr>
            <td><form:label path="nameTable">Таблица</form:label></td>
            <td><form:input path="nameTable"/></td>
        </tr>
        <tr>
            <td><form:label path="columnName">Название столбца</form:label></td>
            <td><form:input path="columnName"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="createTable"/></td>
        </tr>
    </table>
</form:form>

<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
</body>
</html>