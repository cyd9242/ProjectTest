package com.spring.virtualDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.spring.virtualTemplate.StaticTemplate;
import com.spring.virtualVO.VVO;

@Repository
public class VDAO {
	@Autowired
	JdbcTemplate template;
	
	DataSource dataSource;
	
	private Connection conn;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private static VDAO instance = new VDAO();
	public VDAO() {
		this.template = StaticTemplate.template;
	}
	public static VDAO getInstance() {
		return instance;
	}
	
	// 커넥션 풀 이용 
	private Connection getConnection() throws Exception {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle12c");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
		return dataSource.getConnection();
	}
	
	// 데이터베이스 연결 종료
	
	private void closeDB() {
		try {
			if(preparedStatement != null) { preparedStatement.close(); }
			if(resultSet != null) { resultSet.close(); }
			if(conn != null) { conn.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*		회원가입 관련 소스			*/
	public void signUP(final String vId, final String vPwd, final String vNickName, final String vName, final String vBirth1, final String vBirth2, final String vBirth3, final String vGender, final String vEmail, final String vTel1, final String vTel2, final String vTel3, final String vPostCode, final String vAddress1, final String vAddress2, final String enabled) {
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = "insert into virtual_member(vId,vPwd,vNickName,vName,vBirth,vGender,vEmail,vTel,vPostCode,vAddress1,vAddress2) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, vId);
				preparedStatement.setString(2, vPwd);
				preparedStatement.setString(3, vNickName);
				preparedStatement.setString(4, vName);
				preparedStatement.setString(5, vBirth1+"년 "+vBirth2+"월 "+vBirth3+"일");
				preparedStatement.setString(6, vGender);
				preparedStatement.setString(7, vEmail);
				preparedStatement.setString(8, vTel1+"-"+vTel2+"-"+vTel3);
				preparedStatement.setString(9, vPostCode);
				preparedStatement.setString(10, vAddress1);
				preparedStatement.setString(11, vAddress2);
				
				
				return preparedStatement;
			}
		});
		
	}
	public void signUPRole(final String vId, final String role_name) {
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = "insert into user_roles(vId, role_name) values(?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, vId);
				preparedStatement.setString(2, role_name);
				return preparedStatement;
			}
		});
	}
	
	/*					아이디 중복 체크					*/
	public boolean checkId(String vId) {
		boolean check = false;
		try {
			conn = getConnection();
			String sql = "SELECT vId FROM virtual_member WHERE vId = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, vId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				check = true;
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return check;
	}
	
	/*					닉네임 중복 체크					*/
	public boolean checkNickName(String vNickName) {
		boolean NickCheck = false;
		try {
			conn = getConnection();
			String sql = "SELECT vNickName FROM virtual_member WHERE vNickName = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, vNickName);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				NickCheck = true;
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return NickCheck;
	}
	
	/*					회원 찾기					*/
	
	/*					아이디 찾기					*/
	public List<VVO> TelIdFind(String vName, String vBirth1, String vBirth2, String vBirth3, String vTel1, String vTel2, String vTel3, Timestamp vDate) {
		List<VVO> vIds_Tel = new ArrayList<VVO>();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			conn = getConnection();
			String telIdFindsql = "SELECT vId, vName, vBirth, vTel,vDate FROM virtual_member WHERE vName=? AND vBirth=? AND vTel=?";
			preparedStatement = conn.prepareStatement(telIdFindsql);
			preparedStatement.setString(1, vName);
			preparedStatement.setString(2, vBirth1+"년 "+vBirth2+"월 "+vBirth3+"일");
			preparedStatement.setString(3, vTel1+"-"+vTel2+"-"+vTel3);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String vId = resultSet.getString("vId");
				vDate = resultSet.getTimestamp("vDate");
				VVO vvo = new VVO(vId, vDate);
				vIds_Tel.add(vvo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return vIds_Tel;
	}
	
	public List<VVO> TelIdFind(HttpServletResponse response , String vName, String vBirth1, String vBirth2, String vBirth3, String vTel1, String vTel2, String vTel3, Timestamp vDate) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<VVO> vIds_Tel = TelIdFind(vName, vBirth1, vBirth2, vBirth3, vTel1, vTel2, vTel3,vDate);
		if(vIds_Tel.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return vIds_Tel;
		}
	}
	
	
	public List<VVO> EmailIdFind(String vName, String vBirth1, String vBirth2, String vBirth3, String vEmail, Timestamp vDate) {
		List<VVO> vIds_Email = new ArrayList<VVO>();
		try {
			conn = getConnection();
			String emailIdFindsql = "SELECT vId, vName, vBirth, vEmail,vDate FROM virtual_member WHERE vName=? AND vBirth=? AND vEmail=?";
			preparedStatement = conn.prepareStatement(emailIdFindsql);
			preparedStatement.setString(1, vName);
			preparedStatement.setString(2, vBirth1+"년 "+vBirth2+"월 "+vBirth3+"일");
			preparedStatement.setString(3, vEmail);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String vId = resultSet.getString("vId");
				vDate = resultSet.getTimestamp("vDate");
				VVO vvo = new VVO(vId, vDate);
				vIds_Email.add(vvo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return vIds_Email;
	}
	
	public List<VVO> EmailIdFind(HttpServletResponse response , String vName, String vBirth1, String vBirth2, String vBirth3, String vEmail, Timestamp vDate) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<VVO> vIds_Email = EmailIdFind(vName, vBirth1, vBirth2, vBirth3, vEmail, vDate);
		if(vIds_Email.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return vIds_Email;
		}
	}
	
	/*					비밀번호 찾기					*/	
	public String TelPasswordFind(String vId, String vName, String vTel1, String vTel2, String vTel3) {
		String result = "";
		try {
			conn = getConnection();
			String telPasswordFindsql = "SELECT vId, vName, vTel FROM virtual_member WHERE vId=? AND vName=? AND vTel=?";
			preparedStatement = conn.prepareStatement(telPasswordFindsql);
			preparedStatement.setString(1, vId);
			preparedStatement.setString(2, vName);
			preparedStatement.setString(3, vTel1 + "-" + vTel2 + "-" + vTel3);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				result = resultSet.getString("vId");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return result;
	}
	
	public String TelPasswordFind(HttpServletResponse response , String vId, String vName, String vTel1, String vTel2, String vTel3) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String result= TelPasswordFind(vId, vName, vTel1, vTel2, vTel3);
		if(result.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('가입된 정보가 없습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return result;
		}
	}
	
	public String EmailPasswordFind(String vId, String vName, String vEmail) {
		String result = "";
		try {
			conn = getConnection();
			String emailPasswordFindsql = "SELECT vId, vName, vEmail FROM virtual_member WHERE vId=? AND vName=? AND vEmail=?";
			preparedStatement = conn.prepareStatement(emailPasswordFindsql);
			preparedStatement.setString(1, vId);
			preparedStatement.setString(2, vName);
			preparedStatement.setString(3, vEmail);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				result = resultSet.getString("vId");
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return result;
	}
	
	public String EmailPasswordFind(HttpServletResponse response , String vId, String vName, String vEmail) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String result= EmailPasswordFind(vId, vName, vEmail);
		if(result.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('가입된 정보가 없습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return result;
		}
	}
	
	/*					회원 정보					*/
	public List<VVO> MemberInformationCertificationOK(String vId, String vPwd){
		List<VVO> vMemberInformation = new ArrayList<VVO>();
		try {
			conn = getConnection();
			String telIdFindsql = "SELECT * FROM virtual_member WHERE vId=? AND vPwd=?";
			preparedStatement = conn.prepareStatement(telIdFindsql);
			preparedStatement.setString(1, vId);
			preparedStatement.setString(2, vPwd);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				vId = resultSet.getString("vId");
				String vName = resultSet.getString("vName");
				String vBirth1 = resultSet.getString("vBirth");
				String vGender = resultSet.getString("vGender");
				String vEmail = resultSet.getString("vEmail");
				String vTel1 = resultSet.getString("vTel");
				String vPostCode = resultSet.getString("vPostCode");
				String vAddress1 = resultSet.getString("vAddress1");
				String vAddress2 = resultSet.getString("vAddress2");
				
				VVO vvo = new VVO(vId, vName, vBirth1, vGender, vEmail, vTel1, vPostCode, vAddress1, vAddress2);
				vMemberInformation.add(vvo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return vMemberInformation;
	}
	public List<VVO> MemberInformationCertificationOK(HttpServletResponse response , String vId, String vPwd) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<VVO> vMemberInformation = MemberInformationCertificationOK(vId, vPwd);
		if(vMemberInformation.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('회원정보가 일치하지 않습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return vMemberInformation;
		}
	}
	
	/*					회원 정보 변경					*/
	public void modifyingMemberInformation(final String vId, final String vPwd, final String vName, final String vEmail, final String vTel1, final String vTel2, final String vTel3, final String vPostCode, final String vAddress1, final String vAddress2, final Timestamp vMemberModificationDate) {
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String memberUpdateSql = "UPDATE virtual_member SET vName=?, vPwd=?, vEmail=?, vTel=? , vPostCode=? , vAddress1=? , vAddress2=?, vMemberModificationDate = ? WHERE vId = ?";
				PreparedStatement preparedStatement = conn.prepareStatement(memberUpdateSql);
				preparedStatement.setString(1, vName);
				preparedStatement.setString(2, vPwd);
				preparedStatement.setString(3, vEmail);
				preparedStatement.setString(4, vTel1+"-"+vTel2+"-"+vTel3);
				preparedStatement.setString(5, vPostCode);
				preparedStatement.setString(6, vAddress1);
				preparedStatement.setString(7, vAddress2);
				preparedStatement.setTimestamp(8, vMemberModificationDate);
				preparedStatement.setString(9, vId);
				return preparedStatement;
			}
		});
	}
	
	/*					비밀번호 수정					*/
	public void pwdUpdate(final String vId, final String vPwd) {
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String updatesql = "UPDATE virtual_member SET vPwd = ? WHERE vId = ?";
				PreparedStatement preparedStatement = conn.prepareStatement(updatesql);
				preparedStatement.setString(1, vPwd);
				preparedStatement.setString(2, vId);
				return preparedStatement;
			}
		});
	}
	
	/*					회원 정보 삭제					*/
	public void membershipWithdrawal(final String vId, final String vPwd) {
		String membershipWithdrawalsql = "DELETE FROM virtual_member WHERE vId = ? AND vPwd = ?";
		this.template.update(membershipWithdrawalsql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, vId);
				preparedStatement.setString(2, vPwd);
			}
		});
	}
	
	public void membershipWithdrawalRole(final String vId) {
		String membershipWithdrawalRolesql = "DELETE FROM user_roles WHERE vId = ?";
		this.template.update(membershipWithdrawalRolesql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, vId);
			}
		});
	}
	
	/*					회원 비밀번호 일치 확인					*/
	public String checkPassword() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String userId = user.getUsername();
		String pwdResult = "";
		try {
			conn = getConnection();
			String emailPasswordFindsql = "SELECT vId, vPwd FROM virtual_member WHERE vId=?";
			preparedStatement = conn.prepareStatement(emailPasswordFindsql);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				pwdResult = resultSet.getString("vPwd");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return pwdResult;
	}
	
	
	
	
	
		
	/*					게시판					*/
	
	/*					게시판 보기					*/
	public ArrayList<VVO> list(int startIndex, int pageSize){
		ArrayList<VVO> VbbsVOs = new ArrayList<VVO>(); 
		try {
			conn = getConnection();
			String bbsListSql = "SELECT virtual_bbs.* FROM( SELECT virtual_bbs.* FROM virtual_bbs ORDER BY vGroup DESC, vStep ASC) virtual_bbs OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
			preparedStatement = conn.prepareStatement(bbsListSql);
			preparedStatement.setInt(1, startIndex); 
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery(); 
			
			while(resultSet.next()) {
				int vNo = resultSet.getInt("vNo"); 
				String vId = resultSet.getString("vId");
				String vNickName = resultSet.getString("vNickName");
				String vSubject = resultSet.getString("vSubject"); 
				String vContent = resultSet.getString("vContent"); 
				Timestamp vDate = resultSet.getTimestamp("vDate"); 
				int vHit = resultSet.getInt("vHit"); 
				int vCommentCount = resultSet.getInt("vCommentCount");
				int vGroup = resultSet.getInt("vGroup"); 
				int vStep = resultSet.getInt("vStep"); 
				int vIndent = resultSet.getInt("vIndent"); 
				VVO vbbsVVO = new VVO(vNo, vId, vNickName, vSubject, vContent, vDate, vHit, vCommentCount, vGroup, vStep, vIndent); 
				VbbsVOs.add(vbbsVVO); 
			} 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} finally { 
			closeDB(); 
		}

		return VbbsVOs;	
	} // list()
	
	/*					특정 멤버 게시글 모아 보기					*/
	public ArrayList<VVO> MemberBbsList(String vId, int startIndex, int pageSize){
		ArrayList<VVO> MemberListVVO = new ArrayList<VVO>();
		try {
			conn = getConnection();
			String bbsListSql = "SELECT virtual_bbs.* FROM( SELECT virtual_bbs.* FROM virtual_bbs WHERE vId = ? ORDER BY vGroup DESC, vStep ASC) virtual_bbs OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
			preparedStatement = conn.prepareStatement(bbsListSql);
			preparedStatement.setString(1, vId);
			preparedStatement.setInt(2, startIndex); 
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery(); 
			
			while(resultSet.next()) {
				int vNo = resultSet.getInt("vNo"); 
				vId = resultSet.getString("vId");
				String vNickName = resultSet.getString("vNickName");
				String vSubject = resultSet.getString("vSubject"); 
				String vContent = resultSet.getString("vContent"); 
				Timestamp vDate = resultSet.getTimestamp("vDate"); 
				int vHit = resultSet.getInt("vHit"); 
				int vCommentCount = resultSet.getInt("vCommentCount");
				int vGroup = resultSet.getInt("vGroup"); 
				int vStep = resultSet.getInt("vStep"); 
				int vIndent = resultSet.getInt("vIndent"); 
				VVO MemberVbbsVVO = new VVO(vNo, vId, vNickName, vSubject, vContent, vDate, vHit, vCommentCount, vGroup, vStep, vIndent); 
				MemberListVVO.add(MemberVbbsVVO); 
			} 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} finally { 
			closeDB(); 
		}
		return MemberListVVO;
	}
	
	/*					게시글 작성					*/
	public void bbsWrite(final String vId, final String vNickName, final String vSubject, final String vContent) {
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String bbsWriteSql = "INSERT INTO virtual_bbs(vNo,vId, vNickName, vSubject, vContent, vHit, vGroup, vStep, vIndent) VALUES(seq_Vbbs.nextval,?, ?, ?, ?, 0, seq_Vbbs.currval, 0, 0)";
				PreparedStatement preparedStatement = conn.prepareStatement(bbsWriteSql);
				preparedStatement.setString(1, vId);
				preparedStatement.setString(2, vNickName);
				preparedStatement.setString(3, vSubject);
				preparedStatement.setString(4, vContent);
				return preparedStatement;
			}
		}); 
	} //write
	
	/*					게시글 보기					*/
	public VVO contentView(String vbbsNo) {
		addHit(vbbsNo);
		String bbsContentSql = "SELECT * from virtual_bbs WHERE vNo = " + vbbsNo;
		RowMapper<VVO> rm = new BeanPropertyRowMapper<VVO>(VVO.class);
		
		return this.template.queryForObject(bbsContentSql, rm);
	} // contentView()
	
	/*					게시글 수정					*/
	public VVO bbsModifyForm(String vbbsNo, String vId) {
		String bbsModifyFormSql = "SELECT * from virtual_bbs WHERE vNo = " + vbbsNo;
		RowMapper<VVO> bbsModifyForm = new BeanPropertyRowMapper<VVO>(VVO.class);
		
		return this.template.queryForObject(bbsModifyFormSql, bbsModifyForm);
	}
	
	public void bbsModify(final String vNo, final String vId, final String vSubject, final String vContent) {
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String ModifySql = "UPDATE virtual_bbs SET vContent = ?, vSubject = ? WHERE vNo = ? AND vId = ?";
				PreparedStatement preparedStatement = conn.prepareStatement(ModifySql);
				preparedStatement.setString(1, vContent);
				preparedStatement.setString(2, vSubject);
				preparedStatement.setInt(3, Integer.parseInt(vNo));
				preparedStatement.setString(4, vId);
				return preparedStatement;
			}
		});
	} // modify()
	
	/*					게시글 삭제					*/
	public void bbsDelete(final String vNo, final String vId) {
		String bbsDeleteSql = "DELETE FROM virtual_bbs WHERE vNo = ? AND vId = ?";
		this.template.update(bbsDeleteSql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,Integer.parseInt(vNo));
				ps.setString(2, vId);
			}
		});
	} // delete()
	
	/*					게시글 답변					*/
	public VVO replyForm(String vbbsNo) {
		String sql = "SELECT * FROM virtual_bbs WHERE vNo = " + vbbsNo;
		return this.template.queryForObject(sql, new BeanPropertyRowMapper<VVO>(VVO.class));
		
	} //replyForm()
	
	public void bbsReplyOk(String vNo, final String vId, final String vNickName, final String vSubject, final String vContent, final String vGroup, final String vStep, final String vIndent) {
		bbsReplySet(vGroup, vStep);
		String bbsReplySql = "INSERT INTO virtual_bbs (vNo, vId, vNickName, vSubject, vContent, vGroup, vStep, vIndent)"
				+ "VALUES(seq_Vbbs.nextval, ?, ?, ?, ?, ?, ?, ?)";
		this.template.update(bbsReplySql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vId);
				ps.setString(2, vNickName);
				ps.setString(3, vSubject);
				ps.setString(4, vContent);
				ps.setInt(5, Integer.parseInt(vGroup));
				ps.setInt(6, Integer.parseInt(vStep)+1);
				ps.setInt(7, Integer.parseInt(vIndent)+1);
			}
		});
	} // replyOk()
	
	public void bbsReplySet(final String vGroup, final String vStep) {
		String sql = "UPDATE virtual_bbs SET vStep = vStep+1 WHERE vGroup = ? AND vStep>?";
		this.template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(vGroup));
				ps.setInt(2, Integer.parseInt(vStep));
			}
		});
	} // replySet()
	
	
	
	
		
	/*					댓글					*/
	
	/*					댓글 작성					*/	
	public void bbsCommentWrite(final String vNo, final String vCommentContent, final String vId, final String vNickName) {
		addCommentCnt(vNo);
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String bbsCommentSql = "INSERT INTO virtual_bbs_comment(vCommentNo, vNo, vCommentContent, vId, vNickName, vCommentGroup, vCommentStep, vCommentIndent) VALUES(comment_seq.nextval, ?, ?, ?, ?,comment_seq.currval, 0, 0)";
				PreparedStatement preparedStatement = conn.prepareStatement(bbsCommentSql);
				preparedStatement.setInt(1, Integer.parseInt(vNo));
				preparedStatement.setString(2, vCommentContent);
				preparedStatement.setString(3, vId);
				preparedStatement.setString(4, vNickName);
				System.out.println("vNo" + vNo);
				return preparedStatement;
			}
		});
	} // bbsCommentWrite

	/*					댓글 수정					*/
	public void bbsCommentModify(final String vCommentContent, final Timestamp vUpdateDate, final String vCommentNo, final String vId) {
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String bbsCommentModifySql = "UPDATE virtual_bbs_comment SET vCommentContent = ?, vUpdateDate = ? WHERE vCommentNo = ? AND vId = ?";
				PreparedStatement preparedStatement = conn.prepareStatement(bbsCommentModifySql);
				preparedStatement.setString(1, vCommentContent);
				preparedStatement.setTimestamp(2, vUpdateDate);
				preparedStatement.setInt(3, Integer.parseInt(vCommentNo));
				preparedStatement.setString(4, vId);
				return preparedStatement;
			}
		});
	}
	
	/*					댓글 조회 					*/
	public ArrayList<VVO> bbsCommentSelect(String vvCommentNo) {
		ArrayList<VVO> bbsCommentListVVO = new ArrayList<VVO>();
		try {
			conn = getConnection();
			String bbsCommentListSql = "SELECT * FROM virtual_bbs_comment WHERE vCommentNo = ?";
			preparedStatement = conn.prepareStatement(bbsCommentListSql);
			preparedStatement.setInt(1, Integer.parseInt(vvCommentNo));
			resultSet = preparedStatement.executeQuery(); 
			
			while(resultSet.next()) {
				int vCommentNo = resultSet.getInt("vCommentNo");
				String vCommentContent = resultSet.getString("vCommentContent");
				String vId = resultSet.getString("vId");
				String vNickName = resultSet.getString("vNickName");
				Timestamp vCommentDate = resultSet.getTimestamp("vCommentDate");
				Timestamp vUpdateDate = resultSet.getTimestamp("vUpdateDate");
				int vCommentGroup = resultSet.getInt("vCommentGroup");
				int vCommentStep = resultSet.getInt("vCommentStep");
				int vCommentIndent = resultSet.getInt("vCommentIndent");
				VVO CommentVVO = new VVO(vCommentNo, vCommentContent, vId, vNickName, vCommentDate, vUpdateDate, vCommentGroup, vCommentStep, vCommentIndent);
				bbsCommentListVVO.add(CommentVVO); 
			} 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} finally { 
			closeDB(); 
		}
		return bbsCommentListVVO;
	}
	
	/*					댓글 답변					*/
	public VVO bbsCommentreplyForm(String vCommentNo) {
		String sql = "SELECT * FROM virtual_bbs_comment WHERE vCommentNo = " + vCommentNo;
		return this.template.queryForObject(sql, new BeanPropertyRowMapper<VVO>(VVO.class));
		
	} //replyForm()
	
	public void bbsCommentReplyOk(final String vCommentNo, final String vNo, final String vId, final String vNickName, final String vCommentContent, final String vCommentGroup, final String vCommentStep, final String vCommentIndent) {
		addCommentCnt(vNo);
		bbsCommentReplySet(vCommentGroup, vCommentStep);
		String bbsCommentReplySql = "INSERT INTO virtual_bbs_comment (vCommentNo, vNo, vId, vNickName, vCommentContent, vCommentGroup, vCommentStep, vCommentIndent)"
				+ "VALUES(seq_Vbbs.nextval, ?, ?, ?, ?, ?, ?, ?)";
		this.template.update(bbsCommentReplySql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(vNo));
				ps.setString(2, vId);
				ps.setString(3, vNickName);
				ps.setString(4, vCommentContent);
				ps.setInt(5, Integer.parseInt(vCommentGroup));
				ps.setInt(6, Integer.parseInt(vCommentStep)+1);
				ps.setInt(7, Integer.parseInt(vCommentIndent)+1);
			}
		});
	} // replyOk()
	
	public void bbsCommentReplySet(final String vCommentGroup, final String vCommentStep) {
		String bbsCommentReplySetsql = "UPDATE virtual_bbs_comment SET vCommentStep = vCommentStep+1 WHERE vCommentGroup = ? AND vCommentStep>?";
		this.template.update(bbsCommentReplySetsql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(vCommentGroup));
				ps.setInt(2, Integer.parseInt(vCommentStep));
			}
		});
	} // replySet()
	
	/*					댓글 삭제					*/
	public void bbsCommentDelete(final String vNo, final String vCommentNo, final String vId) {
		minusCommentCnt(vNo);
		String bbsCommentDeleteSql = "DELETE FROM virtual_bbs_comment WHERE vCommentNo = ? AND vId = ?";
		this.template.update(bbsCommentDeleteSql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,Integer.parseInt(vCommentNo));
				ps.setString(2, vId);
			}
		});
	}

	/*					댓글 목록 불러오기					*/
	public ArrayList<VVO> CommentList(String vNo){
		ArrayList<VVO> CommentListVVO = new ArrayList<VVO>();
		try {
			conn = getConnection();
			String bbsCommentListSql = "SELECT * FROM virtual_bbs_comment WHERE vNo = ? ORDER BY vCommentGroup DESC, vCommentStep ASC";
			preparedStatement = conn.prepareStatement(bbsCommentListSql);
			preparedStatement.setInt(1, Integer.parseInt(vNo));
			resultSet = preparedStatement.executeQuery(); 
			
			while(resultSet.next()) {
				int vCommentNo = resultSet.getInt("vCommentNo");
				String vCommentContent = resultSet.getString("vCommentContent");
				String vId = resultSet.getString("vId");
				String vNickName = resultSet.getString("vNickName");
				Timestamp vCommentDate = resultSet.getTimestamp("vCommentDate");
				Timestamp vUpdateDate = resultSet.getTimestamp("vUpdateDate");
				int vCommentGroup = resultSet.getInt("vCommentGroup");
				int vCommentStep = resultSet.getInt("vCommentStep");
				int vCommentIndent = resultSet.getInt("vCommentIndent");
				VVO CommentVVO = new VVO(vCommentNo, vCommentContent, vId, vNickName, vCommentDate, vUpdateDate, vCommentGroup, vCommentStep, vCommentIndent);
				CommentListVVO.add(CommentVVO); 
			} 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} finally { 
			closeDB(); 
		}
		return CommentListVVO;
	}
	
	/*					특정 멤버 댓글 목록 불러오기					*/
	public ArrayList<VVO> CommentMember(String vId, int startIndex, int pageSize){
		ArrayList<VVO> CommentMemberListVVO = new ArrayList<VVO>();
		try {
			conn = getConnection();
			String bbsCommentListSql = "SELECT virtual_bbs_comment.* FROM( SELECT virtual_bbs_comment.* FROM virtual_bbs_comment WHERE vId = ? ORDER BY vCommentNo DESC) virtual_bbs_comment OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
			preparedStatement = conn.prepareStatement(bbsCommentListSql);
			preparedStatement.setString(1, vId);
			preparedStatement.setInt(2, startIndex); 
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery(); 
			
			while(resultSet.next()) {
				int vNo = resultSet.getInt("vNo");
				int vCommentNo = resultSet.getInt("vCommentNo");
				String vCommentContent = resultSet.getString("vCommentContent");
				vId = resultSet.getString("vId");
				String vNickName = resultSet.getString("vNickName");
				Timestamp vCommentDate = resultSet.getTimestamp("vCommentDate");
				Timestamp vUpdateDate = resultSet.getTimestamp("vUpdateDate");
				VVO CommentMemberVVO = new VVO(vNo,vCommentNo, vCommentContent, vId, vNickName, vCommentDate, vUpdateDate);
				CommentMemberListVVO.add(CommentMemberVVO); 
			} 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} finally { 
			closeDB(); 
		}
		return CommentMemberListVVO;
	}
	
	
	
	
	
	/*		개별 소스 조회 소스			*/
	
	/*		멤버 아이디 조회 소스			*/
	public String MemberId(String vId) {
		String user = ""; 
		try {
			conn = getConnection();
			String memberIdSql = "SELECT vId FROM virtual_member WHERE vId = ?";
			preparedStatement = conn.prepareStatement(memberIdSql);
			preparedStatement.setString(1, vId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = resultSet.getString("vId");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return user;
	}
	public String MemberId(HttpServletResponse response , String vId) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user = MemberId(vId);
		String answer = "";
	      char[] charList = user.toCharArray();
	      for(int i = ((int)Math.ceil((double)(user.length()) * 0.6 ))-1; i < user.length(); i++ ){
	          charList[i]='*';
	      }
	      answer = new String(charList);
	      
		if(answer.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('게시글이 존재하지 않습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return answer;
		}
	}
	
	/*			멤버 닉네임 조회 소스		*/
	public String MemberNickName(String vId) {
		String MemberNickName = ""; 
		try {
			conn = getConnection();
			String memberIdSql = "SELECT vNickName FROM virtual_member WHERE vId = ?";
			preparedStatement = conn.prepareStatement(memberIdSql);
			preparedStatement.setString(1, vId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				MemberNickName = resultSet.getString("vNickName");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return MemberNickName;
	}
	public String MemberNickName(HttpServletResponse response , String vId) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String MemberNickName = MemberNickName(vId);
		if(MemberNickName.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('게시글이 존재하지 않습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return MemberNickName;
		}
	}
	
	/*					멤버 정보					*/
	public ArrayList<VVO> Member(){
		ArrayList<VVO> vMember = new ArrayList<VVO>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String userId = user.getUsername();
		try {
			conn = getConnection();
			String telIdFindsql = "SELECT * FROM virtual_member WHERE vId=?";
			preparedStatement = conn.prepareStatement(telIdFindsql);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String vId = resultSet.getString("vId");
				String vNickName = resultSet.getString("vNickName");
				String vName = resultSet.getString("vName");
				String vBirth1 = resultSet.getString("vBirth");
				String vGender = resultSet.getString("vGender");
				String vEmail = resultSet.getString("vEmail");
				String vTel1 = resultSet.getString("vTel");
				String vPostCode = resultSet.getString("vPostCode");
				String vAddress1 = resultSet.getString("vAddress1");
				String vAddress2 = resultSet.getString("vAddress2");
				Timestamp vDate = resultSet.getTimestamp("vDate");				
				Timestamp vMemberModificationDate = resultSet.getTimestamp("vMemberModificationDate");
				
				VVO vvo = new VVO(vId, vNickName, vName, vBirth1, vGender, vEmail, vTel1, vPostCode, vAddress1, vAddress2, vDate, vMemberModificationDate);
				vMember.add(vvo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return vMember;
	}
	public List<VVO> Member(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<VVO> vMember = Member();
		if(vMember.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('회원정보가 존재하지 않습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return vMember;
		}
	}
	
	/*					로그인 유저 닉네임 조회 소스					*/
	public String NickName() {
		String NickName = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String userId = user.getUsername();
		try {
			conn = getConnection();
			String NickNameSql = "SELECT vNickName FROM virtual_Member WHERE vId=?";
			preparedStatement = conn.prepareStatement(NickNameSql);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				 NickName = resultSet.getString("vNickName");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return NickName;
	} 
	public String NickName(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String NickName = NickName();
		if(NickName.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('회원정보가 존재하지 않습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return NickName;
		}
	}
	
	/*					게시글 제목					*/
	public String titleSubject(String vbbsNo, String vSubject) {
		String title = "";
		try {
			conn = getConnection();
			String titleSubjectSql = "SELECT vSubject FROM virtual_bbs WHERE vNo=" + vbbsNo;
			preparedStatement = conn.prepareStatement(titleSubjectSql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				title = resultSet.getString("vSubject");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return title;
	}
	public String titleSubject(HttpServletResponse response , String vbbsNo, String vSubject) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String title = titleSubject(vbbsNo, vSubject);
		if(title.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('게시글이 존재하지 않습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return title;
		}
	}
	
	/*					게시글 작성자 댓글 작성자 동일					*/
	public String bbsWriter(String vNo) {
		String Writer = "";
		try {
			conn = getConnection();
			String WriterSql = "SELECT vId FROM virtual_bbs WHERE vNo = ?";
			preparedStatement = conn.prepareStatement(WriterSql);
			preparedStatement.setString(1, vNo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				 Writer = resultSet.getString("vId");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return Writer;
	}
	public String bbsWriter(String vNo, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String Writer = bbsWriter(vNo);
		if(Writer.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('회원정보가 존재하지 않습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return Writer;
		}
	}
	
	/*					댓글 번호					*/
	public String CommentVNo(String vbbsNo) {
		String Number = "";
		try {
			conn = getConnection();
			String CommentVNotSql = "SELECT vNo FROM virtual_bbs WHERE vNo=" + vbbsNo;
			preparedStatement = conn.prepareStatement(CommentVNotSql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Number = resultSet.getString("vNo");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return Number;
	}
	public String CommentVNo(HttpServletResponse response , String vbbsNo) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String Number = CommentVNo(vbbsNo);
		System.out.println("dao vNo = " + Number);
		if(Number.isEmpty()) {
			out.println("<script language='javascript'>");
			out.println("alert('게시글이 존재하지 않습니다.');");
			out.println("</script>");
			out.flush();
			return null;
		}
		else {
			return Number;
		}
	}
	
	
	
	
		
	/*			토탈  조회 소스		*/
	
	/*					게시글 총 수					*/
	public int totalListCnt(){
	    int total = 0; 
	    try {
	    	conn = getConnection();
	    	String CountSql = "select count(*) from virtual_bbs";
	    	preparedStatement = conn.prepareStatement(CountSql);
	    	resultSet = preparedStatement.executeQuery();
	    	if(resultSet.next()){
	    		total = resultSet.getInt(1);
	    	}
	    } catch (Exception e){
	      e.printStackTrace();
	    } finally {
	    	closeDB();
	    }
	    return total;
	}
	
	/*					댓글 총 수					*/
	public int CommentTotal(String vNo) {
		int CommentTotalCnt = 0;
		try {
			conn = getConnection();
			String CommentTotalSql = "SELECT COUNT(*) FROM virtual_bbs_comment WHERE vNo=?";
			preparedStatement = conn.prepareStatement(CommentTotalSql);
			preparedStatement.setInt(1, Integer.parseInt(vNo));
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				CommentTotalCnt = resultSet.getInt(1);
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return CommentTotalCnt;
	}
	
	/*					특정 멤버 댓글 총 수					*/
	public int CommentMemberTotal(String vId) {
		int CommentMemberTotalCnt = 0;
		try {
			conn = getConnection();
			String CommentMemberTotalSql = "SELECT COUNT(*) FROM virtual_bbs_comment WHERE vId=?";
			preparedStatement = conn.prepareStatement(CommentMemberTotalSql);
			preparedStatement.setString(1, vId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				CommentMemberTotalCnt = resultSet.getInt(1);
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return CommentMemberTotalCnt;
	}
	
	/*					로그인 멤버 게시글 총 수					*/
	public int userBBSList() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String userId = user.getUsername();
		int userTotal = 0;
		try {
			conn = getConnection();
			String userBBSListSql = "SELECT count(*) FROM virtual_bbs WHERE vId=?";
			preparedStatement = conn.prepareStatement(userBBSListSql);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				 userTotal = resultSet.getInt(1);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return userTotal;
	}
	
	/*					로그인 유저 댓글 토탈 조회 소스					*/
	public int userCommentCount() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String userId = user.getUsername();
		int userCommentTotal = 0;
		try {
			conn = getConnection();
			String userCommentCounttSql = "SELECT count(*) FROM virtual_bbs_comment WHERE vId=?";
			preparedStatement = conn.prepareStatement(userCommentCounttSql);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				userCommentTotal = resultSet.getInt(1);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return userCommentTotal;
	}
	
	/*					특정 멤버 게시글 총 수					*/
	public int MemberBBSList(String vId) {
		int MemberTotal = 0;
		try {
			conn = getConnection();
			String userBBSListSql = "SELECT count(*) FROM virtual_bbs WHERE vId = ?";
			preparedStatement = conn.prepareStatement(userBBSListSql);
			preparedStatement.setString(1, vId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				 MemberTotal = resultSet.getInt(1);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return MemberTotal;
	}
	
	
	
	
	
	/*					add 함수					*/
	
	/*					조회수 add					*/
	private void addHit(final String vNo) {
		String addHitSql = "update virtual_bbs set vHit = vHit + 1 where vNo = ?";
		this.template.update(addHitSql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(vNo));
			}
		});
	} // addHit()
	
	/*					게시글의 댓글 수 add					*/
	private void addCommentCnt(final String vNo) {
		String addCommentCntSql = "update virtual_bbs set vCommentCount = vCommentCount + 1 where vNo = ?";
		this.template.update(addCommentCntSql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(vNo));
			}
		});
	}
	
	/*					게시글의 댓글 수 minus					*/
	private void minusCommentCnt(final String vNo){
		String addCommentCntSql = "update virtual_bbs set vCommentCount = vCommentCount - 1 where vNo = ?";
		this.template.update(addCommentCntSql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(vNo));
			}
		});
	}
	
}




/*					other 소스					*/

//	public ArrayList<VVO> Comment(String vNo, int startIndex, int pageSize){
//		ArrayList<VVO> CommentListVVO = new ArrayList<VVO>();
//		try {
//			conn = getConnection();
//			String bbsCommentListSql = "SELECT virtual_bbs_comment.* FROM( SELECT virtual_bbs_comment.* FROM virtual_bbs_comment WHERE vNo = ? ORDER BY vCommentNo DESC) virtual_bbs_comment OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
//			preparedStatement = conn.prepareStatement(bbsCommentListSql);
//			preparedStatement.setInt(1, Integer.parseInt(vNo));
//			preparedStatement.setInt(2, startIndex); 
//			preparedStatement.setInt(3, pageSize);
//			resultSet = preparedStatement.executeQuery(); 
//			
//			while(resultSet.next()) {
//				int vCommentNo = resultSet.getInt("vCommentNo");
//				String vCommentContent = resultSet.getString("vCommentContent");
//				String vId = resultSet.getString("vId");
//				String vNickName = resultSet.getString("vNickName");
//				Timestamp vCommentDate = resultSet.getTimestamp("vCommentDate");
//				Timestamp vUpdateDate = resultSet.getTimestamp("vUpdateDate");
//				VVO CommentVVO = new VVO(vCommentNo, vCommentContent, vId, vNickName, vCommentDate, vUpdateDate);
//				CommentListVVO.add(CommentVVO); 
//			} 
//		} catch(Exception e) { 
//			e.printStackTrace(); 
//		} finally { 
//			closeDB(); 
//		}
//		return CommentListVVO;
//	}