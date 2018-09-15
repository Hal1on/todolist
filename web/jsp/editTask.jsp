<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Edit Task</h1>
<form name="editTaskForm" method="POST" action="controller" autocomplete="off">
    <input type="hidden" name="command" value="edit"/>
    <input type="hidden" name="login" value="${login}"/>
    <input type="hidden" name="task_id" value="${task_id}"/>
    <input type="hidden" name="tasks" value="${tasks}"/>
    <input type="hidden" name="user_id" value="${user_id}">

    <input type="text" name="text_field" value="${previous_text_field}"/><br>
    completed

    <c:choose>
        <c:when test="${completed}">
            <input type="checkbox" name= "completed" value="true" checked/>
            <input type="hidden" name= "completed" value="false"/>
        </c:when>
        <c:otherwise>
            <input type="checkbox" name= "completed" value="true"/>
            <input type="hidden" name= "completed" value="false"/>
        </c:otherwise>
    </c:choose>

    <input type="submit" value="edit"/>
</form>
</body>
</html>
