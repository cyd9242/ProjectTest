<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/assets/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/imageStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/msgStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<noscript><link href="<c:url value="/resources/assets/css/noscript.css" />" rel="stylesheet"></noscript>
<head>
	<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<title>비밀번호 변경</title>
</head>
<body class="is-preload" name = "top">

	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header -->
		<header id="header" class="alt">	
			<a href = "/virtualHomePage" class = "imageLink"><img src = "/resources/image/home.png" class = "virtualHomePageImageSytle"/></a>
			<nav>
				<a href = "/virtualHomePage/idFind"><button class = "idAndPwdFindbutton">아이디 찾기</button></a>				
			</nav>			
			<nav>
				<a href = "/virtualHomePage/PasswordFind"><button class = "idAndPwdFindbutton">비밀번호 찾기</button></a>
			</nav>
			<nav>
				<a href="#menu" style = "color:white;">Menu</a>
			</nav>
		</header>
		
		<!-- Menu -->
		<nav id="menu">
			<ul class="links">
				<li><a href="/virtualHomePage">홈페이지</a></li>
			</ul>
			<ul class="actions stacked">
				<c:if test="${empty pageContext.request.userPrincipal}">
					<li><a href="/virtualHomePage/signUp"><button class="primaryFitbutton">회원가입</button></a></li>
					<li><a href="/virtualHomePage/loginPage"><button class="fitbutton">로그인</button></a></li>
				</c:if>
				<c:if test="${not empty pageContext.request.userPrincipal}">
					<li><a href = "/virtualHomePage/MemberInformation"><button class="fitbutton">${pageContext.request.userPrincipal.name}님</button></a></li>
					<li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><button class="primaryFitbutton">로그아웃</button></a></li>
				</c:if>
			</ul>
		</nav>
		
		<!-- Banner -->
		<section id="banner" class="style9">
			<div class="inner">
				<header class="major">
					<div align = "center">
						<h1 style = "color:white;">비밀번호 재설정</h1>
					</div>
				</header>
			</div>
		</section>
		
		<!-- Main -->
		<div id="main">
			<!-- One -->
			<section id="one">
				<div class="inner">
					<header>
						<c:if test="${result ne null}"><br/>
							<div align = "center" class = "telPasswordFindFormDivStyle">
								<br/><label>가상홈페이지 아이디 : <c:out value = "${result}"/> </label><br/><br/>
								<form:form action = "/ResetPasswordOk" commandName = "VVO" method = "post"  onsubmit = "return checkResult()">
									<form:hidden path="vId" value = "${result}"/>
									<form:password path = "vPwd" id = "vPwd" placeholder = " 비밀번호" maxlength = "20" size = "26" style = "padding:7px; width:50%; border: 1px solid #ccc;"/><br/><br/>
									<form:password path = "vPwdRe" id = "vPwdRe" placeholder = " 비밀번호 확인" maxlength = "20" size = "26" style = "padding:7px; width:50%; border: 1px solid #ccc;"/><br/>
									<font name="check" size="2" color="red"></font>	<br/><br/><br/>
									<input type = "submit" value = "비밀번호 변경" class = "TelPasswordReSetUpbutton"/>
								</form:form>
							</div>
						</c:if>
						
						<c:if test="${empty result}">
							<div align = "center" class = "telPasswordFindFormDivStyle">
								<br/>
								회원가입을 먼저 해주세요.<br/><br/>
								<a href = "/virtualHomePage/signUp"><button class = "NotFindSignUpbutton">회원가입</button></a>
								<br/><br/>
							</div>
						</c:if>
						
					</header>
				</div>
			</section>
		</div>
	
	<button id = "top" class = "Topbutton" hidden = ""><img src = "/resources/image/top.png" class = "topImageStyle"/></button>
	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.scrolly.min.js"></script>
	<script src="/resources/assets/js/jquery.scrollex.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src='<c:url value="/resources/js/pwdCheck.js"/>'></script>
	<script src='<c:url value="/resources/js/PasswordFindResultCheck.js"/>'></script>
	<script src='<c:url value="/resources/js/hiddenTop.js"/>'></script>
</body>
</html>