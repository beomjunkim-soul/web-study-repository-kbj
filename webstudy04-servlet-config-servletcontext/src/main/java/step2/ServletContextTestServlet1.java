package step2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTestServlet1
 */
@WebServlet("/context-test1")
public class ServletContextTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//HTML을 브라우저로 전송하기 위한 출력 스트림
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ServletConext Study1</title>");
		out.println("</head>");
		out.println("<body bgcolor=yellow>");
		String securityInfo = this.getServletConfig().getServletContext().getInitParameter("securityConfigInfo");
		out.println("<h3>Hello Servlet</h3>");
		out.println("ServletContext의 securityInfo: "+securityInfo);
		/***************ServletContextListener 에서 할당한 보안 정보를 반환*******************/
		String securityRoleInfo=this.getServletConfig().getServletContext().getAttribute("securityRoleInfo").toString();
		out.println("<br><br><strong>"+securityRoleInfo+"</strong>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
