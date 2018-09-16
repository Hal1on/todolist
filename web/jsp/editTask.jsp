<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <script src="../js/script.js"></script>
</head>

    <form name="editTaskForm" method="POST" action="controller" autocomplete="off">
        <input type="hidden" name="command" value="edit"/>
        <input type="hidden" name="login" value="${login}"/>
        <input type="hidden" name="task_id" value="${task_id}"/>
        <input type="hidden" name="tasks" value="${tasks}"/>
        <input type="hidden" name="user_id" value="${user_id}">
        <input type="text" name="text_field" value="${previous_text_field}"/>

        <c:choose>
            <c:when test="${completed}">
                <input type="checkbox" name="completed" value="true" checked/>
                <input type="hidden" name="completed" value="false"/>
            </c:when>
            <c:otherwise>
                <input type="checkbox" name="completed" value="true"/>
                <input type="hidden" name="completed" value="false"/>
            </c:otherwise>
        </c:choose>

        <input type="submit" value="edit"/>
    </form>


    <form name="cancelForm" method="POST" action="controller" autocomplete="off">
        <input type="hidden" name="command" value="login"/>
        <input type="hidden" name="login" value="${login}"/>
        <input type="hidden" name="password" value="${password}"/>
        <input type="submit" value="cancel">
    </form>
<%--
</div>

</body>--%>
