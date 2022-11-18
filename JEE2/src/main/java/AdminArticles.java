

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
 * Servlet implementation class AdminArticles
 */
@WebServlet("/AdminArticles")
public class AdminArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session = HibernateUtil.getSessionFactory().openSession();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminArticles() {
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
			
			final List<Article> utilisateurs = this.getArticles();
			if(utilisateurs == null) {
				
			} else {
				final StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("<table class=\"tftable\" border=\"1\"><tr><th>Article</th><th>Stock</th><th>Prix</th><th>TVA</th><th>Marque</th><th>Catégorie</th><th>Contrôle</th></tr>");
				utilisateurs.forEach(article -> {
					stringBuilder.append("<tr><td>" + article.getArtDesc() +"</td><td>" + article.getArtStock() + "</td><td>" + article.getArtPrix() +  "€</td><td>" + article.getArtTauxTva() + "%</td><td>" + article.getMarque().getMarqueNom() + "</td><td>" + article.getCategorie().getCatNom() + "</td><td><form action=\"EditArticleAdminServlet\" method=\"post\" id=\"form-" + article.getArtId() + "\"><input type=\"text\" name=\"id\" value=\"" + article.getArtId() + "\" hidden><div class=\"row button\"><input type=\"submit\" value=\"Éditer le produit\"></div></form></td></tr>");
				});
				stringBuilder.append("</table>");
				requestDispatcher = request.getRequestDispatcher("articles.jsp");
				request.setAttribute("affichage", stringBuilder.toString());
				requestDispatcher.forward(request, response);
			}
			
		} else {
			requestDispatcher.forward(request, response);
		}
		session.close();
	}

	private List<Article> getArticles() {
		if(!this.session.isOpen()) this.session = HibernateUtil.getSessionFactory().openSession();
		this.session.beginTransaction();
		List<Article> result = new ArrayList<>();
		result = this.session.createQuery("from Article").list();
		this.session.getTransaction().commit();
		return result;
	}

}
