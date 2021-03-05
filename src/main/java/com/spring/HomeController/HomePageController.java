package com.spring.HomeController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.virtualCommand.VCmd;
import com.spring.virtualCommand.bbsCommentDeleteCmd;
import com.spring.virtualCommand.bbsCommentReplyCmd;
import com.spring.virtualCommand.bbsCommentReplyFormCmd;
import com.spring.virtualCommand.bbsCommentUpdateCmd;
import com.spring.virtualCommand.bbsCommentWriteCmd;
import com.spring.virtualCommand.bbsContentViewCmd;
import com.spring.virtualCommand.bbsDeleteCmd;
import com.spring.virtualCommand.bbsModifyCmd;
import com.spring.virtualCommand.bbsModifyFormCmd;
import com.spring.virtualCommand.bbsReplyCmd;
import com.spring.virtualCommand.bbsReplyFormCmd;
import com.spring.virtualCommand.bbsWriteCmd;
import com.spring.virtualCommand.membershipWithdrawalCmd;
import com.spring.virtualCommand.membershipWithdrawalRoleCmd;
import com.spring.virtualCommand.modifyingMemberInformationCmd;
import com.spring.virtualCommand.resetPasswordCmd;
import com.spring.virtualCommand.signUpCmd;
import com.spring.virtualCommand.signUpRoleCmd;
import com.spring.virtualDAO.VDAO;
import com.spring.virtualEmail.emailCheck;
import com.spring.virtualPaging.CommentMemberPagination;
import com.spring.virtualPaging.MemberPagination;
import com.spring.virtualPaging.Pagination;
import com.spring.virtualPaging.boardService;
import com.spring.virtualTemplate.StaticTemplate;
import com.spring.virtualVO.VVO;

@Controller
public class HomePageController {
	VCmd cmd = null;
	private JdbcTemplate template;
	VDAO dao = new VDAO();
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		StaticTemplate.template = this.template;
	}
	
	
	@ModelAttribute("VVO")
	protected Object formBack() throws Exception{
		return new VVO();
	}
	
	
	
	
	/*					홈페이지					*/
	@RequestMapping("/virtualHomePage")
	public String virtualHomePage() {
		System.out.println("------------ virtualHomePage() 호출 ------------");
		return "virtualHomePage";
	}
	
	
	
	
	
	/*					회원 관련 소스 코드 매핑					*/
	
	/*					회원가입					*/ 
	@RequestMapping("/virtualHomePage/signUp")
	public String signUp() {
		System.out.println("------------ signUp() 호출 ------------");
		return "SignUp/signUpForm";
	}
	
	@RequestMapping("/signUpOk")
	public String signUpOk(HttpServletRequest request, Model model) {
		model.addAttribute("request",request); 
		cmd = new signUpCmd();
		cmd.service(model);
		cmd = new signUpRoleCmd();
		cmd.service(model);
		System.out.println("회원가입을 축하드립니다.");
		return "redirect:virtualHomePage";
	}
	
	/*					아이디 중복 체크					*/
	@RequestMapping("idCheck")
	public String idCheck() {
		return "SignUp/idCheck";
	}
	
	/*					닉네임 중복 체크					*/
	@RequestMapping("NickNameCheck")
	public String NickNameCheck() {
		return "SignUp/NickNameCheck";
	}
	
	/*					회원가입 이메일 인증					*/
	@RequestMapping("emailAuth_SignUp")
	public ModelAndView emailAuth_SignUp(HttpServletResponse response, HttpServletRequest request, String vEmail) throws Exception{
		emailCheck email = new emailCheck();
		vEmail = request.getParameter("vEmail");
		String authNum = "";
		authNum = email.RandoNum();
		email.sendEmail(vEmail,authNum);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("SignUp/emailAuth");
		modelAndView.addObject("vEmail", vEmail);
		modelAndView.addObject("authNum", authNum);
		return modelAndView;
	}
	
	/*					로그인 페이지					*/
	@RequestMapping("/virtualHomePage/loginPage") 
	public String loginPage(Locale locale, Model model) { 
		return "security/login"; 
	}
	 
	
	
	
	
	
	/*					회원 정보 찾기					*/
	
	/*					아이디 찾기					*/
	@RequestMapping("/virtualHomePage/idFind")
	public String idFind() {
		System.out.println("------------ idFind() 호출 ------------");
		return "Find/Id/IdFindForm";
	}
	
	@RequestMapping("/virtualHomePage/idFind/EmailIdFind")
	public String EmailIdFind() {
		System.out.println("------------ EmailIdFind() 호출 ------------");
		return "Find/Id/EmailIdFindForm";
	}
	
	@RequestMapping("emailCheck")
	public String emailCheck(HttpServletRequest request, Model model) {
		return "Find/Id/emailAuth";
	}
	
	@RequestMapping("emailAuth_Id")
	public ModelAndView emailAuth_Id(HttpServletResponse response, HttpServletRequest request, String vEmail) throws Exception{
		emailCheck email = new emailCheck();
		vEmail = request.getParameter("vEmail");
		String authNum = "";
		authNum = email.RandoNum();
		email.sendEmail(vEmail,authNum);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Find/Id/emailAuth");
		modelAndView.addObject("vEmail", vEmail);
		modelAndView.addObject("authNum", authNum);
		return modelAndView;
	}
	
	@RequestMapping("/virtualHomePage/idFind/TelIdFind")
	public String TelIdFind() {
		System.out.println("------------ TelIdFind() 호출 ------------");
		return "Find/Id/TelIdFindForm";
	}
	
	/*					아이디 찾기 결과					*/
	@RequestMapping("/virtualHomePage/idFind/TelIdFindResult")
	public String telIdFindResult(HttpServletResponse response, Timestamp vDate, @RequestParam("vName") String vName, @RequestParam("vBirth1") String vBirth1,
			@RequestParam("vBirth2") String vBirth2, @RequestParam("vBirth3") String vBirth3,
			@RequestParam("vTel1") String vTel1, @RequestParam("vTel2") String vTel2, @RequestParam("vTel3") String vTel3,
			HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("vIds_Tel",dao.TelIdFind(response, vName, vBirth1, vBirth2, vBirth3, vTel1, vTel2, vTel3, vDate));
		System.out.println("------------ telIdFindResult() 호출 ------------");
		return "Find/Id/Result/telIdFindResult";
	}
	
	@RequestMapping("/virtualHomePage/idFind/EmailIdFindResult")
	public String emailIdFindResult(HttpServletResponse response, Timestamp vDate, @RequestParam("vName") String vName, @RequestParam("vBirth1") String vBirth1,
			@RequestParam("vBirth2") String vBirth2, @RequestParam("vBirth3") String vBirth3,
			@RequestParam("vEmail") String vEmail, HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("vIds_Email",dao.EmailIdFind(response, vName, vBirth1, vBirth2, vBirth3, vEmail, vDate));
		System.out.println("------------ emailIdFindResult() 호출 ------------");
		return "Find/Id/Result/emailIdFindResult";
	}
	
	/*					비밀번호 찾기					*/
	@RequestMapping("/virtualHomePage/PasswordFind")
	public String passwordFind() {
		System.out.println("------------ passwordFind() 호출 ------------");
		return "Find/Password/passwordFindForm";
	}
	
	@RequestMapping("/virtualHomePage/PasswordFind/TelPasswordFind")
	public String TelPasswordFind() {
		System.out.println("------------ TelPasswordFind() 호출 ------------");
		return "Find/Password/TelPasswordFindForm";
	}
	
	@RequestMapping("/virtualHomePage/PasswordFind/EmailPasswordFind")
	public String EmailPasswordFind() {
		System.out.println("------------ EmailPasswordFind() 호출 ------------");
		return "Find/Password/EmailPasswordFindForm";
	}
	
	@RequestMapping("emailAuth_Password")
	public ModelAndView emailAuth_Password(HttpServletResponse response, HttpServletRequest request,String vEmail) throws Exception{
		emailCheck email = new emailCheck();
		vEmail = request.getParameter("vEmail");
		String authNum = "";
		authNum = email.RandoNum();
		email.sendEmail(vEmail,authNum);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Find/Password/emailAuth");
		modelAndView.addObject("vEmail", vEmail);
		modelAndView.addObject("authNum", authNum);
		return modelAndView;
	}
	
	/*					비밀번호 찾기 결과					*/
	@RequestMapping("/virtualHomePage/passwordFind/TelPasswordFindResult")
	public String telIdFindResult(HttpServletResponse response, @RequestParam("vId") String vId, @RequestParam("vName") String vName,
			@RequestParam("vTel1") String vTel1, @RequestParam("vTel2") String vTel2, @RequestParam("vTel3") String vTel3,
			HttpServletRequest request, Model model) throws Exception{
			model.addAttribute("result",dao.TelPasswordFind(response, vId, vName, vTel1, vTel2, vTel3));
			System.out.println("------------ telPasswordFindResult() 호출 ------------");
			return "Find/Password/Result/telPasswordFindResult";
	}
	
	@RequestMapping("/virtualHomePage/passwordFind/EmailPasswordFindResult")
	public String emailPasswordFindResult(HttpServletResponse response, @RequestParam("vId") String vId, @RequestParam("vName") String vName, 
			@RequestParam("vEmail") String vEmail, HttpServletRequest request, Model model) throws Exception{
			model.addAttribute("result", dao.EmailPasswordFind(response, vId, vName, vEmail));
			System.out.println("------------ emailPasswordFindResult() 호출 ------------");
		return "Find/Password/Result/emailPasswordFindResult";
	}
	
	@RequestMapping("/ResetPasswordOk")
	public String pwdUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request",request); 
		cmd = new resetPasswordCmd();
		cmd.service(model);
		System.out.println("비밀번호를 정상적으로 변경하였습니다. \n변경된 비밀번호로 로그인 해주세요.");
		return "redirect:virtualHomePage";
	}
	/*					회원정보					*/
	@RequestMapping("/virtualHomePage/MemberInformation")
	public String MemberInformation(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException{
		model.addAttribute("userTotal",dao.userBBSList());
		model.addAttribute("MemberCommentCount",dao.userCommentCount());
		model.addAttribute("Member",dao.Member(response));
		model.addAttribute("NickName",dao.NickName(response));
		System.out.println("------------ MemberInformation() 호출 ------------");
		return "security/member/memberInformation";
	}
	
	/*					회원정보 재인증					*/
	@RequestMapping("/virtualHomePage/MemberInformation/MemberInformationCertification")
	public String MemberInformationCertification() {
		System.out.println("------------ MemberInformationCertification() 호출 ------------");
		return "security/member/memberInformationCertification";
	}
	
	/*					회원정보 변경					*/

	@RequestMapping("/virtualHomePage/MemberInformation/MemberInformationCertification/ModifyingMemberInformation")
	public String memberInformationCertificationOK(HttpServletResponse response, HttpServletRequest request, @RequestParam("vId") String vId, @RequestParam("vPwd") String vPwd, Model model) throws Exception{
		List<VVO> vMemberInformation = dao.MemberInformationCertificationOK(vId, vPwd);
		model.addAttribute("vMemberInformation",dao.MemberInformationCertificationOK(response, vId, vPwd));
		if(vMemberInformation.isEmpty()) {
			System.out.println("오류발생");
			return "security/member/memberInformationCertification";
		}
		else {
			System.out.println("------------ memberInformation() 호출 ------------");
			return "security/member/modifyingMemberInformation";
		}
	}
	
	/*					회원 이메일 변경					*/
	@RequestMapping("emailAuth_ModifyingMemberInformation")
	public ModelAndView emailAuth_ModifyingMemberInformation(HttpServletResponse response, HttpServletRequest request, String vEmail) throws Exception{
		emailCheck email = new emailCheck();
		vEmail = request.getParameter("vEmail");
		String authNum = "";
		authNum = email.RandoNum();
		email.sendEmail(vEmail,authNum);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("security/member/emailAuth");
		modelAndView.addObject("vEmail", vEmail);
		modelAndView.addObject("authNum", authNum);
		return modelAndView;
	}

	@RequestMapping("/modifyingEmail")
	public String modifyingEmail() {
		return "security/member/modifyingEmail";
	}
	
	/*					회원정보 변경 완료					*/
	@RequestMapping("/modifyingMemberInformationOK")
	public String modifyingMemberInformation(HttpServletRequest request, Model model) {
		model.addAttribute("request",request); 
		cmd = new modifyingMemberInformationCmd();
		cmd.service(model);
		System.out.println("회원정보가 정상적으로 수정되었습니다.");
		return "redirect:virtualHomePage";
	}
	
	/*					회원정보 삭제					*/
	@RequestMapping("/virtualHomePage/MemberInformation/MembershipWithdrawal")
	public String MembershipWithdrawal(Model model){
		model.addAttribute("pwdResult", dao.checkPassword());
		System.out.println("------------ MembershipWithdrawal() 호출 ------------");
		return "security/member/membershipWithdrawal";
	}
	
	/*					회원정보 삭제 완료						*/
	@RequestMapping("/MembershipWithdrawalOK")
	public String MembershipWithdrawalOK(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		cmd = new membershipWithdrawalRoleCmd();
		cmd.service(model);
		cmd = new membershipWithdrawalCmd();
		cmd.service(model);
		System.out.println("회원탈퇴를 성공하셨습니다.");
		return "redirect:virtualHomePage";
	}
	
	
	
	
	
	
	/*					게시판 관련 소스					*/
	
	/*					전체 게시판 보기					*/
	@RequestMapping("/virtualHomePage/virtualBulletinBoard")
	public String virtualBulletinBoardList(Model model, HttpServletRequest request,@RequestParam(defaultValue = "1") int page, String vNo){
		// RequestPara defalutValue = 값이 없을 때 1로 처음에 받아줌
		System.out.println("------------ virtualBulletinBoardList() ------------");
		int totalListCnt = dao.totalListCnt();
		Pagination pagination = new Pagination(totalListCnt, page);		
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
		System.out.println("전체글 수 : " + pagination.getTotalListCnt() + " | 현재 페이지 : " + pagination.getPage() + " | 시작 페이지 : "	+ pagination.getStartPage() + " | 마지막 페이지 : " + pagination.getEndPage() + " "); // 확인용
		boardService boardService = new boardService();
		ArrayList<VVO> list = boardService.noticeBoardList(startIndex, pageSize);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		return "BulletinBoard/virtualBulletinBoard";
	}
	
	/*					특정 유저가 쓴 게시판 보기					*/
	@RequestMapping("/virtualHomePage/virtualMemberBulletinBoard")
	public String virtualMemberBulletinBoard(Model model, HttpServletRequest request,@RequestParam(defaultValue = "1") int page, String vId, HttpServletResponse response) throws IOException{
		System.out.println("------------ virtualMemberBulletinBoardList() ------------");
		int totalListCnt = dao.MemberBBSList(vId);
		MemberPagination pagination = new MemberPagination(vId, totalListCnt, page);
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
		System.out.println("전체글 수 : " + pagination.getTotalListCnt() + " | 현재 페이지 : " + pagination.getPage() + " | 시작 페이지 : "	+ pagination.getStartPage() + " | 마지막 페이지 : " + pagination.getEndPage() + " "); // 확인용
		boardService boardService = new boardService();
		ArrayList<VVO> MemberBbsList = boardService.MemberNoticeBoardList(vId, startIndex, pageSize);
		model.addAttribute("MemberList",MemberBbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("totalList",dao.MemberBBSList(vId));
		model.addAttribute("CommentTotalList",dao.CommentMemberTotal(vId));
		model.addAttribute("user",dao.MemberId(vId));
		model.addAttribute("MaskingUser",dao.MemberId(response, vId));
		model.addAttribute("NickName",dao.MemberNickName(response, vId));
		return "BulletinBoard/virtualMemberBulletinBoard";
	}
	
	/*					게시판 글쓰기					*/
	@RequestMapping("/virtualHomePage/virtualBulletinBoard/Write")
	public String writeForm(Model model, HttpServletResponse response) throws IOException {
		model.addAttribute("NickName",dao.NickName(response));
		return "BulletinBoard/bbsWriteForm";
	}
	
	@RequestMapping("/bbsWriteOk")
	public String bbsWriteOk(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		cmd = new bbsWriteCmd();
		cmd.service(model);
		return "redirect:virtualHomePage/virtualBulletinBoard";
	}
	
	/*					게시글 보기					*/
	@RequestMapping("/virtualHomePage/virtualBulletinBoard/contentView")
	public String bbsContentView(HttpServletRequest request,HttpServletResponse response, Model model, String vNo, String vSubject) throws IOException {
		model.addAttribute("request",request);
		cmd = new bbsContentViewCmd();
		cmd.service(model);
		model.addAttribute("title",dao.titleSubject(response, vNo, vSubject));
		model.addAttribute("totalList",dao.CommentTotal(vNo));
		model.addAttribute("Number",dao.CommentVNo(response, vNo));
		model.addAttribute("NickName",dao.NickName());
		return "BulletinBoard/contentView";
	}
	
	/*					게시글 수정					*/	
	@RequestMapping("/virtualHomePage/virtualBulletinBoard/contentView/modify")
	public String bbsModify(HttpServletRequest request,HttpServletResponse response, Model model, String vNo, String vSubject) throws IOException {
		System.out.println("글 수정 폼");
		model.addAttribute("request",request);
		cmd = new bbsModifyFormCmd();
		cmd.service(model);
		model.addAttribute("title",dao.titleSubject(response, vNo, vSubject));
		model.addAttribute("NickName",dao.NickName(response));
		return "BulletinBoard/bbsModifyForm";
	}
	
	@RequestMapping("/bbsModifyOk")
	public String bbsModifyOK(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		cmd = new bbsModifyCmd();
		cmd.service(model);
		System.out.println("글 수정 완료");
		return "redirect:virtualHomePage/virtualBulletinBoard";
	}
	
	/*					게시글 삭제					*/
	@RequestMapping("/bbsDelete")
	public String bbsDelete(HttpServletRequest request, Model model) {
		System.out.println("글 삭제 완료");
		model.addAttribute("request", request);
		cmd = new bbsDeleteCmd();
		cmd.service(model);
		return "redirect:virtualHomePage/virtualBulletinBoard";
	}
	
	/*					게시글 답글					*/
	@RequestMapping("/virtualHomePage/virtualBulletinBoard/contentView/reply")
	public String bbsReply(HttpServletRequest request, HttpServletResponse response, Model model, String vNo, String vSubject) throws IOException {
		model.addAttribute("request",request);
		cmd = new bbsReplyFormCmd();
		cmd.service(model);
		model.addAttribute("title",dao.titleSubject(response, vNo, vSubject));
		model.addAttribute("NickName",dao.NickName());
		System.out.println("답글 ");
		return "BulletinBoard/bbsReplyForm";
	}
	
	@RequestMapping("/bbsReplyOk")
	public String bbsReplyOk(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		cmd = new bbsReplyCmd();
		cmd.service(model);
		System.out.println("답글작성완료");
		return "redirect:virtualHomePage/virtualBulletinBoard";
	}
	
	
	
	
	
	/*					댓글 관련					*/
	
	/*					댓글 목록					*/
	@RequestMapping("/CommentList")
	public String CommnetList(Model model, HttpServletRequest request, String vNo, HttpServletResponse response) throws IOException {
		System.out.println("전체 댓글 수 : " + dao.CommentTotal(vNo)); // 확인용
		model.addAttribute("CommentList", dao.CommentList(vNo));
		model.addAttribute("totalList",dao.CommentTotal(vNo));
		model.addAttribute("Number",dao.CommentVNo(response, vNo));
		model.addAttribute("Writer",dao.bbsWriter(vNo, response));
		System.out.println("vNo Home = "+dao.CommentVNo(response, vNo));
		return"BulletinBoard/Comment";
	}
	
	/*					특정 유저가 쓴 댓글 보기					*/
	@RequestMapping("/virtualHomePage/virtualMemberCommentBulletinBoard")
	public String virtualMemberCommentBulletinBoard(Model model, HttpServletRequest request,@RequestParam(defaultValue = "1") int page, String vId, HttpServletResponse response) throws IOException{
		int totalListCnt = dao.CommentMemberTotal(vId);
		CommentMemberPagination pagination = new CommentMemberPagination(vId, totalListCnt, page); 
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
		System.out.println("전체 댓글 수 : " + pagination.getTotalListCnt() + " | 현재 페이지 : " + pagination.getPage() + " | 시작 페이지 : "	+ pagination.getStartPage() + " | 마지막 페이지 : " + pagination.getEndPage() + " "); // 확인용
		boardService boardService = new boardService();
		ArrayList<VVO> CommentMember = boardService.CommentMemberNoticeBoardList(vId, startIndex, pageSize);
		model.addAttribute("CommentMemberList", CommentMember);
		model.addAttribute("pagination",pagination);
		model.addAttribute("totalList",dao.MemberBBSList(vId));
		model.addAttribute("CommentTotalList",dao.CommentMemberTotal(vId));
		model.addAttribute("user",dao.MemberId(vId));
		model.addAttribute("MaskingUser",dao.MemberId(response, vId));
		model.addAttribute("NickName",dao.MemberNickName(response, vId));
		return "BulletinBoard/virtualMemberCommentBulletinBoard";
	}
	
	/*					댓글 쓰기					*/
	@RequestMapping("/CommentWrite")
	public String CommentWrite(HttpServletRequest request, Model model, String vNo, HttpServletResponse response) throws IOException {
		model.addAttribute("request",request);
		cmd = new bbsCommentWriteCmd();
		cmd.service(model);
		model.addAttribute("Number",dao.CommentVNo(response, vNo));
		model.addAttribute("NickName",dao.NickName(response));
		return "redirect:CommentList?vNo="+vNo;
	}
	
	/*					댓글 수정					*/
	@RequestMapping("/CommentModifySelect")
	public String CommentModifySelect(HttpServletRequest request, Model model, String vCommentNo ) {
		model.addAttribute("bbsCommentList",dao.bbsCommentSelect(vCommentNo));
		return "BulletinBoard/CommentModify";
	}
	
	@RequestMapping("/CommentModify")
	public String CommentModify(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		cmd = new bbsCommentUpdateCmd();
		cmd.service(model);
		return "success";
	}
	
	/*					댓글 삭제					*/
	@RequestMapping("/CommentDelete")
	public String CommentDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		cmd = new bbsCommentDeleteCmd();
		cmd.service(model);
		return "success";
	}
	
	/*					댓글 답글					*/
	@RequestMapping("/CommentReplyForm")
	public String CommentReplyForm(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
		model.addAttribute("request",request);
		cmd = new bbsCommentReplyFormCmd();
		cmd.service(model);
		model.addAttribute("NickName",dao.NickName(response));
		return "BulletinBoard/CommentReplyForm";
	}
	
	@RequestMapping("/CommentReply")
	public String CommentReply(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		cmd = new bbsCommentReplyCmd();
		cmd.service(model);
		return "success";
	}
	
}
