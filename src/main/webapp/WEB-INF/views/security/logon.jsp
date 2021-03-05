<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logon page</title>
</head>
<body>
<c:if test="${not empty pageContext.request.userPrincipal}">
	<h2>${pageContext.request.userPrincipal.name}님 반갑습니다!!!</h2><br/>
	<meta http-equiv="refresh" content="5; url=virtualHomePage">
	<div id = "displayCounter"></div> 	
</c:if>

<c:if test="${empty pageContext.request.userPrincipal}">
	<h2>로그아웃 되었습니다.</h2><br/>
</c:if>

<a href="${pageContext.request.contextPath}/j_spring_security_logout">로그 아웃</a>
</body>
</html>
