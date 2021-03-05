/**
 * 
 */

	var today = null;
	var year = null;
	var month = null;
	var firstDay = null;
	var lastDay = null;
	var $tdDay = null;
	var $tdSche = null;
 
	//날짜 초기화
	function initDate(){
		$tdDay = $("td div.cal-day")
		$tdSche = $("td div.cal-schedule")
		dayCount = 0;
		today = new Date();
		year = today.getFullYear();
		month = today.getMonth()+1;
		firstDay = new Date(year,month-1,1);
		lastDay = new Date(year,month,0);
		date = new Date();
	}
    
	//calendar 날짜표시
	function drawDays(){
		$("#cal_top_year").text(year);
		$("#cal_top_month").text(month);
		for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
		    $tdDay.eq(i).text(++dayCount);
			if(today.getFullYear()==date.getFullYear()&&today.getMonth()==date.getMonth()&&i==date.getDate()) {
				$tdDay.eq((i)).css("color", "white");
				$tdDay.eq((i)).css("background", "#98afc7");
				$tdDay.eq((i)).css("border-radius", "50%");
			}
		}
		for(var i=0;i<42;i+=7){
		    $tdDay.eq(i).css("color","red");
		}
		for(var i=6;i<42;i+=7){
		    $tdDay.eq(i).css("color","blue");
		}
	}

	
