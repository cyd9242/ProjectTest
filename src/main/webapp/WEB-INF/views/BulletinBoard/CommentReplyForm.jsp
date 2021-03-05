<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src='<c:url value="/resources/js/Comment/CommentReply.js"/>'></script>
<script src='<c:url value="/resources/js/Comment/CommentReplyByteCheck.js"/>'></script>
<meta charset="UTF-8">
<title>댓글 대댓글</title>
</head>
<body>
	<form method = "post" name = "form">
		<div align = "left">
			<label class = "CommentReplyLabel"><c:out value="${NickName}"></c:out></label>
		</div>
		<div class = "CommentReplyDivStyle">
			<input type = "hidden" name = "vNo" value = "${CommentReplyForm.vNo}"/>
			<input type = "hidden" name = "vId" value = "${pageContext.request.userPrincipal.name}"/>
			<input type = "hidden" name = "vCommentGroup" id = "vCommentGroup" value = "${CommentReplyForm.vCommentGroup}"/>
			<input type = "hidden" name = "vCommentStep" id = "vCommentStep" value = "${CommentReplyForm.vCommentStep}"/>
			<input type = "hidden" name = "vCommentIndent" id = "vCommentIndent" value = "${CommentReplyForm.vCommentIndent}"/>
			<input type = "hidden" name = vNickName value = "${NickName}">
			<textarea class = "bbsCommentReplyTextArea" id = "vCommentContentReply" name = "vCommentContent" placeholder = "댓글을 입력해 보세요." onKeyUp="checkByte(this.form);" onFocus="clearMessage(this.form);"></textarea>
		</div>
	</form>
				<a href = "javascript:CommentReplyInput()"><button type = "button" class = "CommentReplyButton">등록</button></a>
				&nbsp;<a href="javascript:CommentReplyModalClose()"><button type ="button" class = "CommentReplyButton">취소</button></a>
</body>
</html>