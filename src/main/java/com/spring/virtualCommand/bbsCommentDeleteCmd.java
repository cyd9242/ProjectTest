package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class bbsCommentDeleteCmd implements VCmd {

	@Override
	public void service(Model model) {
Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String vNo = request.getParameter("vNo");
		String vCommentNo = request.getParameter("vCommentNo");
		String vId = request.getParameter("vId");
		
		VDAO dao = new VDAO();
		dao.bbsCommentDelete(vNo, vCommentNo, vId);
	}

}
