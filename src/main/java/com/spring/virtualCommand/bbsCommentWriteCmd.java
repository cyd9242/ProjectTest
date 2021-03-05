package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;



public class bbsCommentWriteCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String vNo = request.getParameter("vNo");
		String vCommentContent = request.getParameter("vCommentContent");
		String vId = request.getParameter("vId");
		String vNickName = request.getParameter("vNickName");
		
		VDAO dao = new VDAO();
		dao.bbsCommentWrite(vNo, vCommentContent, vId, vNickName);
	}

}
