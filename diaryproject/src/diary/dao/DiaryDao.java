package diary.dao;

import java.sql.SQLException;
import java.util.List;

import diary.dto.Diary;
import diary.dto.DiaryCommand;

public interface DiaryDao {

	//글쓰기
	int insert(Diary diary) throws SQLException;

	// 수정하려는 글 찾아서 폼에 뿌려주기 위한 select
	List<DiaryCommand> selectModify(String diaryid) throws SQLException;

	// 글 수정
	int modify(Diary diary) throws SQLException;

	//글 삭제
	void deletediary(String diaryid) throws SQLException;

	// 글 쓴 사람 전체 글수
	int countDiaries(String id) throws SQLException;

	// 글 보여주기 
	List<DiaryCommand> selectDiaries(String id, int page, int entriesPerPage) throws SQLException;


}
