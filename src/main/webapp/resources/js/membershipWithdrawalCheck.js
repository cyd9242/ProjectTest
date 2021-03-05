/**
 * 
 */

	function checkResult(){
		if($('#vPwdRe').val().trim() == ""){
			alert("비밀번호 확인을 입력해 주세요.");
			$('#vPwdRe').focus();
			return false;
		}
		else if($('#vPwd').val()!=$('#vPwdRe').val()){
			alert("비밀번호가 일치하지 않습니다.");
			$('#vPwdRe').focus();
			return false;
		}
		else{
			if (confirm("정말 삭제하시겠습니까??") == true){    //확인
				alert("회원탈퇴를 성공하셨습니다.");
				self.close();
				window.opener.location.href="${pageContext.request.contextPath}/j_spring_security_logout";
			}
			else{   //취소
				alert("회원탈퇴를 취소하셨습니다.");
				return false;
			}
		}
			
	}