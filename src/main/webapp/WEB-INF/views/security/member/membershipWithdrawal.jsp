<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src='<c:url value="/resources/js/pwdCheck.js"/>'></script>
<script src='<c:url value="/resources/js/membershipWithdrawalCheck.js"/>'></script>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<br/>
	<div align = "center">
		<c:forEach var = "checkPwd" items = "${pwdResult}" begin = "0" end = "${vMemberInformation.size()}" step = "1">
			<div class = "membershipWithdrawalDivStyle">
				<br/>
				<form:form action = "/MembershipWithdrawalOK" name = "removefrm" commandName="VVO" method = "post" onsubmit="return checkResult()">
					<form:hidden path="vId" value = "${pageContext.request.userPrincipal.name}"/>
					<form:hidden path="vPwd" id = "vPwd" maxlength = "20" value = "${checkPwd}" disabled = "disabled" readOnly = "readOnly" style = "position:relative; left:15px; width:85%;"/>
					<table>
						<tbody>
							<tr>
								<th align = "left">비밀번호 확인</th>
								<td>
									<form:password path="vPwdRe" id = "vPwdRe" maxlength = "20" placeholder = " 비밀번호 확인" style = "position:relative; left:15px; width:85%;"/>								
								</td>
							</tr>
								<th></th>
								<td>
									<font name="check" size="2" color="red"></font><br/>
								</td>
							<tr>
								<th></th>
							</tr>
							<tr>
								<td colspan = "2" align = "center">
									<input type = "submit" value = "회원탈퇴" class = "membershipWithdrawalbutton"/>
								</td>
							</tr>
						</tbody>
					</table>
				</form:form>
			</div>
		</c:forEach>
	</div>

</body>
</html>