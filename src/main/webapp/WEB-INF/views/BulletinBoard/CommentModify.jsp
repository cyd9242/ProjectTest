<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/modal.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/textarea.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<head>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src='<c:url value="/resources/js/Comment/Comment.js"/>'></script>
<script src='<c:url value="/resources/js/Comment/CommentModify.js"/>'></script>
<script src='<c:url value="/resources/js/Comment/CommentModifyByteCheck.js"/>'></script>
<meta charset="UTF-8">
<title>댓글 수정</title>
</head>
<body>
	<c:if test="${not empty bbsCommentList}">
		<form method = "post" name = "form">
			<div class = "CommentModifyDivStyle">
				<c:forEach var = "var" items = "${bbsCommentList}">
					<input type = "hidden" id = "vCommentNo" name = "vCommentNo" value = "${var.vCommentNo}">
					<input type = "hidden" id = "vId" name = "vId" value = "${var.vId}">
					<input type = "hidden" id = "vNickName" name = "vNickName" value = "${var.vNickName}">
					<input type = "hidden" id = "vNo" name = "vNo" value = "${var.vNo}">				
					<textarea class = "bbsCommentModifyTextArea" id = "vCommentContentModify" name = "vCommentContent" onKeyUp="checkByte(this.form);" onFocus="clearMessage(this.form);">${var.vCommentContent}</textarea>
				</c:forEach>
			</div>
		</form>
				<a href = "javascript:CommentUpdate()"><button type = "button" class = "CommentModifyButton">수정</button></a>
				&nbsp;<a href="javascript:CommentUpdateModalClose()"><button type ="button" class = "CommentModifyButton">취소</button></a>

	</c:if>
</body>
</html>