
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tickets_by_status")
public class CommandTicketsByStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		StringBuffer resBuff = new StringBuffer(result);
		ServiceDesk serviceDesk = ServiceDesk.getInsatnce();
		String param = request.getParameter("status");
		try {
			Ticket.Status status = Ticket.Status.valueOf(param);
			// result = serviceDesk.tickets(status).toString();
			resBuff.append(serviceDesk.tickets(status).toString());
		} catch (Exception e) {
			// result = "Invalid status ID: " + param;
			resBuff.append("Invalid status ID: " + param);
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
