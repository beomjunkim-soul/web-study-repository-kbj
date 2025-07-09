package org.kosa.myproject.controller;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 * Command 디자인 패턴 : 클라이언트의 요청 처리를 담당하는 객체
 */
public class FindCustomerByIdController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("customerId");
		CustomerVo customer = MockDao.getInstance().findCustomerById(id);
		String path = null;
		if(customer==null) {
			path = "findbyid-fail.jsp";
			request.setAttribute("customer", customer);
		}
		else {
			path = "findbyid-ok.jsp";
			
		}
		return path;
	}

}
