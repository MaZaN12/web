<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Log In</title>
    <link rel="stylesheet" type="text/css" href="../style/logStyle.css">
</head>
<body>
<form class="box" action="logPageProcessing.jsp" method="post">
    <h1>Login</h1>
    <input type="text" name="name" placeholder="Username" value="" required >
    <input type="password" name="password" placeholder="Password" value="" required>
    <input type="submit" name="" value="Login">
</form>
</body>
</html>
