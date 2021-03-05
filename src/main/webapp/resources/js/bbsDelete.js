/**
 * 
 */


	$("#bbsDeleteCheck").click(function(){	
		if (confirm("정말 삭제하시겠습니까??") == true){    //확인
			alert("게시글이 삭제됐습니다.");
		}
		else{   //취소
			return false;
		}
	});
	
	
			
