<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/save" method="post">
        <input type="number" name="id" value="${user.id}">
        <input type="text" name="name" value="${user.name}">
        <input type="text" name="email" value="${user.email}">
        <input type="submit" value="save!">
    </form>
</body>
</html>
