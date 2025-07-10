package org.kosa.myproject.controller;

import java.io.IOException;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlePracticeVer1
 */
@WebServlet("/FrontControllerServlePracticeVer1")
public class FrontControllerServlePracticeVer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String requestType = request.getParameter("requestType");
		if(requestType!=null&&requestType.equals("findbyid")) {
			String id = request.getParameter("customerId");
			CustomerVo customer = MockDao.getInstance().findCustomerById(id);
			if(customer!=null) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("findbyid-ok.jsp").forward(request, response);
			}else {
				response.sendRedirect("findbyid-fail.jsp");
			}
		}else if(requestType!=null&&requestType.equals("registerCustomer")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			MockDao.getInstance().registerCustomer(new CustomerVo(id,name,address));
			response.sendRedirect("register-result.jsp");
		}
		
		
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doDispatch(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doDispatch(request, response);
	}

}
