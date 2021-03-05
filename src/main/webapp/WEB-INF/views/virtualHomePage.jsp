<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/assets/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/imageStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/anchorStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/calendarStyle.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<noscript><link href="<c:url value="/resources/assets/css/noscript.css" />" rel="stylesheet"></noscript>
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

<title>가상 홈페이지</title>
</head>
<body class="is-preload" name = "top" onload = "showClock()">
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header -->
		<header id="header" class="alt">
			<a href = "/virtualHomePage" class = "imageLink"><img src = "/resources/image/home.png" class = "virtualHomePageImageSytle"/></a>
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
					<li><a href = "virtualHomePage/MemberInformation"><button class="fitbutton">${pageContext.request.userPrincipal.name}님</button></a></li>
					<li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><button class="primaryFitbutton">로그아웃</button></a></li>
				</c:if>
			</ul>
		</nav>
		
		<!-- Banner -->
		<section id="banner" class="major">
			<div class="inner">
					
				<header class="major">
					<div align = "center">
						<h1 style = "color:white;">가상 홈페이지</h1>
					</div>
				</header>
			</div>
		</section>
		
		<!-- Main -->
		<div id="main">
			<!-- One -->
				<section id="one" class="tiles">
					<article>
						<span class="image">
							<img src="/resources/image/pic01.jpg" alt="" />
						</span>
						<header>
							<div class="cal_top">
								<a href="#one" id="movePrevMonth"><span id="prevMonth" class="cal_tit">&lt;</span></a>
								<span id="cal_top_year"></span>
								<span id="cal_top_month"></span>
								<a href="#one" id="moveNextMonth"><span id="nextMonth" class="cal_tit">&gt;</span></a>
							</div>
							<div id="cal_tab" class="cal"></div>
						</header>
					</article>
					<article>
						<span class="image">
							<img src="/resources/image/pic02.jpg" alt="" />
						</span>
						<header>
							<section id="contact">
								<div class = "virtualHomePageLoginDivStyle">
									<div align = "center">
										<section class="split">
											<section>
													<c:if test="${empty pageContext.request.userPrincipal}">
														<a href = "/virtualHomePage/loginPage"><button class = "button1"><span><img src = "image/logIn.png" class = "logInImageStyle"/>로그인</span></button></a><br/>
													</c:if>
													<c:if test="${not empty pageContext.request.userPrincipal}">
													<span>
														&nbsp;&nbsp;&nbsp;&nbsp;<label>${pageContext.request.userPrincipal.name}님</label>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href = "virtualHomePage/MemberInformation"><button id = "memberbtn" class = "memberInformationbutton"><img src = "image/Lock.png" class = "LockImageStyle1"/>&nbsp;회원정보</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
													</span><br/><br/>
													</c:if>
											</section>
											<section>
													<c:if test="${empty pageContext.request.userPrincipal}">
														<span>
															&nbsp;&nbsp;<img src = "image/Lock.png" class = "LockImageStyle"/><a href = "/virtualHomePage/idFind"><button class = "button2">아이디 찾기</button></a>·
															<a href = "/virtualHomePage/PasswordFind"><button class = "button2">비밀번호 찾기</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<a href = "/virtualHomePage/signUp"><button class = "button2">회원가입</button></a>&nbsp;
														</span>
													</c:if>
													<c:if test="${not empty pageContext.request.userPrincipal}">
														<a href="${pageContext.request.contextPath}/j_spring_security_logout"><button class = "logOutbutton"><img src = "image/logout.png" class = "logoutImageStyle"/>로그 아웃</button></a>
														
													</c:if>
												
											</section>
										</section>
									</div>
								</div>
							</section>
						</header>
					</article>
					<article>
						<span class="image">
							<img src="/resources/image/pic03.jpg" alt="" />
						</span>
						<header class="major">
							<h3><a href="/virtualHomePage/virtualBulletinBoard?page=1" class="link">게시판</a></h3>
							<p>자유 게시판</p>
						</header>
					</article>
					<article>
						<span class="image">
							<img src="/resources/image/pic04.jpg" alt="" />
						</span>
						<header>
						<div class = "clockBackgroundDivStyle">
							<div class = "clockBcackgroundImageDivStyle"><img src="/resources/image/background.png" class = "backgroundImageStyle"/></div>
							<div class = "clockBackgroundTextDivStyle">
								<span id = "divHour" class = "hourSpanStyle"></span>&nbsp;:&nbsp; 
								<span id = "divMinute" class = "minuteSpanStyle"></span>&nbsp;:&nbsp;
								<span id = "divSecond" class = "secondSpanStyle"></span>&nbsp;
								<span id = "divApm" class = "apmSpanStyle"></span>
							</div>
						</div>
						</header>
					</article>
				</section>
			</div>
			<button id = "top" class = "Topbutton" hidden =""><img src = "image/top.png" class = "topImageStyle"/></button>
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
		<script src='<c:url value="/resources/js/hiddenTop.js"/>'></script>
		<script src='<c:url value="/resources/js/Calendar/Calendar.js"/>'></script>
		<script src='<c:url value="/resources/js/Calendar/Calendar1.js"/>'></script>
		<script src='<c:url value="/resources/js/Calendar/CalendarPre.js"/>'></script>
		<script src='<c:url value="/resources/js/Calendar/CalendarReady.js"/>'></script>
		<script src='<c:url value="/resources/js/Calendar/CalendarSche.js"/>'></script>
		<script src='<c:url value="/resources/js/Clock.js"/>'></script>
</body>
</html>