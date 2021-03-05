/**
 *	전화번호 포커스 이동 
 */

	$(function(){
		$('#vTel2').keyup(function(){
			if($('#vTel2').val().length ==4){
				$('#vTel3').focus();
			}
		});
	});