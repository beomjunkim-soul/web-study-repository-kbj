package org.kosa.myproject.controller;

import java.util.List;

import org.kosa.myproject.model.MemberDao;
import org.kosa.myproject.model.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindMemberListByAddressController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String address = request.getParameter("memberAddress");
		List<MemberVo> list = (List<MemberVo>) MemberDao.getInstance().findMemberListByAddress(address);
		request.setAttribute("memberList", list);
		return "member-list.jsp";
	}

}
