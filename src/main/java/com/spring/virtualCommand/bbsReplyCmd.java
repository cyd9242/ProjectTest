package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class bbsReplyCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String vNo = request.getParameter("vNo");
		String vId = request.getParameter("vId");
		String vNickName = request.getParameter("vNickName");
		String vSubject = request.getParameter("vSubject");
		String vContent = request.getParameter("vContent");
		String vGroup = request.getParameter("vGroup");
		String vStep = request.getParameter("vStep");
		String vIndent = request.getParameter("vIndent");
		
		VDAO dao = new VDAO();
		dao.bbsReplyOk(vNo, vId, vNickName, vSubject, vContent, vGroup, vStep, vIndent);
	}

}
