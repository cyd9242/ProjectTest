/**
 * 비밀번호 확인 체크
 */

	$(function(){
		$('#vPwd').keyup(function(){
			$('font[name=check]').text('');
		}); //#user_pass.keyup

		$('#vPwdRe').keyup(function(){
			if($('#vPwd').val()!=$('#vPwdRe').val()){
				$('font[name=check]').text('');
				$('font[name=check]').html("비밀번호가 일치하지 않습니다.");
			}
			else if($('#vPwd').val()==$('#vPwdRe').val()){
				$('font[name=check]').text('');
				$('font[name=check]').html("비밀번호가 일치합니다.");
			}    
		}); //#chpass.keyup
	});