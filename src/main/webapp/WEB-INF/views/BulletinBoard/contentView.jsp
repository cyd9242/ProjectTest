<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/imageStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/anchorStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/textareaStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/resources/assets/css/main.css" />
<noscript><link href="<c:url value="/resources/assets/css/noscript.css" />" rel="stylesheet"></noscript>
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<meta charset="UTF-8">
<c:if test="${title ne null}">
<title>게시글 : <c:out value="${title}"/></title>
</c:if>
</head>
<body class="is-preload">
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
				<span class="image">
					<img src="/resources/image/pic07.jpg" alt="" />
				</span>
				<header class="major">
					<div align = "center">
						<c:if test="${title ne null}">
							<h1 style = "color:white;">게시글 : <c:out value="${title}"/></h1>
						</c:if>
					</div>
				</header>
			</div>
		</section>
		
		<!-- Main -->
		<div id="main">
			<!-- One -->
			<section id="one">
				<div class="inner" align = "center">
					<header>
						<div class = "bbsContentDivStyle">
							<table class = "bbsContentTableStyle" cellpadding = "0" cellspacing = "0" border = "1">
								<tr>
									<td style = "border-top-left-radius:10px; border-top-right-radius:10px;">
										&nbsp;&nbsp;<label class = "bbsvSubjectLabel"><c:out value = "${contentView.vSubject}"/></label>&nbsp;<a href = "#Comment"><button class = "contentViewContentTotalbutton">[<c:out value = "${totalList}"/>]</button></a><br/>
										&nbsp;<a href = "/virtualHomePage/virtualMemberBulletinBoard?page=1&vId=${contentView.vId}"><button class = "contentUserbutton"><c:out value = "${contentView.vNickName}"/></button></a><br/>
										&nbsp;<label style = "font-size:10px; color:darkgray;">&nbsp;&nbsp;<fmt:formatDate pattern="yyyy.MM.dd. HH:mm" value="${contentView.vDate}"/>&nbsp;조회 &nbsp;${contentView.vHit}</label>
									</td>
								</tr>
								
								<tr>
									<td style = "border-bottom:none;">
										<textarea class = "autosize" id = "vContent" name = "vContent" readOnly>${contentView.vContent}</textarea>
									</td>
								</tr>
								<tr>
									<td align = "right" style = "border-top:none; border-bottom-left-radius:10px; border-bottom-right-radius:10px;">
										<c:if test="${pageContext.request.userPrincipal.name eq contentView.vId}">
											<a href = "/virtualHomePage/virtualBulletinBoard/contentView/modify?vNo=${contentView.vNo}"><button class = "contentViewbutton">수정</button></a>
											&nbsp;<a href = "/bbsDelete?vNo=${contentView.vNo}&vId=${pageContext.request.userPrincipal.name}"><button class = "contentViewbutton" id = "bbsDeleteCheck">삭제</button></a>
										</c:if>
										<c:if test="${pageContext.request.userPrincipal.name ne contentView.vId}">
											<c:forEach begin = "1" end = "10">
												&nbsp;
											</c:forEach>
										</c:if>
											&nbsp;<a href = "/virtualHomePage/virtualBulletinBoard"><button class = "contentViewbutton">게시판 보기</button></a>
										<c:if test = "${empty pageContext.request.userPrincipal}">
											&nbsp;<a href = "/virtualHomePage/virtualBulletinBoard/contentView/reply?vNo=${contentView.vNo}"><button class = "contentViewbutton" id = "logincheck" onClick = "locheck()" >답변</button></a>
										</c:if>
										<c:if test="${not empty pageContext.request.userPrincipal}">
											&nbsp;<a href = "/virtualHomePage/virtualBulletinBoard/contentView/reply?vNo=${contentView.vNo}"><button class = "contentViewbutton" >답변</button></a>
										</c:if>
									</td>
								</tr>
							</table>
							<br/>
							<br/>
							<div id = "Comment" class = "commentDivStyle">
								<c:if test="${not empty pageContext.request.userPrincipal}">
									<c:if test="${NickName ne null }">
										<c:if test="${totalList ne 0}">
											<div id = "CommentList" class = "commentListDivStyle"></div>
										</c:if>
										<br/>
										<div class = "commentListTextAreaDivStyle" align = "center">
											<div align = "left">
												&nbsp;&nbsp;&nbsp;<c:out value = "${NickName}"/>
											</div>
											<form:form commandName = "VVO" method = "POST" id = "form" name = "form" onsubmit="return false;">
												<input type = "hidden" name = "vId" id = "vId" value = "${pageContext.request.userPrincipal.name}" />
												<input type = "hidden" name = "vNo" id = "vNo" value = "${Number}"/>
												<input type = "hidden" name = "vNickName" id = "vNickName" value = "${NickName}" />
												<textarea name = "vCommentContent" class = "autosizeComment" id = "vCommentContentWrite" onKeyUp="checkByte(this.form);" onFocus="clearMessage(this.form);" placeholder = "댓글을 입력해 보세요."></textarea>
											</form:form>
											<div align = "right" >
												<button type = "button" id = "CommentWrite" class= "CommentWritebutton">댓글 등록</button>&nbsp;
											</div>
										</div>
									</c:if>
								</c:if>
							</div>
						</div>
					</header>
				</div>
			</section>
		</div>
	</div>
	
	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.scrolly.min.js"></script>
	<script src="/resources/assets/js/jquery.scrollex.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
	<script src='<c:url value="/resources/js/textareaSize.js"/>'></script>
	<script src='<c:url value="/resources/js/loginCheck.js"/>'></script>
	<script src='<c:url value="/resources/js/bbsDelete.js"/>'></script>
	<script src='<c:url value="/resources/js/Comment/Comment.js"/>'></script>
	<script src='<c:url value="/resources/js/Comment/CommentWriteByteCheck.js"/>'></script>
</body>
</html>