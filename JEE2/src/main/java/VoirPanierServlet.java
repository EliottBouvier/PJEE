

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
		if(httpSession.getAttribute("panier") ==  null) {
			request.setAttribute("result", "Le panier est vide !");
			requestDispatcher.forward(request, response);
		} else {
			final String panier = (String) httpSession.getAttribute("panier");
			final String[] panierArticles = panier.split(";");
			String result = "";
			for(String articleStr : panierArticles) {
				final Article article = this.getArticle(articleStr.split("/")[0]);
				if(article == null) {
					result = "Il y a un problème dans la récupération des articles...";
					request.setAttribute("result", result);
					requestDispatcher.forward(request, response);
					return;
				}
				
				final Integer quantity = Integer.parseInt(articleStr.split("/")[1]);
				result += article.getArtDesc() + " - " + article.getArtPrix() + "€ , Prix total: " + (article.getArtPrix() * quantity) + "€<br>";
			}
			request.setAttribute("result", result);
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
