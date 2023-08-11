package diarymember.dao;

import java.sql.SQLException;
import java.util.List;

import diarymember.dto.DiaryMember;

public interface DiaryMemberDao {

	int insert(DiaryMember diaryMember) throws SQLException;

	DiaryMember login(DiaryMember diaryMember) throws SQLException;

	boolean checkid(String diraryMemberId) throws SQLException;

	List<DiaryMember> selectDiaryMemberInfo(String id) throws SQLException;


}
