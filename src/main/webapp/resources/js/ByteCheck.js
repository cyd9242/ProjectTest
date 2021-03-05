/**
 * 
 */
/**
 * 
 */

	var clearChk=true;
	var limitByte = 3000; //바이트의 최대크기, limitByte 를 초과할 수 없슴

	// textarea에 마우스가 클릭되었을때 초기 메시지를 클리어
	function clearMessage(frm){
		if(clearChk){ 
			frm.messagebox.value="";
			clearChk=false;
		}

	}

	// textarea에 입력된 문자의 바이트 수를 체크
	function checkByte(frm) {
		var totalByte = 0;
		var message = frm.vContent.value;
		for(var i =0; i < message.length; i++) {
			var currentByte = message.charCodeAt(i);
			if(currentByte > 128)	
				totalByte += 2;
			else	
				totalByte++;
		}
		
		frm.messagebyte.value = totalByte;
		
		if(totalByte > limitByte) {
			alert(limitByte+"바이트까지 전송가능합니다.");
			frm.vContent.value = message.substring(0,limitByte);
		}
		
		if(totalByte >= 2950){
			$('#ByteCheck1').css('color', 'red');
			$('font[name=ByteCheck2]').css('color', 'red');
		}
		
		else{
			$('#ByteCheck1').css('color', '#000000');
			$('font[name=ByteCheck2]').css('color', '#000000');
		}
	}