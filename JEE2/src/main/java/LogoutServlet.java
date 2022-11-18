

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Role;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("utilPrenom") != null) {
			httpSession.invalidate();
		}
		final HttpSession htse = request.getSession();
		final RequestDispatcher dis = request.getRequestDispatcher("Accueil");
		if(htse.getAttribute("utilRole") != null) {
			final Role role2 = (Role) htse.getAttribute("utilRole");
			String affichage = "";
			if(role2.getIdRole() == 2) {
				affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
			}
			affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
			request.setAttribute("affichageNav", affichage);
		}
		response.sendRedirect("Accueil");
	}

}
