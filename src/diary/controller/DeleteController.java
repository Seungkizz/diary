package diary.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.dao.DiaryDao;
import diary.dao.DiaryDaoImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	DiaryDao diaryDao = new DiaryDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String diaryid = request.getParameter("diaryId");
		String contextPath = request.getContextPath();
		String path = "";
		try {
			diaryDao.deletediary(diaryid);
			System.out.println("삭제완료");
			path = contextPath + "/view";
			response.sendRedirect(path);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
