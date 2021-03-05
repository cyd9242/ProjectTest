/**
 * 
 */

	function emailCheck(vEmail){
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if($('#vEmail').val().trim() == ""){
			alert("이메일을 입력해 주세요.");
			$('#vEmail').focus();
			return false;
		}
		else if(exptext.test(vEmail) == false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
			alert("이메일형식이 올바르지 않습니다.");
			$('#vEmail').focus();
			return false;
		}
		else{
			url = "/emailAuth_ModifyingMemberInformation?vEmail="+vEmail;
			alert("인증번호를 발송했습니다. \n인증번호가 오지 않으면 입력하신 정보가 회원정보와 일치하는지 확인해 주세요.");
			window.open(url,"emailAuth","width=500, height=350");
		}
	}