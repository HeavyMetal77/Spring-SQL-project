<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>FIND</title>
</head>
<body>
<h1>Find:</h1><br>
<table border="1">
    <c:forEach items="${listdataset}" var="row">
        <tr>
            <c:forEach items="${row}" var="element">
                <td>
                        ${element}<br>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
    <br>
    <a href="help">Help</a> <br>
    <a href="menu">Menu</a> <br>
    <a href="tables">Tables</a> <br>
</table>
</body>
</html>