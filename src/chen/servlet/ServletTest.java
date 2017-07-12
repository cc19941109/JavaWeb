package chen.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletConfig config;

	/**
	 * 当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
	 * 会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，
	 * 将ServletConfig对象传递给servlet。进而，程序员通过ServletConfig对象就可以
	 * 得到当前servlet的初始化参数信息。
	 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

	public ServletTest() {
		super();
		System.out.println("init++++  ");
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * 一个WEB应用中的所有Servlet共享同一个ServletContext对象，
		 * 因此Servlet对象之间可以通过ServletContext对象来实现通讯。
		 * ServletContext对象通常也被称之为context域对象
		 */
		String paramVal = this.config.getInitParameter("name");// 获取指定的初始化参数
		response.getWriter().print(paramVal);

		response.getWriter().print("<hr/>");
		// 获取所有的初始化参数
		Enumeration<String> e = config.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = config.getInitParameter(name);
			response.getWriter().print(name + "=" + value + "<br/>");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n hello world");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		response.getWriter().print("<hr/>");
		if(headerNames.hasMoreElements()){
			response.getWriter().println(headerNames.nextElement());
		}
		response.getWriter().print("<hr/>");
		response.getWriter().println(request.getHeader("accept"));
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
