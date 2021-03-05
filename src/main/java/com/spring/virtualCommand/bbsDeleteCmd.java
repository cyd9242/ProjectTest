package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class bbsDeleteCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String vNo = request.getParameter("vNo");
		String vId = request.getParameter("vId");
		VDAO dao = new VDAO();
		dao.bbsDelete(vNo,vId);
	}

}
