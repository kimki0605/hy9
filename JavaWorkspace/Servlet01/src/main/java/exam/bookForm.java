package exam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bookForm
 */
@WebServlet("/bookForm")
public class bookForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public bookForm() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		System.out.println("init 메서드 호출");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		response.getWriter().append("도서 정보를 등록해주세요.");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");

		// HTML에서 입력한 데이터 받기
		String bookNo = request.getParameter("bookNo");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPrice = request.getParameter("bookPrice");
		String bookDate = request.getParameter("bookDate");
		String bookStock = request.getParameter("bookStock");
		String publisherNo = request.getParameter("publisherNo");

		// Console 출력
		System.out.println("도서번호 : " + bookNo);
		System.out.println("도서명 : " + bookName);
		System.out.println("저자 : " + bookAuthor);
		System.out.println("가격 : " + bookPrice);
		System.out.println("발행일 : " + bookDate);
		System.out.println("재고 : " + bookStock);
		System.out.println("출판사번호 : " + publisherNo);

		// 브라우저 출력
		response.setContentType("text/html;charset=UTF-8");

		response.getWriter().println("<h2>도서 정보 등록 완료</h2>");
		response.getWriter().println("도서번호 : " + bookNo + "<br>");
		response.getWriter().println("도서명 : " + bookName + "<br>");
		response.getWriter().println("저자 : " + bookAuthor + "<br>");
		response.getWriter().println("가격 : " + bookPrice + "<br>");
		response.getWriter().println("발행일 : " + bookDate + "<br>");
		response.getWriter().println("재고 : " + bookStock + "<br>");
		response.getWriter().println("출판사번호 : " + publisherNo + "<br>");
	}

}