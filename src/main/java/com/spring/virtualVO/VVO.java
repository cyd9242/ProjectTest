package com.spring.virtualVO;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class VVO implements UserDetails{
	private String vId;									//	아이디
	private String vPwd;								//	비밀번호
	private String vPwdRe;								//	비밀번호 확인
	private String vNickName;							//	닉네임
	private String vName;								//	이름
	private String vBirth1;								//	생일(년도)
	private String vBirth2;								//	생일(월)
	private String vBirth3;								//	생일(일)
	private String vGender;								//	성별
	private String vEmail;								//	이메일
	private String vTel1;								//	전화번호(앞)
	private String vTel2;								//	전화번호(중간)
	private String vTel3;								//	전화번호(뒤)
	private String vPostCode;							//	우편번호
	private String vAddress1;							//	주소
	private String vAddress2;							//	상세주소
	private String enabled;								//	연결
	private String role_name;							//	권한
	private Timestamp vDate;							//	가입 날짜
	private Timestamp vMemberModificationDate;			//	회원 정보 수정 날짜
	private int vNo;									//	글 번호
	private String vSubject;							//	글 제목
	private String vContent;							//	글 내용
	private int vHit;									//	글 조회수
	private int vCommentCount;							//	댓글 수
	private int vGroup;									//	게시글 그룹
	private int vStep;									//	게시글 단계
	private int vIndent;								//	게시글 들여쓰기
	private int vCommentNo;								//	댓글 번호
	private String vCommentContent;						//	댓글 내용
	private Timestamp vCommentDate;						//	댓글 작성 날짜
	private Timestamp vUpdateDate;						//	댓글 수정 날짜
	private int vCommentGroup;							//	댓글 그룹
	private int vCommentStep;							//	댓글 단계
	private int vCommentIndent;							//	댓글 들여쓰기
	
	
	
	
	
	
	public VVO() {}
	
	
	
	
	
	
	/*					회원 관련					*/
	public VVO(String vId, String vPwd, String vPwdRe, String vNickName, String vName, String vBirth1, String vBirth2, String vBirth3, String vGender, String vEmail, String vTel1, String vTel2, String vTel3, String vPostCode, String vAddress1, String vAddress2, String enabled, String role_name, Timestamp vDate) {
		this.vId = vId;
		this.vPwd = vPwd;
		this.vPwdRe = vPwdRe;
		this.vNickName = vNickName;
		this.vName = vName;
		this.vBirth1 = vBirth1;
		this.vBirth2 = vBirth2;
		this.vBirth3 = vBirth3;
		this.vGender = vGender;
		this.vEmail = vEmail;
		this.vTel1 = vTel1;
		this.vTel2 = vTel2;
		this.vTel3 = vTel3;
		this.vPostCode = vPostCode;
		this.vAddress1 = vAddress1;
		this.vAddress2 = vAddress2;
		this.enabled = enabled;
		this.role_name = role_name;
		this.vDate = vDate;	
	}
	
	public VVO(String vId, String vNickName, String vName, String vBirth1, String vGender, String vEmail, String vTel1, String vPostCode, String vAddress1, String vAddress2, Timestamp vDate, Timestamp vMemberModificationDate) {
		this.vId = vId; 
		this.vNickName = vNickName;
		this.vName = vName;
		this.vBirth1 = vBirth1;
		this.vGender = vGender;
		this.vEmail = vEmail;
		this.vTel1 = vTel1;
		this.vPostCode = vPostCode;
		this.vAddress1 = vAddress1;
		this.vAddress2 = vAddress2;
		this.vDate = vDate;
		this.vMemberModificationDate = vMemberModificationDate;
	}
	
	public VVO(String vId, String vName, String vBirth1, String vGender, String vEmail, String vTel1, String vPostCode, String vAddress1, String vAddress2) {
		this.vId = vId;
		this.vName = vName;
		this.vBirth1 = vBirth1;
		this.vGender = vGender;
		this.vEmail = vEmail;
		this.vTel1 = vTel1;
		this.vPostCode = vPostCode;
		this.vAddress1 = vAddress1;
		this.vAddress2 = vAddress2;
	}
	
	public VVO(String vId,  Timestamp vDate) {
		this.vId = vId;
		this.vDate = vDate;
	}
	
	
	
	
	
	/*					게시글 관련					*/
	
	public VVO(int vNo, String vId, String vNickName, String vSubject, String vContent, Timestamp vDate, int vHit, int vCommentCount, int vGroup, int vStep, int vIndent) {
		this.vNo = vNo;
		this.vId = vId;
		this.vNickName = vNickName;
		this.vSubject = vSubject;
		this.vContent = vContent;
		this.vDate = vDate;
		this.vHit = vHit;
		this.vCommentCount = vCommentCount;
		this.vGroup = vGroup;
		this.vStep = vStep;
		this.vIndent = vIndent;
	} // 리스트 vvo
	
	public VVO(int vNo, String vSubject, String vContent, Timestamp vDate, int vHit, int vGroup, int vStep, int vIndent) {
		this.vNo = vNo;
		this.vSubject = vSubject;
		this.vContent = vContent;
		this.vDate = vDate;
		this.vHit = vHit;
		this.vGroup = vGroup;
		this.vStep = vStep;
		this.vIndent = vIndent;
	}
	
	public VVO(int vNo, String vSubject) {
		this.vNo = vNo;
		this.vSubject = vSubject;
	}
	
	
	
	
	
	/*					댓글 관련					*/
	
	public VVO(int vNo,int vCommentNo, String vCommentContent, String vId, String vNickName, Timestamp vCommentDate, Timestamp vUpdateDate) {
		this.vNo = vNo;
		this.vCommentNo = vCommentNo;
		this.vCommentContent = vCommentContent;
		this.vId = vId;
		this.vNickName = vNickName;
		this.vCommentDate = vCommentDate;
		this.vUpdateDate = vUpdateDate;
	}
	
	public VVO(int vCommentNo, String vCommentContent, String vId, String vNickName, Timestamp vCommentDate, Timestamp vUpdateDate, int vCommentGroup, int vCommentStep, int vCommentIndent) {
		this.vCommentNo = vCommentNo;
		this.vCommentContent = vCommentContent;
		this.vId = vId;
		this.vNickName = vNickName;
		this.vCommentDate = vCommentDate;
		this.vUpdateDate = vUpdateDate;
		this.vCommentGroup = vCommentGroup;
		this.vCommentStep = vCommentStep;
		this.vCommentIndent  = vCommentIndent;
	}
	
	
	
	
	
	/*					getter, setter					*/
	
	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getvPwd() {
		return vPwd;
	}

	public void setvPwd(String vPwd) {
		this.vPwd = vPwd;
	}

	public String getvPwdRe() {
		return vPwdRe;
	}

	public void setvPwdRe(String vPwdRe) {
		this.vPwdRe = vPwdRe;
	}

	public String getvNickName() {
		return vNickName;
	}

	public void setvNickName(String vNickName) {
		this.vNickName = vNickName;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvBirth1() {
		return vBirth1;
	}

	public void setvBirth1(String vBirth1) {
		this.vBirth1 = vBirth1;
	}

	public String getvBirth2() {
		return vBirth2;
	}

	public void setvBirth2(String vBirth2) {
		this.vBirth2 = vBirth2;
	}

	public String getvBirth3() {
		return vBirth3;
	}

	public void setvBirth3(String vBirth3) {
		this.vBirth3 = vBirth3;
	}

	public String getvGender() {
		return vGender;
	}

	public void setvGender(String vGender) {
		this.vGender = vGender;
	}
	
	public String getvEmail() {
		return vEmail;
	}

	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	public String getvTel1() {
		return vTel1;
	}

	public void setvTel1(String vTel1) {
		this.vTel1 = vTel1;
	}

	public String getvTel2() {
		return vTel2;
	}

	public void setvTel2(String vTel2) {
		this.vTel2 = vTel2;
	}

	public String getvTel3() {
		return vTel3;
	}

	public void setvTel3(String vTel3) {
		this.vTel3 = vTel3;
	}

	public String getvPostCode() {
		return vPostCode;
	}

	public void setvPostCode(String vPostCode) {
		this.vPostCode = vPostCode;
	}

	public String getvAddress1() {
		return vAddress1;
	}

	public void setvAddress1(String vAddress1) {
		this.vAddress1 = vAddress1;
	}

	public String getvAddress2() {
		return vAddress2;
	}

	public void setvAddress2(String vAddress2) {
		this.vAddress2 = vAddress2;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Timestamp getvDate() {
		return vDate;
	}

	public void setvDate(Timestamp vDate) {
		this.vDate = vDate;
	}

	public Timestamp getvMemberModificationDate() {
		return vMemberModificationDate;
	}

	public void setvMemberModificationDate(Timestamp vMemberModificationDate) {
		this.vMemberModificationDate = vMemberModificationDate;
	}

	public int getvNo() {
		return vNo;
	}

	public void setvNo(int vNo) {
		this.vNo = vNo;
	}

	public String getvSubject() {
		return vSubject;
	}

	public void setvSubject(String vSubject) {
		this.vSubject = vSubject;
	}

	public String getvContent() {
		return vContent;
	}

	public void setvContent(String vContent) {
		this.vContent = vContent;
	}

	public int getvHit() {
		return vHit;
	}

	public void setvHit(int vHit) {
		this.vHit = vHit;
	}

	public int getvCommentCount() {
		return vCommentCount;
	}

	public void setvCommentCount(int vCommentCount) {
		this.vCommentCount = vCommentCount;
	}

	public int getvGroup() {
		return vGroup;
	}

	public void setvGroup(int vGroup) {
		this.vGroup = vGroup;
	}

	public int getvStep() {
		return vStep;
	}

	public void setvStep(int vStep) {
		this.vStep = vStep;
	}

	public int getvIndent() {
		return vIndent;
	}

	public void setvIndent(int vIndent) {
		this.vIndent = vIndent;
	}

	public int getvCommentNo() {
		return vCommentNo;
	}

	public void setvCommentNo(int vCommentNo) {
		this.vCommentNo = vCommentNo;
	}
	
	public String getvCommentContent() {
		return vCommentContent;
	}

	public void setvCommentContent(String vCommentContent) {
		this.vCommentContent = vCommentContent;
	}

	public Timestamp getvCommentDate() {
		return vCommentDate;
	}

	public void setvCommentDate(Timestamp vCommentDate) {
		this.vCommentDate = vCommentDate;
	}

	public Timestamp getvUpdateDate() {
		return vUpdateDate;
	}

	public void setvUpdateDate(Timestamp vUpdateDate) {
		this.vUpdateDate = vUpdateDate;
	}

	public int getvCommentGroup() {
		return vCommentGroup;
	}

	public void setvCommentGroup(int vCommentGroup) {
		this.vCommentGroup = vCommentGroup;
	}

	public int getvCommentStep() {
		return vCommentStep;
	}

	public void setvCommentStep(int vCommentStep) {
		this.vCommentStep = vCommentStep;
	}

	public int getvCommentIndent() {
		return vCommentIndent;
	}

	public void setvCommentIndent(int vCommentIndent) {
		this.vCommentIndent = vCommentIndent;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public String getPassword() {
		return null;
	}
	
}
