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
		else if($('#vPwd').val().trim() == ""){
			alert("비밀번호를 입력해 주세요.");
			$('#vPwd').focus();
			return false;
		}
		else if($('#vPwd').val().length < 6){
			alert("비밀번호는 6~20자로 입력해야 합니다.");
			$('#vPwd').focus();
			return false;
		}
		else if($('#vPwd').val().length > 20){
			alert("비밀번호는 6~20자로 입력해야 합니다.");
			$('#vPwd').focus();
			return false;
		}		
		else if($('#vPwd').val()!=$('#vPwdRe').val()){
			alert("비밀번호가 일치하지 않습니다.");
			$('#vPwdRe').focus();
			return false;
		}
		else if($('#vEmail').val().trim() == ""){
			alert("이메일을  입력해 주세요.");
			$('#vEmail').focus();
			return false;
		}
		else if(exptext.test($('#vEmail').val()) == false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
			alert("이메일형식이 올바르지 않습니다.");
			$('#vEmail').focus();
			return false;
		}
		else if($('#vTel1').val().trim() == ""){
			alert("번호를 입력해 주세요.");
			$('#vTel1').focus();
			return false;
		}
		else if($('#vTel1').val().length < 3){
			alert("번호를 입력해 주세요.");
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
			alert("마지막번호를 입력해 주세요.");
			$('#vTel3').focus();
			return false;
		}
		else if($('#vTel3').val().length != 4){
			alert("마지막번호를 입력해 주세요.");
			$('#vTel3').focus();
			return false;
		}
		else if($('#vPostCode').val().trim() == ""){
			alert("우편번호를 검색해 주세요.");
			$('#vPostCode').focus();
			return false;
		}
		else if($('#vAddress2').val().trim() == ""){
			alert("상세주소를 입력해 주세요.");
			$('#vPostCode').focus();
			return false;
		}
		else{
			alert("회원정보가 정상적으로 수정되었습니다.")
			return true;
		}
	}