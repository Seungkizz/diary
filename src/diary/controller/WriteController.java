package diary.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.dao.DiaryDao;
import diary.dao.DiaryDaoImpl;
import diary.dto.Diary;

@WebServlet("/write")
public class WriteController extends HttpServlet{
	
	DiaryDao diaryDao = new DiaryDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("PostController post >>> ");
		Diary diary = new Diary();
		diary.setDirarymemberId(request.getParameter("dirarymemberId"));
		diary.setTitle(request.getParameter("title"));
		diary.setContent(request.getParameter("content"));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = sdf.format(date);
		diary.setDate(dateString);
		System.out.println(diary);
		String contextPath = request.getContextPath();
		String path = "";
		try {
			int result = diaryDao.insert(diary);
			System.out.println("작성완료" + result);
			path = contextPath + "/view";
			response.sendRedirect(path);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}
	
}
