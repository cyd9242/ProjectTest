/**
 * 
 */

	function checkResult(){
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
		else if($('#vName').val().trim() == ""){
			alert("이름을 입력해 주세요.");
			$('#vName').focus();
			return false;
		}
		else if($('#vName').val().length < 2){
			alert('이름은 두글자 부터 가능합니다.');
			$('#vName').focus();
			return false;
		}
		else if($('#vTel1').val() == "번호"){
			alert("번호를 체크해 주세요.");
			$('#vTel1').focus();
			return false;
		}
		else if($('#vTel2').val().trim() == ""){
			alert("중간번호를 입력해 주세요.");
			$('#vTel2').focus();
			return false;
		}
		else if($('#vTel2').val().length < 3){
			alert("중간번호를 입력해 주세요.");
			$('#vTel2').focus();
			return false;
		}
		else if($('#vTel3').val().trim() == ""){
			alert("마지막번 호를 입력해 주세요.");
			$('#vTel3').focus();
			return false;
		}
		else if($('#vTel3').val().length != 4){
			alert("마지막번호를 입력해 주세요.");
			$('#vTel3').focus();
			return false;
		}
	}
	