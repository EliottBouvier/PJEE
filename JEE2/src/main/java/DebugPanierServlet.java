

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DebugPanierServlet
 */
@WebServlet("/DebugPanierServlet")
public class DebugPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DebugPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/debug.jsp");
		if(session.getAttribute("panier") == null) {
			request.setAttribute("result", "Le panier est vide !");
	        dispatcher.forward(request, response);
		} else {
			request.setAttribute("result", session.getAttribute("panier"));
	        dispatcher.forward(request, response);
		}
	}
	

}
