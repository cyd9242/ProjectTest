/**
 * 
 */
	
	$(function() {
	listComment();
		$("#CommentWrite").click(function() {
			if(checkResult() == true){
				$.ajax({
					async:false,
					cache: false,
					type: "post",
					url:"/CommentWrite",
	                // data:{}에서는 EL을 ""로 감싸야 한다. 이외에는 그냥 사용한다.
					data:{
						vNo:$("#vNo").val(),
						vCommentContent:$("#vCommentContentWrite").val(),
						vId:$("#vId").val(),
						vNickName:$("#vNickName").val()
					},
	                success:function(data) {
						alert("댓글이 등록되었습니다.");
						$("#vCommentContent").val("");
						location.reload();
						CommentList();
	                },
					error:function(xhr){
						$("#CommentList").html("Error Code : " + xhr.status);
					},
					complete:function(result){
						listComment();
					}
	            });
			}
        });	
	
		function listComment(){
			$.ajax({
				type: "get",
				cache: false,
				url : "/CommentList?vNo="+$.urlParam("vNo"),
				success: function(result){
					$("#CommentList").html(result);
				}
			});
		}
			
		function CommentList(){
			$.ajax({
				type: "get",
				url: "/CommentList?vNo="+$.urlParam("vNo"),
				success:function(result){
					console.log(result);
					var output="<table>";
				    for(var i in result){
				        var repl=result[i].vCommentContent;
				        repl = repl.replace(/  /gi,"&nbsp;&nbsp;");//공백처리
				        repl = repl.replace(/</gi,"&lt;"); //태그문자 처리
				        repl = repl.replace(/>/gi,"&gt;");
				        repl = repl.replace(/\n/gi,"<br>"); //줄바꿈 처리
				        
				        output += "<tr><td>"+result[i].vNickName;
				        date = changeDate(result[i].vCommentDate);
				        output += "("+date+")";
				        output += "<br>"+repl+"</td></tr>";
				    }
			        output+="</table>";
					
			        $("#CommentList").html(output);
				}
			});
		}
			
    });
	
	
	
	$.urlParam = function(vNo){
	    var results = new RegExp('[\?&amp;]' + vNo + '=([^&amp;#]*)').exec(window.location.href);
	    return results[1] || 0;
	}
	
	function checkResult(){
			if($("#vCommentContentWrite").val().trim() == ""){
				alert("내용을 입력해 주세요.");
				$('#vCommentContentWrite').focus();
				return false;
			}
			else{
				return true;
			}
		}

		
	$( document ).ready(function(){
		listComment();
	});