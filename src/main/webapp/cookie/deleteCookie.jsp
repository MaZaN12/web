<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="by.mazan.cookie.UserCookie" %>

<html>
<head>
    <meta charset="utf-8">
    <title>deleteCookies</title>
</head>
<body>
<% new UserCookie().deleteCookie(request, response);%>
<c:redirect url="../form/logPage.jsp"/>
</body>
</html>