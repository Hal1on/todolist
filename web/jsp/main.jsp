<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main page</title>
    <link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="../js/script.js"></script>
</head>
<body>
<h3>Welcome</h3>
<hr/>
${login}, hello!

<c:forEach items="${tasks}" var="element">
    <c:choose>

        <c:when test="${element.completed}">
            <p style="text-decoration: line-through">${element.textField}</p></td>
        </c:when>
        <c:otherwise>
            <p>${element.textField}</p>
            <td></td>
        </c:otherwise>
    </c:choose>

        <form name="editTaskForm" method="POST" action="controller" autocomplete="off">
            <input type="hidden" name="command" value="edit">
            <input type="hidden" name="task_id" value="${element.id}">
            <input type="hidden" name="login" value="${login}">
            <input type="hidden" name="previous_text_field" value="${element.textField}">
            <input type="hidden" name="completed" value="${element.completed}">
            <input type="hidden" name="user_id" value="${user_id}">
            <input type="submit" value="edit">
        </form>
        <form name="deleteTaskForm" method="POST" action="controller" autocomplete="off">
            <input type="hidden" name="command" value="delete">
            <input type="hidden" name="task_id" value="${element.id}">
            <input type="hidden" name="login" value="${login}">
            <input type="submit" value="delete">
        </form>
</c:forEach>

<form name="addTaskForm" method="POST" action="controller">
    <input type="hidden" name="command" value="addtask"/>
    <input type="hidden" name="login" value="${login}"/>
    <input type="text" name="text_field" value=""/>
    <input type="submit" value="Add"/>
</form>
<a href="controller?command=logout">Logout</a>
</body>
</html>