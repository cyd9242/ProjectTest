/**
 * 아이디 중복 / 유효 검사
 */

	function idCheck(vId){
		if(vId.trim()==""){
			alert("아이디를 입력해 주세요.");
			$('#vId').focus();
		}
		else if(vId.length < 4 || vId.length > 10){
			alert("아이디는 4~10자로 입력해야 합니다.");
			$('#vId').focus();
		}
		else if(vId){
			var url = "/idCheck?vId=" + vId;
			window.open(url,"idCheck","width=430, height=200");
		}
	}