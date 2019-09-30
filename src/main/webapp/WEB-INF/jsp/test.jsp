<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	id:${user.id},username:${user.loginId},index:${pagination.currentIndex}
	<table>
		<c:forEach items="${pagination.bean}" var="user"> 
			<tr>
				<th>${user.id}</th>
				<th>${user.username}</th>
				<th>${user.loginId}</th>
				<th>${user.roleId}</th> 
				<th>
					<a href="http://localhost:8080/petshop/userResourse/doDelete.action?id=${u.id}">删除</a>
					<a href="">更改</a> 
				</th>
	
			</tr>
		</c:forEach>
	</table>
</body>
</html>