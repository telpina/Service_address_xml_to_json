package clientpart;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getaddress")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String address = request.getParameter("address");
		response.setContentType("text/html");
		try {
			RestClient rc = new RestClient();
			String JsonStr = rc.getAddressJson(address);
			out.println(JsonStr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
