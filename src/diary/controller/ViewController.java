package diary.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diary.dao.DiaryDao;
import diary.dao.DiaryDaoImpl;
import diary.dto.DiaryCommand;
import diarymember.dto.DiaryMember;

@WebServlet("/view")
public class ViewController extends HttpServlet {

	DiaryDao diaryDao = new DiaryDaoImpl();
	private static final int ENTRIES_PER_PAGE = 10; // 페이지당 표시할 일기 수

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

				int page = 1; // 기본 페이지 번호는 1
				if (request.getParameter("page") != null) {
					page = Integer.parseInt(request.getParameter("page"));
				}

				try {
					int totalCount = diaryDao.countDiaries(id); // 전체 일기 수
					int totalPages = (int) Math.ceil((double) totalCount / ENTRIES_PER_PAGE); // 전체 페이지 수

					List<DiaryCommand> diaryList = diaryDao.selectDiaries(id, page, ENTRIES_PER_PAGE);
					System.out.println(diaryList);
					request.setAttribute("list", diaryList);
					request.setAttribute("totalCount", totalCount);
					request.setAttribute("totalPages", totalPages);
					request.setAttribute("currentPage", page);

					path = "diary/viewsdiary.jsp";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		if (diaryMember == null) {
			path = "/diaryMember/loginForm.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}