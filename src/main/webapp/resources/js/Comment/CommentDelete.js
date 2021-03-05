/**
 * 
 */
	
	function CommentDelete(vCommentNo){
		if (confirm("정말 삭제하시겠습니까??") == true){    //확인
			
			$.ajax({
				async : false,
				cache: false,
				type: "post",
				url :"/CommentDelete",
				data:{
					vNo:$("#vNo").val(),
					vCommentNo:vCommentNo,
					vId:$("#vId").val()
				},
				success: function(data){
					
				},
				complete:function(result){
					location.reload();
					alert("댓글이 삭제되었습니다.");
				}
			});
		}		
	}
	