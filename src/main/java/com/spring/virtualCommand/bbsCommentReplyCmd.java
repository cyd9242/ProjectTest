package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class bbsCommentReplyCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String vCommentNo = request.getParameter("vCommentNo");
		String vNo = request.getParameter("vNo");
		String vId = request.getParameter("vId");
		String vNickName = request.getParameter("vNickName");
		String vCommentContent = request.getParameter("vCommentContent");
		String vCommentGroup = request.getParameter("vCommentGroup");
		String vCommentStep = request.getParameter("vCommentStep");
		String vCommentIndent = request.getParameter("vCommentIndent");
		
		VDAO dao = new VDAO();
		dao.bbsCommentReplyOk(vCommentNo, vNo, vId, vNickName, vCommentContent, vCommentGroup, vCommentStep, vCommentIndent);
	}

}
