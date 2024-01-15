<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task List</title>
</head>
<body>

<h2>Task List</h2>

<c:if test="${not empty tasks}">
    <ul>
        <c:forEach var="task" items="${tasks}">
            <li>
                <a href="<c:url value='/tasks/${task.id}'/>">${task.title}</a>
            </li>
        </c:forEach>
    </ul>
</c:if>

<hr>

<h2>Task Details</h2>

<c:if test="${not empty task}">
    <p>Title: ${task.title}</p>
    <p>Description: ${task.description}</p>
    <p>Status: ${task.status}</p>
    <p>Due Date: ${task.dueDate}</p>

    <a href="<c:url value='/tasks/${task.id}/edit'/>">Edit Task</a>
</c:if>

<a href="<c:url value='/tasks/new'/>">Create a New Task</a>

</body>
</html>
