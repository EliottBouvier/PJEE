

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

import models.Article;
import models.Role;
import models.Utilisateur;

/**
 * Servlet implementation class AdminClient
 */
@WebServlet("/AdminClient")
public class AdminClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session = HibernateUtil.getSessionFactory().openSession();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession httpSession = request.getSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("accueil.jsp");
		if(httpSession.getAttribute("utilRole") != null) {
			final Role role = (Role) httpSession.getAttribute("utilRole");
			if(role.getIdRole() != 2) {
				requestDispatcher.forward(request, response);
			}
			
			final List<Utilisateur> utilisateurs = this.getUtilisateurs();
			if(utilisateurs == null) {
				
			} else {
				final StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("<table class=\"tftable\" border=\"1\"><tr><th>Nom</th><th>Prenom</th><th>Mail</th><th>Numéro de Tel</th><th>Adresse</th><th>Code Postal</th><th>Ville</th></tr>");
				utilisateurs.forEach(util -> {
					stringBuilder.append("<tr><td>" + util.getUtilNom() + "</td><td>" + util.getUtilPrenom() + "</td><td>" + util.getUtilMail() +  "</td><td>" + util.getUtilTel() + "</td><td>" + util.getUtilAddresse() + "</td><td>" + util.getUtilCp() + "</td><td> " + util.getUtilVille() + " </td></tr>");
				});
				stringBuilder.append("</table>");
				requestDispatcher = request.getRequestDispatcher("admin.jsp");
				request.setAttribute("affichage", stringBuilder.toString());
				requestDispatcher.forward(request, response);
			}
			
		} else {
			requestDispatcher.forward(request, response);
		}
		session.close();
	}

	private List<Utilisateur> getUtilisateurs() {
		if(!this.session.isOpen()) this.session = HibernateUtil.getSessionFactory().openSession();
		this.session.beginTransaction();
		List<Utilisateur> result = new ArrayList<>();
		result = this.session.createQuery("from Utilisateur").list();
		this.session.getTransaction().commit();
		return result;
	}

}
