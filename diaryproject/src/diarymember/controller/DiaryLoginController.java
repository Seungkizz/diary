package diarymember.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diarymember.dao.DiaryMemberDao;
import diarymember.dao.DiaryMemberDaoImpl;
import diarymember.dto.DiaryMember;


@WebServlet("/login")
public class DiaryLoginController extends HttpServlet {

	DiaryMemberDao diaryDao = new DiaryMemberDaoImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("LoginController >> post >>");
		DiaryMember dm = new DiaryMember();
		dm.setDiraryMemberId(request.getParameter("diraryMemberId"));
		dm.setPassword(request.getParameter("password"));
		
		try {
			DiaryMember diaryMember = diaryDao.login(dm);
			String path = null;
			if(diaryMember != null) {
				HttpSession session = request.getSession(false);
				session.setAttribute("auth", diaryMember);
				//request.setAttribute("success", memberInfo);
				path = "index.jsp";
				
			}else {
				request.setAttribute("fail", dm);
				path = "diaryMember/loginForm.jsp";
				
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
