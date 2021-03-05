<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/imageStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
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
		<title>게시글 : <c:out value="${title}"/> - 수정</title>
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
							<h1 style = "color:white;">게시글 : <c:out value="${title}"/> - 수정</h1>
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
						<div class = "bbsModifyDivStyle">
							<table cellpadding = "7" cellspacing = "0" border = "1" class = "modifyTableStyle">
								<form:form commandName = "VVO" action = "/bbsModifyOk" method = "post" name = "form" onsubmit="return checkResult()">
									<input type = "hidden" name = "vNo" value = "${Modify.vNo}"/>
									<input type = "hidden" name = "vId" value = "${pageContext.request.userPrincipal.name}"/>
									<thead>
										<tr>
											<td colspan = "2" align = "left">
												&nbsp;&nbsp;&nbsp;&nbsp;
												<label class = "bbsModifyNickNameLabel">작성자 : </label>
												<form:input path="vNickName" value = "${NickName}" readOnly = "readOnly" style = "width:auto; border:none; background:none; text-align:left; font-size:20px; font-weigth:bold; font-family:sans-serif; cursor: none; pointer-events: none;" />
											</td>
										</tr>
									</thead>
									<tbody>
										
										<tr>
											<th align = "center">제목</th>
											<td align = "left">
												&nbsp;<form:input path="vSubject" value = "${Modify.vSubject}" style = "border:none; text-align:left; background:none; width:99%;"/>
												
											</td>
										</tr>
										
										<tr>
											<th align = "center" style = "border-bottom-left-radius: 10px;">내용</th>
											<td align = "right" style = "border-bottom-right-radius: 10px;">
												<textarea name = "vContent" class = "autosizeModify" id = "vContent" onKeyUp="checkByte(this.form);" onFocus="clearMessage(this.form);" style = "width:100%;" >${Modify.vContent}</textarea>
												<input type="text" id = "ByteCheck1" name="messagebyte" value="0" size="1" maxlength="2" style = "border:none; background:none;" readonly>
							    				<font name = "ByteCheck2" color="#000000" >/ 3000 byte</font> &nbsp;<br/><br/>
												<input type = "submit" value = "수정하기" class = "bbsModifybutton"/>
												&nbsp;<a href = "/virtualHomePage/virtualBulletinBoard/contentView?vNo=${Modify.vNo}"><button type = "button" class = "bbsModifybutton">취소</button></a>&nbsp;&nbsp;
											</td>
										</tr>
									</tbody>
								</form:form>
							</table>
							<br/>
						</div>
					</header>
				</div>
			</section>
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
		<script src='<c:url value="/resources/js/ByteCheck.js"/>'></script>
		<script src='<c:url value="/resources/js/writeCheck.js"/>'></script>
</body>
</html>
