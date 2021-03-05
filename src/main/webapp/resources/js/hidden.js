/**
 * 
 */
	$(function() {
		// 보이기 | 숨기기 
		$(window).scroll(function() { 
			if ($(this).scrollTop() > 350) { //250 넘으면 버튼이 보여짐니다. 
				$('#hidden').fadeIn(); 
			} 
			else { 
				$('#hidden').fadeOut(); 
			} 
		}); // 버튼 클릭시
	});