/**
 * 
 */

	function check(){
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if($('#vEmail').val().trim() == ""){
			alert("이메일을 입력해 주세요.");
			$('#vEmail').focus();
			return false;
		}
		if(exptext.test($('#vEmail').val()) == false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
			alert("이메일형식이 올바르지 않습니다.");
			$('#vEmail').focus();
			return false;
		}
		if($('#checkRe').val().trim() == ""){
			alert("이메일 인증을 받아주세요.");
			$('#vEmail').focus();
			return false;
		}
		else{
			opener.document.getElementById('vEmail').value = $('#vEmail').val();
			self.close();
			return true;			
		}
		
	}