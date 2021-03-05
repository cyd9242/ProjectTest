/**
 * 
 */

	function checkResult(){
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if($('#vId').val().trim() == ""){
			alert("아이디를 입력해 주세요.");
			$('#vId').focus();
			return false;
		}
		else if($('#vId').val().length < 4 || $('#vId').val().length > 10){
			alert("아이디는 4~10자로 입력해야 합니다.");
			$('#vId').focus();
			return false;
		}
		else if($('#vNmae').val().trim() == ""){
			alert("이름을 입력해 주세요.");
			$('#vName').focus();
			return false;
		}
		else if($('#vName').val().length < 2){
			alert('이름은 두글자 부터 가능합니다.');
			$('#vName').focus();
			return false;
		}
		else if($('#vEmail').val().trim() == ""){
			alert("이메일을  입력해 주세요");
			$('#vEmail').focus();
			return false;
		}
		else if(exptext.test($('#vEmail').val()) == false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
			alert("이메일형식이 올바르지 않습니다.");
			$('#vEmail').focus();
			return false;
		}
		else if($('#checkRe').val().trim() == ""){
			alert("이메일 인증을 받아주세요.");
			$('#vEmail').focus();
			return false;
		}
	}