package org.kosa.myproject.controller;

import org.kosa.myproject.model.CustomerVo;
import org.kosa.myproject.model.MockDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Command Pattern : 요청(명령)처리를 전담하는 객체
 */
public class UpdateCustomerController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id =request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MockDao.getInstance().updateCustomer(new CustomerVo(id,name,address));
		return "redirect:update-result.jsp";
	}

}