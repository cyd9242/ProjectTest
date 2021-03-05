/**
 * 
 */

	function checkResult(){
		if ($('#vName').val().trim() == "") {
			alert("이름을 입력해 주세요.");
			$('#vName').focus();
			return false;
		}
		else if($('#vName').val().length < 2){
			alert("이름은 두글자 부터 가능합니다.");
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
		else if($('#vTel1').val() == "번호"){
			alert("번호를 체크해 주세요.");
			$('#vTel1').focus();
			return false;
		}
		else if($('#vTel2').val().trim() == ""){
			alert("중간번호를 입력 해주세요.");
			$('#vTel2').focus();
			return false;
		}
		else if($('#vTel2').val().length < 3){
			alert("중간번호를 입력해 주세요.");
			$('#vTel2').focus();
			return false;
		}
		else if($('#vTel3').val().trim() == ""){
			alert("마지막번호를 입력해 주세요.");
			$('#vTel3').focus();
			return false;
		}
		else if($('#vTel3').val().length != 4){
			alert("마지막번호를 입력해 주세요.");
			$('#vTel3').focus();
			return false;
		}
	}