package diary.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.dao.DiaryDao;
import diary.dao.DiaryDaoImpl;
import diary.dto.DiaryCommand;

@WebServlet("/selectmodify")
public class SelectModifyController extends HttpServlet {
	DiaryDao diaryDao = new DiaryDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("wow");
		String diaryid = request.getParameter("diaryId");
		String path = "";
		try {
			List<DiaryCommand> diaryList = diaryDao.selectModify(diaryid);
			System.out.println("여긴왓니?");
			request.setAttribute("modify", diaryList);
			path = "diary/modifydiaryForm.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}
