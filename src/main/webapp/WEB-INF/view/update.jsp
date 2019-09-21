<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Update</title>
</head>
<body>
<p>Обновление значений таблицы:</p><br>
<form:form action="update" method="post" modelAttribute="table">
    <table>
        <tr>
            <td><form:label path="nameTable">Название таблицы</form:label></td>
            <td><form:input path="nameTable"/></td>
        </tr>
        <tr>
            <td><form:label path="columnName">Где название столбца</form:label></td>
            <td><form:input path="columnName"/></td>
        </tr>
        <tr>
            <td><form:label path="columnValue">Значение столбца</form:label></td>
            <td><form:input path="columnValue"/></td>
        </tr>
        <tr>
            <td><form:label path="changeColumnName">Найти название столбца2</form:label></td>
            <td><form:input path="changeColumnName"/></td>
        </tr>
        <tr>
            <td><form:label path="changeColumnValue">Новое значение столбца2</form:label></td>
            <td><form:input path="changeColumnValue"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="update"/></td>
        </tr>
    </table>
</form:form>

<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
<a href="tables">Tables</a> <br>
</body>
</html>