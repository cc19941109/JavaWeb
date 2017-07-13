package chen.communication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletConfig config;

	public Servlet1() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("-----init--1--");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data = "giraffe tree";
		/**
		 * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
		 * 可以通过ServletConfig.getServletContext方法获得ServletContext对象。
		 */
		ServletContext context = config.getServletContext();// 获得ServletContext对象
		context.setAttribute("data", data); // 将data存储到ServletContext对象中
		System.out.println("servlet1");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.getWriter().print("<hr/>");

		String contextInitParam = context.getInitParameter("age");
		response.getWriter().print(contextInitParam);
		// 用RequestDispatcher实现请求转发
		RequestDispatcher rd = context.getRequestDispatcher("/Servlet2");// 获取请求转发对象(RequestDispatcher)
		rd.forward(request, response);// 调用forward方法实现请求转发
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
