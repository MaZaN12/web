<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" errorPage="../error.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>home</title>
    <link rel="stylesheet" type="text/css" href="../style/header.css">
    <link rel="stylesheet" type="text/css" href="../style/search.css">
    <link rel="stylesheet" type="text/css" href="../style/table.css">
</head>
<body>
<div class="header">
    <form action="logPage.jsp" method="post">
        <input class="generation" type="submit" name="" value="Generating 1 million factors">
    </form>
    <form action="logPage.jsp" method="post">
        <input class="headerButton" type="submit" name="" value="Log Out">
    </form>
    <form action="logPage.jsp" method="post">
        <input class="headerButton" type="submit" name="" value="User editing">
    </form>
    <form action="logPage.jsp" method="post">
        <input class="headerButton" type="submit" name="" value="Adding User">
    </form>
    <form action="home.jsp" method="post">
        <input class="headerButton" type="submit" name="" value="Home">
    </form>
</div>

    <jsp:useBean id="userProvider" class="by.mazan.service.DataService" scope="request">

        <div class="table" id="scroll">
            <h1>Last 50 factors</h1>
            <table>
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
        </div>

    </jsp:useBean>


    <form class="search" action="logPage.jsp">
        <div>
            <input type="text" name="fromDate" placeholder="From" value="">
            <input type="text" name="beforeDate" placeholder="Before" value="">
        </div>
        <div>
            <input type="submit" value="Push">
        </div>
    </form>

</body>
</html>