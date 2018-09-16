<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main page</title>
    <link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="../js/script.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-left">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            </button>
            <a class="navbar-brand right" onclick="history.go(0)">TODOLIST</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">${login}<b
                            class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="controller?command=logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="headerwrap">
    <div class="container">
        <div class="row left">
            <c:forEach items="${tasks}" var="element">
                <c:choose>
                    <c:when test="${element.completed}">
                        <p style="text-decoration: line-through">${element.textField}</p>
                    </c:when>
                    <c:otherwise>
                        <p>${element.textField}</p>
                    </c:otherwise>
                </c:choose>
                <form id="${element.id}">
                    <input type="hidden" id="command" name="command" value="edit">
                    <input type="hidden" id="task_id" name="task_id" value="${element.id}">
                    <input type="hidden" id="login" name="login" value="${login}">
                    <input type="hidden" id="previous_text_field" name="previous_text_field"
                           value="${element.textField}">
                    <input type="hidden" id="completed" name="completed" value="${element.completed}">
                    <input type="hidden" id="user_id" name="user_id" value="${user_id}">
                    <input type="button" onclick="scriptEdit(${element.id})" value="edit">
                </form>
                <form name="deleteTaskForm" method="POST" action="controller" autocomplete="off">
                    <input type="hidden" name="command" value="delete">
                    <input type="hidden" name="task_id" value="${element.id}">
                    <input type="hidden" name="login" value="${login}">
                    <input type="submit" value="delete">
                    <hr>
                </form>
            </c:forEach>
            <form name="addTaskForm" method="POST" action="controller">
                <input type="hidden" name="command" value="addtask"/>
                <input type="hidden" name="login" value="${login}"/>
                <input type="text" name="text_field" value=""/>
                <input type="submit" value="Add"/>
            </form>
        </div>
    </div>
</div>
<div id="footer">
    <div class="container">
        <div class="row centered">
            <a href="https://vk.com/bukhavtsov_artyom"><i class="fab fa-vk fa-2x"></i></a>
            <a href="https://vk.com/bukhavtsov_artyom"><i class="fab fa-instagram fa-2x"></i></a>
            <a href="https://vk.com/bukhavtsov_artyom"><i class="fab fa-github fa-2x"></i></a>
        </div>
    </div>
</div>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</body>
</html>





