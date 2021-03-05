<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/imageStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/anchorStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/textareaStyle.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/resources/assets/css/main.css" />
<noscript><link href="<c:url value="/resources/assets/css/noscript.css" />" rel="stylesheet"></noscript>
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

<meta charset="UTF-8">
<c:if test="${title ne null}">
<title>게시글 : <c:out value="${title}"></c:out></title>
</c:if>
</head>
<body class="is-preload">
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
		<!-- Note: The "styleN" class below should match that of the header element. -->
		<section id="banner" class="style2">
			<div class="inner">
				<span class="image">
					<img src="/resources/image/pic07.jpg" alt="" />
				</span>
				<header class="major">
					<div align = "center">
						<h1 style = "color:white; font-family:sans-serif;"><c:out value = "${title}"/> : 답글</h1>
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
						<div class = "bbsReplyDivStyle">
							<div align = "center">
								<br/>
								<table class = "replyTableStyle" border = "1" cellpadding = "5" cellspacing = "0" >
									<form:form commandName = "VVO" action = "/bbsReplyOk" method = "post" >
										<input type = "hidden" name = "vNo" value = "${replyForm.vNo}"/>
										<input type = "hidden" name = "vId" value = "${pageContext.request.userPrincipal.name}"/>
										<input type = "hidden" name = "vGroup" value = "${replyForm.vGroup}"/>
										<input type = "hidden" name = "vStep" value = "${replyForm.vStep}"/>
										<input type = "hidden" name = "vIndent" value = "${replyForm.vIndent}"/>
										<thead>
											<tr>
												<td colspan = "2">
													&nbsp;&nbsp;<label class = "bbsReplyNickNameLael">작성자 : </label><form:input path="vNickName" value = "${NickName}" readOnly = "readOnly" style = "width:auto; border:none; background:none; text-align:left; font-size:30px; font-weigth:bold; font-family:sans-serif; cursor: none;	pointer-events: none;" /> <br/>  
													&nbsp;&nbsp;<label class = "bbsReplyLabel">글 번호 : ${replyForm.vNo}</label> &nbsp;
													<label class = "bbsReplyLabel">조회수 : ${replyForm.vHit}</label> 
												</td>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th style = "font-size:18px;">제목</th>
												<td>
													<form:input path = "vSubject" value = "[re]${replyForm.vSubject}" readOnly="readOnly" style = "width:auto; border:none; background:none; text-align:left; font-size:18px; cursor: none;	pointer-events: none;"/>
												</td>
											</tr>
											
											<tr>
												<th style = "border-bottom-left-radius: 10px;">답변내용</th>
												<td align = "right" style = " border-bottom-right-radius: 10px;">
													<form:textarea path = "vContent" class = "autosizeReply" id = "vContent"  onKeyUp="checkByte(this.form);" onFocus="clearMessage(this.form);" style = "width:100%;"/>
													<input type="text" id = "ByteCheck1" name="messagebyte" value="0" size="1" maxlength="2" style = "border:none;" readonly>
								    				<font name = "ByteCheck2" color="#000000" >/ 3000 byte</font> &nbsp;<br/><br/>
													<a href = "/virtualHomePage/virtualBulletinBoard"><button type = "button" class = "bbsReplybutton">게시판 보기</button></a>
													<input type = "submit" value = "답변전송" class = "bbsReplybutton"/>&nbsp;&nbsp;&nbsp;
													<input type = "reset" value = "초기화" class = "bbsReplybutton"/>&nbsp;<br/>
												</td>
											</tr>
										</tbody>
									</form:form>
								</table>
								<br/>
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
	<script src='<c:url value="/resources/js/ByteCheck.js"/>'></script>
	<script src='<c:url value="/resources/js/textareaSize.js"/>'></script>
	
</body>
</html>