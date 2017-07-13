package chen.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 　　一个web资源收到客户端请求后，通知服务器去调用另外一个web资源进行处理，称之为请求转发/307。
　　一个web资源收到客户端请求后，通知浏览器去访问另外一个web资源进行处理，称之为请求重定向/302。
 * 
 * getOutputStream和getWriter方法分别用于得到输出二进制数据、输出文本数据的ServletOuputStream、Printwriter对象。
 * getOutputStream和getWriter这两个方法互相排斥，调用了其中的任何一个方法后，就不能再调用另一方法。
 * Servlet程序向ServletOutputStream或PrintWriter对象中写入的数据将被Servlet引擎从response里面获取，
 * Servlet引擎将这些数据当作响应消息的正文，然后再与响应状态行和各响应头组合后输出到客户端。
 * Serlvet的service方法结束后，Servlet引擎将检查getWriter或getOutputStream方法返回的输出流对象是否已经调用过close方法，
 * 如果没有，Servlet引擎将调用close方法关闭该输出流对象。
 * 
 * @category @author chengchen2
 * @date Jul 13, 2017
 * @param
 */

@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.调用sendRedirect方法实现请求重定向, sendRedirect方法内部调用了
		 * response.setHeader("Location",
		 * "/JavaWeb_HttpServletResponse_Study_20140615/index.jsp");
		 * response.setStatus(HttpServletResponse.SC_FOUND);//设置302状态码，等同于response.setStatus(302);
		 */
		response.sendRedirect("ServletFirst");

		// 2.使用response设置302状态码和设置location响应头实现重定向实现请求重定向
		// response.setHeader("Location",
		// "/JavaWeb_HttpServletResponse_Study_20140615/index.jsp");
		// response.setStatus(HttpServletResponse.SC_FOUND);//设置302状态码，等同于response.setStatus(302);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}