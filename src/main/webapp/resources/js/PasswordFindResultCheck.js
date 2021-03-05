/**
 * 
 */

	function checkResult(){
		if($('#vPwd').val().trim() == ""){
			alert("비밀번호를 입력해 주세요.");
			return false;
		}
		else if($('#vPwdRe').val().trim() == ""){
			alert("비밀번호 확인을 입력해 주세요.");
			return false;
		}
		else if($('#vPwd').val().length < 6 || $('#vPwd').val().length > 20){
			alert("비밀번호는 6~20자로 입력해야 합니다.");
			$('#vPwd').focus();
			return false;
		}
		else if($('#vPwd').val()!=$('#vPwdRe').val()){
			$('#vPwdRe').focus();
			alert("비밀번호가 일치하지 않습니다.");
			return false;	
		}
		else{
			alert("비밀번호를 정상적으로 변경하였습니다.\n변경된 비밀번호로 로그인해 주세요.")
			return true;
		}
	}