package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class bbsWriteCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String vId = request.getParameter("vId");
		String vNickName = request.getParameter("vNickName");
		String vSubject = request.getParameter("vSubject");
		String vContent = request.getParameter("vContent");
		
		VDAO dao = new VDAO();
		dao.bbsWrite(vId, vNickName, vSubject, vContent);
	}

}
