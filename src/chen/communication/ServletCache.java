package chen.communication;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * TODO 不知道缓存用来干嘛的
 * Servlet implementation class Servlet1
 */
@WebServlet("/ServletCache")
public class ServletCache extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

	public ServletCache() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("init 2=------");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = config.getServletContext();
		System.out.println("servlet2------------");

		String data = "abcddfwerwesfasfsadf";
		/**
		 * 设置数据合理的缓存时间值，以避免浏览器频繁向服务器发送请求，提升服务器的性能 这里是将数据的缓存时间设置为1天
		 */
		//response.setDateHeader("expires", System.currentTimeMillis() + 10 * 1000);
		response.getOutputStream().write(data.getBytes());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
