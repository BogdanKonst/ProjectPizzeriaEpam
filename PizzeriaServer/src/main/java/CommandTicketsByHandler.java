
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tickets_by_handler")
public class CommandTicketsByHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		StringBuffer resBuff = new StringBuffer(result);
		ServiceDesk serviceDesk = ServiceDesk.getInsatnce();
		String param = request.getParameter("handler");
		try {
			int handlerId = Integer.valueOf(param);
			Handler handler = serviceDesk.handlers().stream().filter(x -> x.getId() == handlerId).findAny()
					.orElse(null);
			resBuff.append(serviceDesk.tickets(handler).toString());
		} catch (Exception e) {
			resBuff.append("Invalid handler ID: " + param);
		}
		response.setContentType("text/plain;charset=UTF-8");
		//Json
		response.getWriter().write(resBuff.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
