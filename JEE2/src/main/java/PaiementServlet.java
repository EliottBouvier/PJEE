

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import models.Banque;
import models.Role;

/**
 * Servlet implementation class PaiementServlet
 */
@WebServlet("/PaiementServlet")
public class PaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaiementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("utilID") == null || httpSession.getAttribute("utilID") == "") {
			response.sendRedirect("authentification.jsp");
			return;
		}
		final Banque banqueCheck = this.getBanque(((String)httpSession.getAttribute("utilCB")));
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("paiement.jsp");
		final HttpSession htse = request.getSession();
		final RequestDispatcher dis = request.getRequestDispatcher("paiement.jsp");
		if(htse.getAttribute("utilRole") != null) {
			final Role role2 = (Role) htse.getAttribute("utilRole");
			String affichage = "";
			if(role2.getIdRole() == 2) {
				affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
			}
			affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
			request.setAttribute("affichageNav", affichage);
		}
		request.setAttribute("numCarte", "<input type=\"text\" name=\"cb\" placeholder=\"" + banqueCheck.getNumCarte() + "\" maxlength=\"30\" readonly>");
		requestDispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	
	private Banque getBanque(String numCarte) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Banque> result = new ArrayList<>();
		result = session.createQuery("from Banque where numCarte='" + numCarte + "'").list();
		session.getTransaction().commit();
		if(result.isEmpty()) return null;
		session.close();
		return result.stream().findFirst().orElse(null);
	}
}
