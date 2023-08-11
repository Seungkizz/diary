package diarymember.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import diarymember.dto.DiaryMember;

public class DiaryMemberDaoImpl implements DiaryMemberDao {

	Connection conn;

	public DiaryMemberDaoImpl() {
		try {
			// 커넥션 풀에서 커넥션 꺼냄
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jsp");

			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(DiaryMember diaryMember) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "insert into dirarymember value(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, diaryMember.getDiraryMemberId());
		pstmt.setString(2, diaryMember.getPassword());
		pstmt.setString(3, diaryMember.getName());

		return pstmt.executeUpdate();
	}

	@Override
	public  DiaryMember login(DiaryMember loginDiaryMember) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dirarymember where dirarymemberId = ? and password =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginDiaryMember.getDiraryMemberId());
		pstmt.setString(2, loginDiaryMember.getPassword());

		rs = pstmt.executeQuery();
		DiaryMember diaryMember = null;
		if (rs.next()) {
			diaryMember = new DiaryMember();
			diaryMember.setDiraryMemberId(rs.getString("diraryMemberId"));
			diaryMember.setPassword(rs.getString("password"));
			diaryMember.setName(rs.getString("name"));
		}
		return diaryMember;
	}

	// 중복된 아이디 체크
	@Override
	public boolean checkid(String diraryMemberId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean exists = false;
		
		 String sql = "SELECT COUNT(*) FROM dirarymember WHERE dirarymemberId = ?";
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, diraryMemberId);
         rs = pstmt.executeQuery();
         
         if (rs.next()) {
             int count = rs.getInt(1);
             exists = (count > 0);
         }
		return exists;
	}

	@Override
	public List<DiaryMember> selectDiaryMemberInfo(String id) throws SQLException {
		List<DiaryMember> diaryMembers = new ArrayList<DiaryMember>();
		PreparedStatement pstmt = null;
		String sql ="select * from dirarymember where dirarymemberId = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			DiaryMember diaryMember = new DiaryMember();
			diaryMember.setDiraryMemberId(rs.getString("dirarymemberId"));
			diaryMember.setName(rs.getString("name"));
			diaryMember.setPassword(rs.getString("password"));
			diaryMembers.add(diaryMember);
		}
		return diaryMembers;
	}

}
