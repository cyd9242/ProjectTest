package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class resetPasswordCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String vId = request.getParameter("vId");
		String vPwd = request.getParameter("vPwd");
		VDAO dao = new VDAO();
		dao.pwdUpdate(vId,vPwd);
	}

}
