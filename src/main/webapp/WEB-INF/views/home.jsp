<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<link href="<c:url value="/resources/css/imageStyle.css" />" rel="stylesheet">
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<div align = "center">
<a href = "virtualHomePage"><img src = "image/home.png" class = "HomeImgeStyle"></a><br/>
<h1>가상 홈페이지에 어서오세요.</h1>
<P><label>  현재시간 ${serverTime}. </label></P>
<c:if test="${not empty pageContext.request.userPrincipal}">
	<h2>${pageContext.request.userPrincipal.name}님 반갑습니다!!!</h2><br/>
	<a href="${pageContext.request.contextPath}/j_spring_security_logout">로그 아웃</a>
</c:if>
	
</div>
</body>
</html>
