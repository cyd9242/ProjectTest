/**
 * 전화번호 포커스 
 */

	$(function(){
		$('#vTel1').keyup(function(){
			if($('#vTel1').val().length == 3){
				$('#vTel2').focus();
			}
		});
	});
	
	$(function(){
		$('#vTel2').keyup(function(){
			if($('#vTel2').val().length ==4){
				$('#vTel3').focus();
			}
		});
	});