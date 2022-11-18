

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

import models.Commande;
import models.Role;
import models.Utilisateur;

/**
 * Servlet implementation class AdminCommande
 */
@WebServlet("/AdminCommande")
public class AdminCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session = HibernateUtil.getSessionFactory().openSession();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession httpSession = request.getSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Accueil");
		if(httpSession.getAttribute("utilRole") != null) {
			final Role role = (Role) httpSession.getAttribute("utilRole");
			if(role.getIdRole() != 2) {
				requestDispatcher.forward(request, response);
			}
			
			final List<Commande> utilisateurs = this.getCommande();
			if(utilisateurs == null) {
				
			} else {
				final HttpSession htse = request.getSession();
				final RequestDispatcher dis = request.getRequestDispatcher("articles.jsp");
				if(htse.getAttribute("utilRole") != null) {
					final Role role2 = (Role) htse.getAttribute("utilRole");
					String affichage = "";
					if(role2.getIdRole() == 2) {
						affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
					}
					affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
					request.setAttribute("affichageNav", affichage);
				}
				final StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("<table class=\"tftable\" border=\"1\"><tr><th>ID Commande</th><th>Date</th><th>Articles</th><th>Quantité</th><th>ID Client</th><th>Etat Commande</th><th>Total TTC</th></tr>");
				utilisateurs.forEach(util -> {
					stringBuilder.append("<tr><td>" + util.getCmdId() + "</td><td>" + util.getCmdDate().toString() + "</td><td>" + util.getCmdArticles() + "</td><td>" + util.getCmdNbArt() +  "</td><td>" + util.getCmdUtil() + "</td><td>" + util.getCmdEtat() + "</td><td>" + util.getCmdPrix() + "€</td></tr>");
				});
				stringBuilder.append("</table>");
				requestDispatcher = request.getRequestDispatcher("commandes.jsp");
				request.setAttribute("affichage", stringBuilder.toString());
				requestDispatcher.forward(request, response);
			}
			
		} else {
			requestDispatcher.forward(request, response);
		}
		session.close();
	}

	private List<Commande> getCommande() {
		if(!this.session.isOpen()) this.session = HibernateUtil.getSessionFactory().openSession();
		this.session.beginTransaction();
		List<Commande> result = new ArrayList<>();
		result = this.session.createQuery("from Commande").list();
		this.session.getTransaction().commit();
		return result;
	}

}
