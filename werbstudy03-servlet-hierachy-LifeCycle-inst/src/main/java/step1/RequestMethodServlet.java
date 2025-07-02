package step1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestMethodServlet
 */
@WebServlet("/RequestMethodServlet")
public class RequestMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestMethodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    //아래처럼 우리가 직접 service를 오버라이딩하면 톰캣(웹컨테이너)이 호출하는 것을 확인할 수 있다
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getRequestURI()+"service method 실행");
//	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
 
    	//응답시 컨텐트 타입을 설정, 브라우저에서 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
    			response.setContentType("text/html;charset=UTF-8");
    			//HTML을 브라우저로 전송하기 위한 출력 스트림
    			PrintWriter out = response.getWriter();
    			out.println("<html>");
    			out.println("<head>");
    			out.println("<title>Servlet Method Study</title>");
    			out.println("</head>");
    			out.println("<body bgcolor=yellow>");
    			String method = request.getMethod();
    			out.println("<h3>"+method+"방식 요청에 대한 응답</h3>");
    			
    			//클라이언트가 보낸 정보를 반환받는다
    			String info = request.getParameter("searchKeyword");
    			String str = null;
    			str.length();
    			out.println("<strong>검색어는"+info+"입니다</strong>");
    			out.println("</body>");
    			out.println("</html>");
    			out.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html;charset=UTF-8");
		//HTML을 브라우저로 전송하기 위한 출력 스트림
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Method Study</title>");
		out.println("</head>");
		out.println("<body bgcolor=lime>");
		String method = request.getMethod();
		out.println("<h3>"+method+"방식 요청에 대한 응답</h3>");
		
		//클라이언트가 보낸 정보를 반환받는다
		String foodName = request.getParameter("foodName");
		String foodType = request.getParameter("tasteType");
		out.println("<strong>음식명: "+foodName+"</strong><br>");
		out.println("<strong>음식타입: "+foodType+"</strong><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
    }

}
