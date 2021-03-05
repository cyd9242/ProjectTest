<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/modal.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<head>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>
<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
<script src='<c:url value="/resources/js/textareaSize.js"/>'></script>
<script src='<c:url value="/resources/js/Comment/Comment.js"/>'></script>
<script src='<c:url value="/resources/js/Comment/CommentModify.js"/>'></script>
<script src='<c:url value="/resources/js/Comment/CommentDelete.js"/>'></script>
<script src='<c:url value="/resources/js/Comment/CommentReply.js"/>'></script>
<meta charset="UTF-8">
<title>댓글</title>
</head>
<body>
	<c:if test = "${not empty CommentList}">
		
		<table border = "1" cellpadding="0" cellspacing = "0" class = "CommentList">
			<thead>
				<tr>
					<td colspan = "3" align = "left">&nbsp;댓글 (<c:out value = "${totalList}" />) </td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "var" items = "${CommentList}"  varStatus= "i"> 
					<tr>
					<td>
						<div class = "commentListTextDivStyle">
						<c:forEach begin = "1" end = "${var.vCommentIndent}">└</c:forEach>
							<c:if test="${Writer eq var.vId}">
								<label> ${var.vNickName}</label>&nbsp;<label style = "border: 1px solid red; border-radius:10px; padding:2px; color:red;">작성자</label><br/>
							</c:if>
							<c:if test="${Writer ne var.vId}">
								<label> ${var.vNickName}</label>
							</c:if>
							&nbsp;&nbsp;<textarea class = "autosizeCommentList" id = "vCommentContentList" name = "vCommentContent" readOnly>${var.vCommentContent}</textarea><br/>
							<c:if test="${var.vUpdateDate eq null}">
								<label><fmt:formatDate pattern="yyyy.MM.dd. HH:mm" value="${var.vCommentDate}"/></label><br/>
							</c:if>							
							<c:if test="${var.vUpdateDate ne null}">
								<label><fmt:formatDate pattern="yyyy.MM.dd. HH:mm" value="${var.vCommentDate}"/></label>
								&nbsp;&nbsp;<label> 수정 날짜 : <fmt:formatDate pattern="yyyy.MM.dd. HH:mm" value="${var.vUpdateDate}"/></label>
							</c:if>
							<c:if test="${not empty pageContext.request.userPrincipal}">
								<c:if test="${pageContext.request.userPrincipal.name eq var.vId}">
									<div align = "right">
										<a href = "javascript:CommentModify('${var.vCommentNo}')"><button type = "button" class = "CommentContentButton">댓글 수정</button></a>
										<a href = "javascript:CommentReply('${var.vCommentNo}')"><button type = "button" class = "CommentContentButton">댓글 답글</button></a>
										<a href = "javascript:CommentDelete('${var.vCommentNo}')"><button type = "button" class = "CommentContentButton">댓글 삭제</button></a>
									</div>
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name ne var.vId}">
									<div align = "right">
										<a href = "javascript:CommentReply('${var.vCommentNo}')"><button type = "button" class = "CommentContentButton">댓글 답글</button></a>
									</div>
								</c:if>
							</c:if>
						</div>
					</td>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<div id = "CommentModify" class = "ModifyModal"></div>
	<div id = "CommentReply" class = "ReplyModal"></div>
</body>
</html>