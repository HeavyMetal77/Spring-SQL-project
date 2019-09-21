<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Clear</title>
</head>
<body>
<p>Очистка данных таблицы:</p><br>

<form:form method="POST" action="clear" modelAttribute="table">
    <table>
        <tr>
            <td>Введите название таблицы, которую необходимо очистить:</td>
            <br>
            <td><form:input path="nameTable"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>


<a href="help">Help</a> <br>
<a href="menu">Menu</a> <br>
</body>
</html>