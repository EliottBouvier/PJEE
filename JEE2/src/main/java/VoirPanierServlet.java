

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

/**
 * Servlet implementation class VoirPanierServlet
 */
@WebServlet("/VoirPanierServlet")
public class VoirPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoirPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession httpSession = request.getSession();
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("/panier.jsp");
		if(httpSession.getAttribute("panier") ==  null || httpSession.getAttribute("panier") == "") {
			request.setAttribute("result", "<center>Le panier est vide !</center>");
			requestDispatcher.forward(request, response);
		} else {
			final String panier = (String) httpSession.getAttribute("panier");
			final String[] panierArticles = panier.split(";");
			String result = "<table id=\"panier\"><caption>Votre Panier</caption>";
			result += "	<thead><tr><th>Article</th><th>Prix unité</th><th>Quantité</th><th>Total</th><th> Actions </th></tr></thead><tbody>";
			for(String articleStr : panierArticles) {
				final Integer idInt = Integer.parseInt(articleStr.split("/")[0]) + 1;
				final Article article = this.getArticle(idInt.toString());
				if(article == null) {
					result = "<center>Il y a un problème dans la récupération des articles...</center>";
					request.setAttribute("result", result);
					requestDispatcher.forward(request, response);
					return;
				}
				
				final Integer quantity = Integer.parseInt(articleStr.split("/")[1]);
				result += "<tr><td>" + article.getArtDesc() + "</td>";
				result += "<td>" + article.getArtPrix() + "€</td>";
				result += "<td>" + quantity + "</td>";
				result += "<td>" + (quantity * article.getArtPrix()) + "€</td>";
				result += "<td><form action=\"SupprimerArticlePanierServlet\" method=\"post\" id=\"form-" + article.getArtId() + "\"><input type=\"text\" name=\"id\" value=\"" + article.getArtId() + "\" hidden><div class=\"row button\"><input type=\"submit\" value=\"Retirer du panier\"></div></form></td>";
			}
			result += "</tr></tbody></table>";
			result += "<a href=\"PaiementServlet\"> <button class=\"btnpayer\"> PASSER COMMANDE </button> </a>";
			request.setAttribute("affichage", result);
			requestDispatcher.forward(request, response);
		}
	}
	
	public Article getArticle(String id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Article> result = new ArrayList<>();
		result = session.createQuery("from Article where artID='" + id + "'").list();
		if(result.isEmpty()) return null;
		session.getTransaction().commit();
		session.close();
		return result.stream().findFirst().orElse(null);
	}

}
