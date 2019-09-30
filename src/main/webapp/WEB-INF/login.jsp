<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
</head>

<style>
	body{
		/*background-image: url(img/6.jpg);*/
	}
	.section{
		display: flex;
		height: 80vh;/*!!!!响应式垂直居中重点!!!!*/
	}
	
	.navbar{
		width: 100%;
		border: 0px solid saddlebrown;
	}
	.section-login{
		width: 400px;  
		height: 400px;
		border: 0px solid forestgreen;
		margin:auto; 
	}
	.section-login,.section-card{
		background-color: white;
	}
	.section-card{
		border-top-left-radius:5%;
		border-top-right-radius:5%;
	}
	.section-login-header{
		height: ;
	}
	.section-login-body{
		padding:90px 30px 15px 30px;
		border: 1px solid #E0E0E0;
	}
	.section-login-cells{
		border: 0px solid seagreen;
		display: inline-block;
		width: 100%; 
	}
	.section-card{
		height: 40px;
		padding: 6px 0;
	}
	.section-card-stu{
		border-bottom: none;
	}
	.protocol{
		width: 400px;
		height: 4em;
		font-size: 0.7em;
		border: 0px solid #182631;
		margin:0 auto;
		text-align: center;
	}
	.section-login-message{
		padding: 20px 0;
		text-align: center;
	}
</style>
<script>
	function changeFormLoginTo(dom){
		var actionTo = dom.innerHTML;
		var cards = document.getElementsByClassName("section-card");
		for(var i=0,len=cards.length;i<len;i++){
			cards[i].style.borderBottom = "1px solid #E0E0E0";
		} 
		dom.style.borderBottom ="none";
		if("普通用户"==actionTo){
			document.getElementById("form-role").value = "1";
			return;
		}
		if("管理员"==actionTo){
			document.getElementById("form-role").value = "2";
			return;
		} 
	}
	function changeFormRegisterTo(opt){
		if(opt == 0){
			document.getElementById("to-login").style.display = "none";
			document.getElementById("to-regist").style.display = "";
			document.getElementById("form-btn").innerHTML = "注册";
			document.getElementById("login").action = "http://localhost:8080/pet/userResourse/doRegist.action?operateStatus=1";
		}
		if(opt == 1){
			document.getElementById("to-regist").style.display = "none";
			document.getElementById("to-login").style.display = "";
			document.getElementById("form-btn").innerHTML = "登录";
			document.getElementById("login").action = "http://localhost:8080/pet/userResourse/doLogin.action?operateStatus=1";
		}
	}
</script>
<body>
	<!--
    	作者：hizworld
    	时间：2019-09-24
    	描述：
    -->
	<div class="header"><!--顶部栏-->
		<div class="navbar">
			<a href="http://localhost:8080/pet/petResourse/toPetshop.action">商店</a>
		</div>
	</div>
	<div class="section"><!--登录框-->
		<form id="login" class="section-login" action="http://localhost:8080/pet/userResourse/doLogin.action" method="post">
			
			<div class="section-login-header" style="text-align: center;">
				<span class="card col-6 float-left section-card section-card-stu" onclick="changeFormLoginTo(this)">普通用户</span>
				<span class="card col-6 float-left section-card" onclick="changeFormLoginTo(this)">管理员</span> 
			</div>
			<!-- 角色id -->
			<input id="form-role" type="hidden" value="1" name="roleId"/>
			<div class="section-login-body border-top-0">
				<div class="section-login-cells section-login-input">
					<div class="form-group">
						<div class="badge badge-primary">
							账号
						</div>
						<div>
							<input class="form-control" type="text" name="loginId"/>
						</div>
					</div>
					<div class="form-group">
						<div class="badge badge-primary">
							密码
						</div>
						<div>
							<input class="form-control" type="password" name="loginPwd"/>
						</div>
					</div>
				</div>
	
				<div class="section-login-cells section-login-tips">
					<span class="float-left mx-2"> 
						<input type="checkbox" /><span >我记住啦！</span>
					</span>
					<span class="float-right mx-2">
						<a id="to-login" href="javascript:changeFormRegisterTo(0)">没有账号?注册</a>
						<a id="to-regist" href="javascript:changeFormRegisterTo(1)" style="display: none;">已有账号?登录</a>
					</span>
				</div>
	
				<div class="section-login-cells section-login-submit">
					<button id="form-btn" class="btn btn-primary w-100" type="submit">登录</button>
				</div>
				
				<c:if test="${message != null}">
					<div class="section-login-cells section-login-message">
						<c:if test="${status == 100 || status == 101}">
							<div class="alert alert-danger">
								${message}	
							</div>
						</c:if>
						<c:if test="${status == 102}">
							<div class="alert alert-success">
								${message}	
							</div>
						</c:if>
						
					</div>
				</c:if>
			</div>
			
		</form>
	</div>
	<div class="footer mb-5">
		<div class="protocol"><!--底部栏-->
			<div>hello world</div>
			<div>this is test</div>
		</div>
	</div>
</body>
</html>