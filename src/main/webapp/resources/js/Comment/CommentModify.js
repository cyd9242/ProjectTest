/**
 * 
 */

	function CommentModify(vCommentNo){
		$("#CommentModify").show();
		$.ajax({
			async : false,
			cache: false,
			type: "get",
			url :"/CommentModifySelect?vCommentNo="+vCommentNo,
			success: function(result){
				var output = "<br/>"+ result;						
				$("#CommentModify").html(output);
			}
			
		})
		
	}
	
	function CommentUpdateModalClose(){
			$("#CommentModify").hide();
	}
	
	function CommentUpdate(){
		$.ajax({
			async : false,
			cache: false,
			type: "post",
			url : "/CommentModify",
			data:{
				vCommentNo:$("#vCommentNo").val(),
				vCommentContent:$("#vCommentContentModify").val(),
				vId:$("#vId").val()
			},
			success:function(data) {
				
			},
			complete:function(result){
				$("#CommentModify").hide();
				location.reload();
			}
		});
	}
	