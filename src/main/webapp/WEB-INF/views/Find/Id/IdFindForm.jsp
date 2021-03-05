<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/assets/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/imageStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/anchorStyle.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<noscript><link href="<c:url value="/resources/assets/css/noscript.css" />" rel="stylesheet"></noscript>
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<title>아이디 찾기</title>
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
			<!-- <label class = "idFindlabel">아이디 찾기</label> -->
			<!-- <label class = "passwordFindlabel">비밀번호 찾기</label> -->
			<nav>
				<a href="#menu" style = "color:white;">Menu</a>
			</nav>
		</header>
		
		<!-- Menu -->
		<nav id="menu">
			<ul class="links">
				<li><a href="index">웹</a></li>
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
		<section id="banner" class="style2">
			<div class="inner">
				<header class="major">
					<div align = "center">
						<h1 style = "color:white;">아이디 찾기</h1>
					</div>
				</header>
			</div>
		</section>
		
		<!-- Main -->
		<br/>
		<!-- Contact -->
		<section id="contact">
			<section class="split">
				<section>
					<div class="contact-method">
						<div align = "center">
							<div class = "idFindFormDivStyle">
								<a href = "/virtualHomePage/idFind/EmailIdFind"><button class = "EandTbutton"><img src = "/resources/image/E.png" class = "EandTImageStyle"/>&nbsp;가입한 이메일로 아이디 찾기</button></a>
							</div>
						</div>
					</div>
				</section>
				<section>
					<div class="contact-method">
						<div align = "center">
							<div class = "idFindFormDivStyle">
								<a href = "/virtualHomePage/idFind/TelIdFind"><button class = "EandTbutton"><img src = "/resources/image/T.png" class = "EandTImageStyle"/>&nbsp;가입한 핸드폰 번호로 아이디 찾기</button></a>
							</div>
						</div>
					</div>
				</section>
			</section>
		</section>
	</div>
	
	
	<!-- Scripts -->
	<script src='<c:url value="/resources/assets/js/jquery.min.js"/>'></script>
	<script src='<c:url value="/resources/assets/js/jquery.scrolly.min.js"/>'></script>
	<script src='<c:url value="/resources/assets/js/jquery.scrollex.min.js"/>'></script>
	<script src='<c:url value="/resources/assets/js/browser.min.js"/>'></script>
	<script src='<c:url value="/resources/assets/js/breakpoints.min.js"/>'></script>
	<script src='<c:url value="/resources/assets/js/util.js"/>'></script>
	<script src='<c:url value="/resources/assets/js/main.js"/>'></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	<script src='<c:url value="/resources/js/hidden.js"/>'></script>
	<script src='<c:url value="/resources/js/membershipWithdrawal.js"/>'></script>
	<script src='<c:url value="/resources/js/membershipWithdrawalCheck.js"/>'></script>
</body>
</html>