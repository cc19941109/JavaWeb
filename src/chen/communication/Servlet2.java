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
 * Servlet implementation class Servlet1
 */
//@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

	public Servlet2(){
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("init 2=------");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = config.getServletContext();
//		ServletContext context = this.getServletContext();

        String data = (String) context.getAttribute("data");//从ServletContext对象中取出数据
        response.getWriter().print("data="+data);
		System.out.println("servlet2------------");

        response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
