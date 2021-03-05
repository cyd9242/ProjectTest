/**
 * 
 */
	
	function NickNameCheck(vNickName){
		if(vNickName.trim()==""){
			alert("닉네임을 입력해 주세요.");
			$('#vNickName').focus();
		}
		else if(vNickName.length < 2 || vNickName.length > 10){
			alert("닉네임은 4~10자로 입력해야 합니다.");
			$('#vNickName').focus();
		}
		else if(vNickName){
			var url = "/NickNameCheck?vNickName=" + encodeURI(encodeURIComponent(vNickName));
			window.open(url,"NickNameCheck","width=450, height=200");
		}
	}