package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class signUpRoleCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String vId = request.getParameter("vId");
		String role_name = request.getParameter("role_name");
		
		VDAO dao = new VDAO(); 
		dao.signUPRole(vId, role_name);

	}

}
