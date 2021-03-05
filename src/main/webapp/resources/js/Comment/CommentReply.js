/**
 * 
 */

	function CommentReply(vCommentNo){
		$("#CommentReply").show();
		$.ajax({
			async : false,
			cache: false,
			type: "get",
			url :"/CommentReplyForm?vCommentNo="+vCommentNo,
			success: function(result){
				var output = "<br/>"+ result;						
				$("#CommentReply").html(output);
			}
		});
	}
	
	function CommentReplyModalClose(){
			$("#CommentReply").hide();
	}
	
	function CommentReplyInput(){
		$.ajax({
			async : false,
			cache: false,
			type: "post",
			url : "/CommentReply",
			data:{
				vNo:$("#vNo").val(),
				vId:$("#vId").val(),
				vNickName:$("#vNickName").val(),
				vCommentContent:$("#vCommentContentReply").val(),
				vCommentGroup:$("#vCommentGroup").val(),
				vCommentStep:$("#vCommentStep").val(),
				vCommentIndent:$("#vCommentIndent").val()
			},
			success:function(data) {
				
			},
			complete:function(result){
				$("#CommentReply").hide();
				location.reload();
			}
		});
	}