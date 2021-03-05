<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.spring.virtualDAO.VDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String NickName = (String)request.getParameter("vNickName");
	String vNickName = java.net.URLDecoder.decode( NickName , "UTF-8" );

	VDAO dao = new VDAO();
	boolean NickCheck = dao.checkNickName(vNickName);
%>
<html>
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NickNmaeCheck</title>
</head>
<body>
	<br/>
	<div align = "center" class = "idCheckDivStile">
		<br/><br/>
		<b style = "color:red;"><%=vNickName%></b>
		<%
			if(NickCheck){
				out.println("는(은) 이미 존재하는 닉네임 입니다.<p>");
		%>
				<br/>
				<script type="text/javascript">
				opener.document.getElementById('NickNameChk').value = "No";
				</script>
		<%		
			}
			else if (!NickCheck){
				out.println("는(은) 사용가능한 닉네임 입니다.<p>");
		%>
				<br/>
				<script type="text/javascript">
				opener.document.getElementById('NickNameChk').value = "Yes";
				</script>
		<%
			}
		%>
		<a href = "#" onclick = "self.close()"><button class = "NickNameCheckResultbutton">닫기</button></a>			
	</div>
</body>
</html>