<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" errorPage="../error.jsp" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Info</title>
    <link rel="stylesheet" type="text/css" href="../style/infoStyle.css">
</head>
<body>
<jsp:useBean id="userProvider" class="by.mazan.service.DataService" scope="request">
    <table class="styled-table">
        <thead>
        <tr>
            <td> ID </td>
            <td> Name </td>
            <td> Specialty </td>
            <td> Salary </td>
        </tr>
        </thead>
        <c:if test="${fn:length(userProvider.allEntitiesForResponse) > 0}">
        <c:forEach var="user" items="${userProvider.allEntitiesForResponse}">
            <tr class="user">
                <td> ${user.id} </td>
                <td> ${user.name} </td>
                <td> ${user.specialty} </td>
                <td> ${user.salary} </td>
            </tr>
        </c:forEach>
    </c:if>
    </table>
</jsp:useBean>
<form class="box" action="/web_war/data" method="post" >
    <input type="text" name="name" placeholder="Name" value="" required>
    <input type="text" name="specialty" placeholder="Specialty" value="" required>
    <input type="number"  name="salary" placeholder="Salary" value="" max="2147483647" required>
    <input type="submit" name="submit" value="submit">
</form>
<form class ="box" action="../cookie/deleteCookie.jsp" method="post">
    <input type="submit" value="Clear Cookie">
</form>
</body>
</html>
