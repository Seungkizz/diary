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

@WebServlet("/modify")
public class ModifyController extends HttpServlet {

	DiaryDao diaryDao = new DiaryDaoImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("PostController post >>> ");
		Diary diary = new Diary();

		diary.setDiaryId(Integer.parseInt(request.getParameter("diaryId")));
		diary.setTitle(request.getParameter("title"));
		diary.setContent(request.getParameter("content"));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = sdf.format(date);
		diary.setModdate(dateString);
		String contextPath = request.getContextPath();
		String path = "";
		try {
			int result = diaryDao.modify(diary);
			System.out.println("수정완료" + result);
			path = contextPath + "/view";
			response.sendRedirect(path);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
