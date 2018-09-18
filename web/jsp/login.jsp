<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Login</title>
    <link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="../js/script.js"></script>
</head>
<body>
<%
    String login = (String) session.getAttribute("login");
    String password = (String) session.getAttribute("password");
    if (login != null && password != null) {
        String nextPage = "/jsp/main.jsp";
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }
%>
<div class="signin">
    <div class="authorizationText">Sign in</div>
    <form id="loginForm" name="loginForm" method="POST" action="controller" autocomplete="off">
        <input type="hidden" name="command" value="login"/>
        <input type="text" name="login" value="" aria-label="Login"/><br>
        <input type="password" name="password" value="" aria-label="Password"/><br>
        ${errorLoginPassMessage}<br>
        ${wrongAction}
        ${nullPage}
        <input class="submit" type="submit" value="Log in"/>
    </form>
</div>
<div class="goToSignup">
    <p>Don't have an account?&nbsp</p>
    <p><a href="controller?command=registration">Sign up</a></p>
</div>
</body>
</html>