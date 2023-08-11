package diarymember.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diarymember.dao.DiaryMemberDao;
import diarymember.dao.DiaryMemberDaoImpl;
import diarymember.dto.DiaryMember;

@WebServlet("/memberInfo")
public class DiaryMemberInfo extends HttpServlet {

	DiaryMemberDao diaryDao = new DiaryMemberDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiaryMember diaryMember = null;
		String id = null;
		String path = "";
		HttpSession session = request.getSession(false);

		if (session != null) {
			diaryMember = (DiaryMember) session.getAttribute("auth");
			if (diaryMember != null) {
				id = diaryMember.getDiraryMemberId();
				System.out.println(id);
				try {
					List<DiaryMember> diaryMembers = diaryDao.selectDiaryMemberInfo(id);
					System.out.println("diaryMembers >>>>"+diaryMembers);
					request.setAttribute("diaryMember", diaryMembers);
					path = "diaryMember/memberInfo.jsp";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}
}
