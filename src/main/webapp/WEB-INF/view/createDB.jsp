<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>CreateDB</title>
</head>
<body>
<p>Создание базы данных:</p><br>

<form:form action="createDB" method="post" modelAttribute="database">
    <table>
        <tr>
            <td><form:label path="databaseName">Название БД</form:label></td>
            <td><form:input path="databaseName"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="createDB"/></td>
        </tr>
    </table>
</form:form>

<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
</body>
</html>