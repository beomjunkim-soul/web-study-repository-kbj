package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//HTML을 브라우저로 전송하기 위한 출력 스트림
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Set Cookie Study</title>");
		out.println("</head>");
		out.println("<body bgcolor=yellow>");
		out.println("<h3>Set Cookie Study</h3>");
		String time = new Date().toString().replace(" ", "-");
		Cookie cookie = new Cookie("timeCookie", time);//공란이 들어가면 안된다 
		cookie.setMaxAge(60); // N초 동안 유지
		response.addCookie(cookie); // 응답시 쿠키가 전송되도록 한다
		out.println("cookie를 생성해 클라이언트에 전송<br><br>");
		out.println("<br><br><a href=index.html>home으로<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	
}
