<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <%--errorPage="../error.jsp"--%>
<%@ page import="by.mazan.service.DataService" %>
<%@ page import="by.mazan.cookie.UserCookie" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Log In</title>
</head>
<body>
<%
    boolean bol = new DataService().checkUsers(request.getParameter("name"),request.getParameter("password"));
%>

<% if (bol)  {%>
<% new UserCookie().addCookie(request, response);%>
<c:redirect url="infoPage.jsp"/>
<%}else{%>
<c:redirect url="logPage.jsp"/>
<%}%>
</body>
</html>
