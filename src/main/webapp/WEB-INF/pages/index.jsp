<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List users</title>
</head>
<body>

<h2>All Users</h2>
<table border="1px">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>option</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<h2>Add new User</h2>
<form action="/add" method="post">
    <input type="text" name="name" placeholder="user name">
    <input type="text" name="email" placeholder="user email">
    <input type="submit" value="create!"/>
</form>
</body>
</html>