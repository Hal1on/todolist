<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
    <title>Sign up</title>
</head>
<body>
<div class="singup">
    <div class="authorizationText">Sign up</div>
    <form name="registrationForm" method="POST" action="controller" autocomplete="off">
        <input type="hidden" name="command" value="registration"/>
        <input type="text" name="login" aria-label="Login"/><br>
        <input type="password" name="password" aria-label="Password"/><br>
        ${user_exist}<br>
        <input class="submit" type="submit" value="Sign up"/>
    </form>
</div>
<div class="goToLogin">
    <p>Have an account?&nbsp</p>
    <p><a href="/index.jsp">Log in</a></p>
</div>
</body>
</html>
