<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Drop</title>
</head>
<body>
<p>Удалить таблицу:</p><br>

<form:form action="drop" method="post" modelAttribute="table">
    <table>
        <tr>
            <td><form:label path="nameTable">Таблица</form:label></td>
            <td><form:input path="nameTable"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="drop"/></td>
        </tr>
    </table>
</form:form>

<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
</body>
</html>