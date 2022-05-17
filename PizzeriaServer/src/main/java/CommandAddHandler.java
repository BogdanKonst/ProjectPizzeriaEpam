

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add_handler")
public class CommandAddHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		StringBuffer resBuff = new StringBuffer(result);
		ServiceDesk serviceDesk = ServiceDesk.getInsatnce();
		Handler handler = serviceDesk.addHandler();
		resBuff.append("handler: " + handler);
		response.setContentType("text/plain;charset=UTF-8");
		//Json
		response.getWriter().write(resBuff.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
