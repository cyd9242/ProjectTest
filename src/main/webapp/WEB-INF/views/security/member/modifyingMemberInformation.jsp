<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<title>회원정보 수정</title>
</head>
<body class="is-preload" name = "top">
	
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header -->
			<!-- Note: The "styleN" class below should match that of the banner element. -->
			<header id="header" class="alt style2">
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
						<h1 style = "color:white;">회원정보 수정</h1>
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
						<div align = "center" class = "modifyingMemberInformationDivStyle">
							<br/><br/>
							<table border = "1" cellpadding = "7" cellspacing = "0" class = "ModifyingMemberInformationTableStyle">
								<form:form action = "/modifyingMemberInformationOK" commandName="VVO" method = "post" onsubmit="return checkResult()">
								<c:forEach var = "list" varStatus = "vs" items = "${vMemberInformation}" begin = "0" end = "${vMemberInformation.size()}" step = "1">
									<tbody>
										<tr>
											<th>아이디</th>
											<td align = "center">
												<form:input path = "vId" id = "vId" value = "${list.vId}" readOnly = "readOnly" style = "position:relative; left:11px; border:none; width:65%; background: none; font-size:15px; cursor: none; pointer-events: none;"/>
											</td>
											<th>이름</th>
											<td>
												<form:input path = "vName" id = "vName" value = "${list.vName}" style = "position:relative; left:11px; border:none; width:65%; background: none; font-size:15px;"/>
											</td>
										</tr>					
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
										
										 <tr>
											<th style = "border-bottom-left-radius:0px;">비밀번호</th>
											<td colspan = "3">
												<form:password path = "vPwd" id = "vPwd" placeholder = " 비밀번호" maxlength = "20" style = "position:relative; left:15px; border:none; background:transparent; width:85%; padding:7px;"/>
											</td>
										</tr>
										<tr>
											<th style = "border-top-left-radius:0px;">비밀번호 확인</th>
											<td colspan = "3">
												<form:password path = "vPwdRe" id = "vPwdRe" placeholder = " 비밀번호 확인" maxlength = "20" style = "position:relative; left:15px; border:none; background:transparent; width:85%; padding:7px;"/>
											</td>
										</tr>
										<tr>
											<th style = "background: none;"></th>
											<td colspan = "3" align = "right">
												<font name="check" size="2" color="red"></font><br/><br/>
											</td>
										</tr>
										
										<tr>
											<th style = "width : 100px;">성별</th>
											<td align = "center">
												<label class = "ModifyingMemberInformationLabel" style = "font-weight:400; width:80%;"><c:out value = "${list.vGender}"/></label>
											</td>
											<th>생년월일</th>
											<td align = "center">
												<label class = "ModifyingMemberInformationLabel" style = "font-weight:400; width:80%;"><c:out value = "${list.vBirth1}"/></label>
											</td>
										</tr>
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
										
										<tr>
											<th>이메일</th>
											<td colspan = "2">
												<form:input path = "vEmail" id = "vEmail" value = "${list.vEmail}" readOnly = "readOnly" style = "position: relative; left: 11px; border: none; width: 65%; background: none; font-size: 15px; cursor: none; pointer-events: none;"/>
											</td>
											<td>
												<button type = "button" onClick = "modifyingEmail()" class = "memberEmailbutton">수정하기</button>
											</td>
										</tr>
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
										
										<tr>
											<th>전화번호</th>
											<td align = "center">
												<form:input path = "vTel1" id = "vTel1" maxlength = "3" value = "${fn:split(list.vTel1,'-')[0]}"  style = "border:none; width:45%; background:none; font-size:15px;"/><label class = "ModifyingMemberInformationLabel">-</label>
											</td>
											<td align = "center">
												<form:input path = "vTel2" id = "vTel2" maxlength = "4" value = "${fn:split(list.vTel1,'-')[1]}"  style = "border:none; width:65%; background:none; font-size:15px;"/><label class = "ModifyingMemberInformationLabel">-</label>
											</td>
											<td align = "center">
												<form:input path = "vTel3" id = "vTel3" maxlength = "4" value = "${fn:split(list.vTel1,'-')[2]}"  style = "border:none; width:65%; background:none; font-size:15px;"/>
											</td>
										</tr>
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
										
										<tr>
											<th>주소</th>
											<td colspan = "2">
												<form:input path = "vPostCode" id = "vPostCode" value = "${list.vPostCode}" readOnly= "readOnly" style = "border:none; background: none; width:100%; cursor: none; pointer-events: none;"/>
											</td>
											<td>
												<button type = "button" onClick = "execPostCode()" class = "ModifyingPostCodebutton">우편번호<br/>검색</button>
											</td>
										</tr>
										<tr>
											<th style = "background: none;"></th>
											<td colspan = "3">
												<form:input path = "vAddress1" id = "vAddress1" value = "${list.vAddress1}"  readOnly= "readOnly" style = "border:none; background:transparent; width:100%; cursor: none; pointer-events: none;"/>
											</td>
										</tr>
										<tr>
											<th style = "background: none;"></th>
											<td colspan = "3">
												<form:input path = "vAddress2" id = "vAddress2" value = "${list.vAddress2}" style = "border:none; background:transparent; width:100%;"/>
											</td>
										</tr>
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
										
										<tr>
											<td colspan = "4" align = "center">
												<input type = "submit" value = "회원정보 수정하기" class = "ModifyingMemberInformationbutton" />
											</td>
										</tr>
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
									</tbody>
								</c:forEach>
								</form:form>
							</table>
						</div>
					</header>
				</div>
			</section>
		</div>
	</div>
	<button id = "top" class = "Topbutton" hidden =""><img src = "/resources/image/top.png" class = "topImageStyle"/></button>
	<!-- Scripts -->
			<script src="/resources/assets/js/jquery.min.js"></script>
			<script src="/resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="/resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="/resources/assets/js/browser.min.js"></script>
			<script src="/resources/assets/js/breakpoints.min.js"></script>
			<script src="/resources/assets/js/util.js"></script>
			<script src="/resources/assets/js/main.js"></script>
			<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
			<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
			<script src='<c:url value="/resources/js/PostCode.js"/>'></script>
			<script src='<c:url value="/resources/js/pwdCheck.js"/>'></script>
			<script src='<c:url value="/resources/js/modifyTelFocus.js"/>'></script>
			<script src='<c:url value="/resources/js/modifyMemberEmail.js"/>'></script>
			<script src='<c:url value="/resources/js/modifyCheck.js"/>'></script>
			<script src='<c:url value="/resources/js/hiddenTop.js"/>'></script>
</body>
</html>