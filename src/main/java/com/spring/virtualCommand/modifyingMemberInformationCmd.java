package com.spring.virtualCommand;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class modifyingMemberInformationCmd implements VCmd {

	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String vId = request.getParameter("vId");
		String vPwd = request.getParameter("vPwd");
		String vName = request.getParameter("vName");
		String vEmail = request.getParameter("vEmail");
		String vTel1 = request.getParameter("vTel1");
		String vTel2 = request.getParameter("vTel2");
		String vTel3 = request.getParameter("vTel3");
		String vPostCode = request.getParameter("vPostCode");
		String vAddress1 = request.getParameter("vAddress1");
		String vAddress2 = request.getParameter("vAddress2");
		Timestamp vMemberModificationDate = new Timestamp(System.currentTimeMillis());
	
		VDAO dao = new VDAO();
		dao.modifyingMemberInformation(vId, vPwd, vName, vEmail, vTel1, vTel2, vTel3, vPostCode, vAddress1, vAddress2, vMemberModificationDate);
	}

}
