/**
 * 
 */

//calendar 월 이동
	function movePrevMonth(){
		month--;
		if(month<=0){
			month=12;
			year--;
		}
		if(month<10){
			month=String("0"+month);
		}
		getNewInfo();
	}
    
    function moveNextMonth(){
		month++;
		if(month>12){                                       
			month=1;
			year++;
		}
		if(month<10){
			month=String("0"+month);
		}
		getNewInfo();
	}
    
	function getNewInfo(){
		for(var i=0;i<42;i++){
			$tdDay.eq(i).text("");
		}
		dayCount=0;
		firstDay = new Date(year,month-1,1);
		lastDay = new Date(year,month,0);
		drawDays();
	}
