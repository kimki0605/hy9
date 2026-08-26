package servlet01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://도메인:포트/context/파일명(매핑된 url)
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * service() 메서드에 자동으로 호출되는 메소드
	 * 메모리에 올라올 때 한 번 호출
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}

	/**
	 * 메모리에서 삭제 될 때 한 번 호출
	 * 서블릿 업데이트 되는 경우 destory 메소드 호출 하고 서블릿 업데이트 후 객체 생성
	 */
	public void destroy() {
		System.out.println("destory 메소드 호출 수정");
	}

	/**
	 * 클라이언트 요청 방식이 GET 방식일 때 호출되는 메소드
	 * service()메소드에 의해 호출 됨
	 * servic() : main()메소드의 역할, web container에 의해 자동 호출
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget 메소드 호출");
	}

}
