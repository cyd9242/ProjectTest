<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.spring.virtualDAO.VDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String vId = (String)request.getParameter("vId");
	VDAO dao = new VDAO();
	boolean check = dao.checkId(vId);
%>
<html>
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<head>
<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>idCheck</title>
</head>
<body>
	<br/>
	<div align = "center" class = "idCheckDivStile">
		<br/><br/>
		<b style = "color:red;"><%=vId %></b>
		<%
			if(check){
				out.println("는(은) 이미 존재하는 아이디 입니다.<p>");
		%>
				<br/>
				<script type="text/javascript">
				opener.document.getElementById('idchk').value = "No";
				</script>
		<%		
			}
			else if (!check){
				out.println("는(은) 사용가능한 아이디 입니다.<p>");
		%>
				<br/>
				<script type="text/javascript">
				opener.document.getElementById('idchk').value = "Yes";
				</script>
		<%
			}
		%>
		<a href = "#" onclick = "self.close()"><button class = "idCheckResultbutton">닫기</button></a>			
	</div>
</body>
</html>