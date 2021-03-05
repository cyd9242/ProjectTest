package com.spring.virtualCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class signUpCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String vId = request.getParameter("vId");
		String vPwd = request.getParameter("vPwd");
		String vNickName = request.getParameter("vNickName");
		String vName = request.getParameter("vName");
		String vBirth1 = request.getParameter("vBirth1");
		String vBirth2 = request.getParameter("vBirth2");
		String vBirth3 = request.getParameter("vBirth3");
		String vGender = request.getParameter("vGender");
		String vEmail = request.getParameter("vEmail");
		String vTel1 = request.getParameter("vTel1");
		String vTel2 = request.getParameter("vTel2");
		String vTel3 = request.getParameter("vTel3");
		String vPostCode = request.getParameter("vPostCode");
		String vAddress1 = request.getParameter("vAddress1");
		String vAddress2 = request.getParameter("vAddress2");
		String enabled = request.getParameter("enabled");
		
		VDAO dao = new VDAO();
		dao.signUP(vId, vPwd, vNickName, vName, vBirth1, vBirth2, vBirth3, vGender, vEmail, vTel1, vTel2, vTel3, vPostCode, vAddress1, vAddress2, enabled);
	}

}
