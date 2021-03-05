/**
 * 
 */

	$(document).ready(function() {
		drawCalendar();
		initDate();
		drawDays();
		$("#movePrevMonth").on("click", function(){movePrevMonth();});
		$("#moveNextMonth").on("click", function(){moveNextMonth();});
	});
