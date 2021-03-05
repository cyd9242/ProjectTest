package com.spring.virtualCommand;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.virtualDAO.VDAO;

public class bbsCommentUpdateCmd implements VCmd {

	@Override
	public void service(Model model) {
		 Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String vCommentNo = request.getParameter("vCommentNo");
		String vCommentContent = request.getParameter("vCommentContent");
		String vId = request.getParameter("vId");
		Timestamp vUpdateDate = new Timestamp(System.currentTimeMillis());
		
		VDAO dao = new VDAO();
		dao.bbsCommentModify(vCommentContent, vUpdateDate, vCommentNo, vId);
	}

}
