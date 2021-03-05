package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;
import com.spring.virtualVO.VVO;

public class bbsReplyFormCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String vNo = request.getParameter("vNo");
		
		VDAO dao = new VDAO();
		VVO VVO = dao.replyForm(vNo);
		
		model.addAttribute("replyForm", VVO);
	}

}
