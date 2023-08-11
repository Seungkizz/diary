package diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import diary.dto.Diary;
import diary.dto.DiaryCommand;

public class DiaryDaoImpl implements DiaryDao {

	Connection conn;

	public DiaryDaoImpl() {
		try {
			// 커넥션 풀에서 커넥션 꺼냄
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jsp");

			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//글쓰기
	@Override
	public int insert(Diary diary) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "insert into diarypost(dirarymemberId, title, content,date) values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, diary.getDirarymemberId());
		pstmt.setString(2, diary.getTitle());
		pstmt.setString(3, diary.getContent());
		pstmt.setString(4, diary.getDate());

		return pstmt.executeUpdate();
	}

	// 수정하려는 글 찾아서 폼에 뿌려주기 위한 select
	@Override
	public List<DiaryCommand> selectModify(String diaryid) throws SQLException {
		List<DiaryCommand> diarylist = new ArrayList<DiaryCommand>();
		PreparedStatement pstmt = null;
		String sql = "select d.name,p.* from dirarymember d , diarypost p where d.dirarymemberId = p.dirarymemberId and diaryId = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, diaryid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			DiaryCommand diaryCommand = new DiaryCommand();
			Diary diary = new Diary();
			diary.setDiaryId(rs.getInt("diaryId"));
			diary.setDirarymemberId(rs.getString("dirarymemberId"));
			diary.setTitle(rs.getString("title"));
			diary.setContent(rs.getString("content"));
			diary.setDate(rs.getString("date"));
			diaryCommand.setDiary(diary);
			diaryCommand.setName(rs.getString("name"));
			diarylist.add(diaryCommand);
		}
		return diarylist;

	}

	// 글 수정
	@Override
	public int modify(Diary diary) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "update diarypost set title = ? , content = ? ,moddate = ? where diaryId = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, diary.getTitle());
		pstmt.setString(2, diary.getContent());
		pstmt.setString(3, diary.getModdate());
		pstmt.setLong(4, diary.getDiaryId());

		return pstmt.executeUpdate();
	}

	//글 삭제
	@Override
	public void deletediary(String diaryid) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "delete from diarypost where diaryId = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, diaryid);
		pstmt.executeUpdate();

	}

	// 글 쓴 사람 전체 글수
	@Override
	public int countDiaries(String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "SELECT COUNT(*) FROM diarypost WHERE dirarymemberId = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt(1);
		}

		return count;
	}

	// 글 보여주기 
	@Override
	public List<DiaryCommand> selectDiaries(String id, int page, int entriesPerPage) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DiaryCommand> diaryList = new ArrayList<>();

		String sql = "SELECT d.name, p.* FROM dirarymember d, diarypost p WHERE d.dirarymemberId = p.dirarymemberId AND d.dirarymemberId = ? ORDER BY p.date DESC LIMIT ?, ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setInt(2, (page - 1) * entriesPerPage);
		pstmt.setInt(3, entriesPerPage);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DiaryCommand diaryCommand = new DiaryCommand();
			Diary diary = new Diary();
			diary.setDiaryId(rs.getInt("diaryId"));
			diary.setDirarymemberId(rs.getString("dirarymemberId"));
			diary.setTitle(rs.getString("title"));
			diary.setContent(rs.getString("content"));
			diary.setDate(rs.getString("date"));
			diary.setModdate(rs.getString("moddate"));
			diaryCommand.setDiary(diary);
			diaryCommand.setName(rs.getString("name"));
			diaryList.add(diaryCommand);
		}

		return diaryList;
	}
}