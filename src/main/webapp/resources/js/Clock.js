/**
 * 
 */

/*	function showClock(){
		var currentDate = new Date();
		var apm = currentDate.getHours;
		if(apm < 12){
			apm = "am";
		}
		else{
			apm = "pm";
		}
		
		var hour = apm + (currentDate.getHours()-12) + ":";
		var minute = currentDate.getMinutes() + ":";
		var second = currentDate.getSeconds();
		divHour.innerText = hour;
		divMinute.innerText = minute;
		divSecond.innerText = second;
		setTimeout(showClock, 1000);
	}*/
	
	/**
 * 
 */

	function showClock(){
		var currentDate = new Date();
		var apm = currentDate.getHours;
		var hour = (currentDate.getHours()-12);
		var minute = currentDate.getMinutes();
		var second = currentDate.getSeconds();
		
		if(apm < 12){
			apm = "am";
		}
		else{
			apm = "pm";
		}
		
		if(second >= 50){
			$("#divSecond").css("color","red");
		}
		else{
			$("#divSecond").css("color","black");
		}
		
		
		divHour.innerText = ("0" + hour).slice(-2);
		divMinute.innerText = ("0" + minute).slice(-2);
		divSecond.innerText = ("0" + second).slice(-2);
		divApm.innerText = apm;
		setTimeout(showClock, 1000);
	}
	