<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Task</title>
</head>
<body>

<h2>Create a New Task</h2>

<form action="/tasks" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br>

    <label for="status">Status:</label>
    <select id="status" name="status" required>
        <option value="incomplete">Incomplete</option>
        <option value="complete">Complete</option>
    </select><br>

    <label for="dueDate">Due Date:</label>
    <input type="date" id="dueDate" name="dueDate" required><br>

    <button type="submit">Create Task</button>
</form>

</body>
</html>
