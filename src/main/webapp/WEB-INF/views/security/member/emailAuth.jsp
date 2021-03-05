<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src='<c:url value="/resources/js/KeyDown.js"/>'></script>
<script>
	function check(){
		var form = document.authenform;
		var authNum = ${authNum};
		if(!form.authnum.value){
			alert("인증번호를 입력해 주세요.");
			$('#authnum').focus();
			return false;
		}
		if(form.authnum.value != authNum){
			alert("인증번호가 일치하지 않습니다. 인증번호를 다시 입력해 주세요.");
			form.authnum.value = "";
			$('#authnum').focus();
			return false;
		}
		if(form.authnum.value == authNum){
			alert("인증이 완료되었습니다.");
			opener.document.getElementById('checkRe').value = "인증완료";
			self.close();
			return;
		}
	}
</script>
<meta charset="UTF-8">
<title>이메일 인증</title>
</head>
<body>
	<div align = "center">
		<br/><br/>
		<div align = "center" class = "emailAuthDivStyle"><br/><br/><br/>
			<form method = "post" name = "authenform" onSubmit = "return check();">
				<label class = "EmailAuthLabel"> 인증번호 7자리를 입력해 주세요. </label><br/><br/><br/>
				<input type = "text" name ="authnum" style = "font-size:15px; padding:5px;"/><br/><br/><br/>
				<button type = "button" onClick = "check()" class = "EmailAuthCheckbutton"> 인증하기 </button> <br/><br/>
			</form>	
		</div>
	</div>
</body>
</html>