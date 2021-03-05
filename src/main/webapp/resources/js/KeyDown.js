/**
 * 엔터 사용 불가
 */

	$(function(){
		$("input:text").keydown(function(event){
			if (event.keyCode == 13){
				return false; 			
			} 
			if (event.keyCode == 32){
				return false;
			}
		}); 
	});
	
	$( function(){	
		$( 'input:text' ).on("blur keyup", function() {
			$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
		});
	});