<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERROR PAGE</title>
</head>
<body>
    <div class = "errorDivStyle">
    
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 400}">
			<div class = "lbl-group labela">
				<label style = "text-align:center; font-size:150px; color:red;">400</label> 
				<div class = "label-group"><br/><br/><br/>
					<label class = "errorLabel">잘못된 요청입니다.</label>
					<label class = "errorLabel"><a href="<c:url value='/virtualHomePage'/>"> [HOME]</a> 을 클릭하시면, 홈으로 돌아갑니다.</label>   
				</div>
			</div>
		</c:if>
		
	    <c:if test="${requestScope['javax.servlet.error.status_code'] == 403}">		
			<div class = "lbl-group labela">
				<label style = "text-align:center; font-size:150px; color:red;">403</label> 
				<div class = "label-group"><br/><br/><br/>
					<label class = "errorLabel">접근이 금지되었습니다.</label>
					<label class = "errorLabel"><a href="<c:url value='/virtualHomePage'/>"> [HOME]</a> 을 클릭하시면, 홈으로 돌아갑니다.</label>   
				</div>
			</div>
		</c:if>
		
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 404}">
			<div class = "lbl-group labela">
				<label style = "text-align:center; font-size:150px; color:red;">404</label> 
				<div class = "label-group"><br/><br/><br/>
					<label class = "errorLabel">페이지를 찾을 수 없습니다.</label>
					<label class = "errorLabel"><a href="<c:url value='/virtualHomePage'/>"> [HOME]</a> 을 클릭하시면, 홈으로 돌아갑니다.</label>   
				</div>
			</div>
		</c:if>
		
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 405}">
			<div class = "lbl-group labela">
				<label style = "text-align:center; font-size:150px; color:red;">405</label> 
				<div class = "label-group"><br/><br/><br/>
					<label class = "errorLabel">요청된 메소드가 허용되지 않습니다.</label>
					<label class = "errorLabel"><a href="<c:url value='/virtualHomePage'/>"> [HOME]</a> 을 클릭하시면, 홈으로 돌아갑니다.</label>   
				</div>
			</div>
		</c:if>
		
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 500}">
			<div class = "lbl-group labela">
				<label style = "text-align:center; font-size:150px; color:red;">500</label> 
				<div class = "label-group"><br/><br/><br/>
					<label class = "errorLabel">서버에 오류가 발생하였습니다.</label>
					<label class = "errorLabel"><a href="<c:url value='/virtualHomePage'/>"> [HOME]</a> 을 클릭하시면, 홈으로 돌아갑니다.</label>   
				</div>
			</div>
		</c:if>
		
		<c:if test="${requestScope['javax.servlet.error.status_code'] == 503}">
			<div class = "lbl-group labela">
				<label style = "text-align:center; font-size:150px; color:red;">503</label> 
				<div class = "label-group"><br/><br/><br/>
					<label class = "errorLabel">서비스를 사용할 수 없습니다.</label>
					<label class = "errorLabel"><a href="<c:url value='/virtualHomePage'/>"> [HOME]</a> 을 클릭하시면, 홈으로 돌아갑니다.</label>   
				</div>
			</div>
		</c:if>
    </div>
	
</body>
</html>
