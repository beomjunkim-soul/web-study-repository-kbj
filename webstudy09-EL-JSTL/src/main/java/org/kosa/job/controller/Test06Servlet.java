package org.kosa.job.controller;

import java.io.IOException;
import java.util.List;

import org.kosa.job.model.MemberDao;
import org.kosa.job.model.MemberVo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Test06Servlet")
public class Test06Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			MemberDao dao = new MemberDao();
			MemberVo vo = dao.findMemberById(id);
			request.setAttribute("member", vo);
			request.getRequestDispatcher("step6-practice-id-list.jsp").forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
