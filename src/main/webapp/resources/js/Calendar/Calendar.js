/**
 * 
 */

	function drawCalendar(){
		var setTableHTML = "";
		setTableHTML+='<table class="calendar" align = "center" cellpadding = "0">';
		setTableHTML+='<tr align = "center" style = "font-size:13px;"><th style = "color:red";>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th style = "color:blue;">토</th></tr>';
		for(var i=0;i<6;i++){
			setTableHTML+='<tr height="25">';
			for(var j=0;j<7;j++){
				setTableHTML+='<td style=" text-overflow:ellipsis;overflow:hidden;white-space:nowrap" onClick="selectDay()">';
				setTableHTML+='    <div class="cal-day"></div>';
				setTableHTML+='    <div class="cal-schedule"></div>';
				setTableHTML+='</td>';
			}
			setTableHTML+='</tr>';
		}
		setTableHTML+='</table>';
		$("#cal_tab").html(setTableHTML);
	}
