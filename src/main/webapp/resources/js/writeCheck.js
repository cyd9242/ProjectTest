/**
 * 
 */
function checkResult(){
	if($('#vSubject').val().trim() == ""){
		alert("제목을 작성해 주세요.");
		$('#vSubject').focus();
		return false;
	}
	if($('#Content').val().trim() == ""){
		alert("내용을 작성해 주세요.");
		$('#Content').focus();
		return false;
	}
}