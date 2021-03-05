/**
 * 로그인 체크
 */

	function checkResult(){
		if($('#j_username').val().trim() == ""){
			alert("아이디를 입력해주세요.");
			$('#j_username').focus();
			return false;
		}
		else if($('#j_password').val().trim() == ""){
			alert("비밀번호를 입력해주세요.");
			$('#j_password').focus();
			return false;
		}
	}
	
	function locheck(){
		alert("작성권한이 없습니다.\n로그인을 하고 이용해 주세요.");
	}
	
	function memberCheck(){
		alert("\t가상 홈페이지 회원만 이용 가능합니다. \n\t로그인을 하고 이용해 주세요 \n\t회원이 아니시라면 회원가입 후 이용해 주시기 바랍니다.");
	}
	
	$(document).ready(function(){
		$('#j_username').focus();
	});