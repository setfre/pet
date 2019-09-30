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
	<table>
		<thead>	 
			<tr>
				<th>id</th>
				<th>昵称</th>
				<th>用户名</th>
				<th>角色</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pagination.bean}" var="pet">
										<tr>
											<th><input type='checkbox' name='recordId'/></th>
											<th>${pet.id}</th>
											<th>${pet.username}</th>
											<th>${pet.loginId}</th>
											<c:forEach items="${roles}" var="role">
												<c:if test="${role.id == user.roleId }">
													<th>${role.name}</th> 
												</c:if>
											</c:forEach>
											<th>
												<a href="http://localhost:8080/pet/userResourse/doDelete.action?id=${u.id}">删除</a>
												<a href="http://localhost:8080/pet/pageResourse/toUpdate.action">更改</a> 
											</th>
										</tr>
									</c:forEach>
			<tr>
				<th>序号</th>
				<th>主人</th>
				<th>临时名字</th>
				<th>宠物类型</th>
				<th>健康度</th>
				<th>感情值</th>
				<th>添加时间</th>
				<th>宠物照片</th>
				<th>操作</th>
			</tr> 
		</thead>
		
		<c:forEach items="${pagination.bean}" var="pet" varStatus="v">
			<tr>
				<th>${v.count}</th>
				<th>${pet.master.username}</th>
				<th>${pet.petName}</th>
				<th>${pet.petType.typeName}</th>
				<th>${pet.health}</th>
				<th>${pet.love}</th>
				<th>${pet.addTime}</th>
				<th>${pet.picPath}</th> 
				<th><a href="">领养</a></th>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>