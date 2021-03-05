package com.spring.virtualPaging;

import java.util.ArrayList;

import com.spring.virtualDAO.VDAO;
import com.spring.virtualVO.VVO;

public class boardService {
	public ArrayList<VVO> noticeBoardList(int startIndex, int pageSize){
		VDAO dao = new VDAO();
		return dao.list(startIndex, pageSize);
	}
	public ArrayList<VVO> MemberNoticeBoardList(String vId, int startIndex, int pageSize){
		VDAO dao = new VDAO();
		return dao.MemberBbsList(vId, startIndex, pageSize);
	}
	
//	public ArrayList<VVO> CommentNoticeBoardList(String vNo, int  startIndex, int pageSize){
//		VDAO dao = new VDAO();
//		return dao.Comment(vNo, startIndex, pageSize);
//	}
	
	public ArrayList<VVO> CommentMemberNoticeBoardList(String vId, int  startIndex, int pageSize){
		VDAO dao = new VDAO();
		return dao.CommentMember(vId, startIndex, pageSize);
	}
	
}
