/**
 * 
 */

	function checkResult(){
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if($('#vName').val().trim() == ""){
			alert("이름을 입력해 주세요.")
			$('#vName').focus();
			return false;
		}
		else if($('#vName').val().length < 2){
			alert('이름은 두글자 부터 가능합니다.');
			$('#vName').focus();
			return false;
		}
		else if($('#vBirth1').val() == "년도"){
			alert("년도를 체크해 주세요.");
			$('#vBirth1').focus();
			return false;
		}
		else if($('#vBirth2').val() == "월"){
			alert("월을 체크해 주세요.");
			$('#vBirth2').focus();
			return false;
		}
		else if($('#vBirth3').val() == "일"){
			alert("일을 체크해 주세요.");
			$('#vBirth3').focus();
			return false;
		}
		else if($('#checkRe').val().trim() == ""){
			alert("이메일 인증을 받아주세요.");
			$('#vEmail').focus();
			return false;
		}
		else if ($('#vEmail').val().trim() == ""){
			alert("이메일을 입력해 주세요.");
			$('#vEmail').focus();
			return false;
		}
		else if(exptext.test($('#vEmail').val()) == false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
			alert("이메일형식이 올바르지 않습니다.");
			$('#vEmail').focus();
			return false;
		}
	}