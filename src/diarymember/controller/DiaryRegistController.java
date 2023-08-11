package diarymember.controller;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/regist")
public class DiaryRegistController extends HttpServlet {

	DiaryMemberDao diaryDao = new DiaryMemberDaoImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		System.out.println("RegistController post >>> ");
		String diraryMemberId = request.getParameter("diraryMemberId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		System.out.println("Member ID: " + diraryMemberId);

		try {
			// Check if the member ID already exists
			if (diaryDao.checkid(diraryMemberId)) {
				System.out.println("중복된 아이디입니다.");
				// Set an error message
				request.setAttribute("errorMessage", "중복된 아이디입니다.");
				request.setAttribute("errorid", diraryMemberId);
				// Forward the request to the registration form
				RequestDispatcher dispatcher = request.getRequestDispatcher("/diaryMember/registForm.jsp");
				dispatcher.forward(request, response);
			} else {
				// Create a new DiaryMember object
				DiaryMember diaryMember = new DiaryMember();
				diaryMember.setDiraryMemberId(diraryMemberId);
				diaryMember.setPassword(password);
				diaryMember.setName(name);

				// Insert the DiaryMember object into the database
				int result = diaryDao.insert(diaryMember);
				System.out.println("회원가입 성공");
				response.sendRedirect("index.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
