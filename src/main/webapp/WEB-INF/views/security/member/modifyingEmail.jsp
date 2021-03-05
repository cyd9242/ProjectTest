<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src='<c:url value="/resources/js/modifyEmail.js"/>'></script>
<script src='<c:url value="/resources/js/modifyEmailCheck.js"/>'></script>
<script src='<c:url value="/resources/js/KeyDown.js"/>'></script>
<meta charset="UTF-8">
<title>이메일 수정</title>
</head>
<body>
	<div align = "center">
		<br/><br/>
		<div align = "center" class = "modifyingEmailDivStyle">
		<br/><br/>
			<form:form commandName="VVO" method = "post" onsubmit="return checkResult()">
				<table>
					<tbody>
						<tr>
							<th class = "modifyingLabe">이메일</th>
							<td>						
								<form:input path = "vEmail" id = "vEmail" placeholder = " Email" maxlength = "30" size = "25" style = "position:relative; left:15px; width:85%;"/>
							</td>
							<td>
								<button type = "button" onClick = "emailCheck(this.form.vEmail.value)" class = "modifyingEmailbutton">인증하기</button> <br/>
							</td>
						</tr>
						<tr>
							<th style = "background:white"></th>
							<td colspan = "2" align = "right">
								<input type = "text" readOnly = "readOnly" id = "checkRe" disabled = "" style = "border:none; width:95%; background:white; color:red; font-size:15px;"><br/><br/>
							</td>
						</tr>
						<tr>
							<th style = "background:white"></th>
							<td colspan = "2" align = "right">
								<button type = "button" onClick = "check()" class = "modifyingEmailbutton">수정하기 </button> <br/><br/>
							</td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>

</body>
</html>