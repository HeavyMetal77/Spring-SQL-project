<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>DropDB</title>
</head>
<body>
<p>Удалить базу данных:</p><br>
<form:form action="DBdrop" method="post" modelAttribute="database">
    <table>
        <tr>
            <td><form:label path="databaseName">Название БД</form:label></td>
            <td><form:input path="databaseName"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="DBdrop"/></td>
        </tr>
    </table>
</form:form>

<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
</body>
</html>