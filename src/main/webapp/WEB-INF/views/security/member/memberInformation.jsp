<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>회원 정보</title>
</head>
<body class="is-preload" name = "top">
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
						<h1 style = "color:white;">가상 홈페이지</h1>
					</div>
				</header>
			</div>
		</section>
		
		<!-- Main -->
		<div id="main">
			<!-- Contact -->
			<section id="contact">
				<div class="inner">
					<section>
						<div class="fields">
							<div class = "memberInformationOneDivStyle">
								<br/>
								<c:forEach items = "${Member}" var = "user">
								<label class = "MemberInformationNameLabel"><c:out value="${user.vNickName}"/>(${pageContext.request.userPrincipal.name})님</label><br/><br/>
								<div class = "memberInformationOne_OneDivStyle">
									<c:if test="${empty user.vMemberModificationDate}">
										<label class = "MemberInformationLabel">회원가입 날짜 : <fmt:formatDate pattern="yyyy년MM월 dd일" value="${user.vDate}"/></label><br/>
									</c:if>
									<c:if test="${not empty user.vMemberModificationDate}">
										<label class = "MemberInformationLabel">회원가입 날짜 : <fmt:formatDate pattern="yyyy년MM월 dd일" value="${user.vDate}"/></label><br/>
										<label class = "MemberInformationLabel">개인정보 업데이트 날짜 : <fmt:formatDate pattern="yyyy년MM월 dd일" value="${user.vMemberModificationDate}"/></label>
									</c:if>
								</div>
								<br/>
								</c:forEach>
								
							</div>
						</div>
					</section>
					<section class="split">
						<section>
							<div class="contact-method">
								<div class = "memberInformationTwoDivStyle">
									<a href = "/virtualHomePage/MemberInformation/MemberInformationCertification"><button class = "MemberInformationbutton">회원정보 수정</button></a>
								</div>
							</div>
						</section>
						<section>
							<div class="contact-method">
								<div class = "memberInformationThreeDivStyle">
									<button class = "MemberInformationbutton" onClick = "membershipWithdrawal()">회원탈퇴</button>
								</div>
							</div>
						</section>
						<section>
							<div class="contact-method">
								<div class = "memberInformationFourDivStyle">
									<div class = "memberInformationTotalDivStyle">
										<div align = "center">
											<label><c:out value="${NickName}"/>(${pageContext.request.userPrincipal.name})님</label>
										</div>
									</div>
									<label>총 게시글 수 :</label>
										&nbsp;<a href = "/virtualHomePage/virtualMemberBulletinBoard?page=1&vId=${pageContext.request.userPrincipal.name}"><c:out value="${userTotal}"/></a><br/>
									<label>총 댓글 수 :</label>
										&nbsp;<a href = "/virtualHomePage/virtualMemberCommentBulletinBoard?page=1&vId=${pageContext.request.userPrincipal.name}"><c:out value="${MemberCommentCount}"/></a>	
								</div>
							</div>
						</section>
					</section>
				</div>
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