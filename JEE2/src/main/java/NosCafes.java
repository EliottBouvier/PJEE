

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

/**
 * Servlet implementation class NosCafes
 */
@WebServlet("/NosCafes")
public class NosCafes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session = HibernateUtil.getSessionFactory().openSession();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NosCafes() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("cafes.jsp");
		final HttpSession htse = request.getSession();
		final RequestDispatcher dis = request.getRequestDispatcher("cafes.jsp");
		if(htse.getAttribute("utilRole") != null) {
			final Role role2 = (Role) htse.getAttribute("utilRole");
			String affichage = "";
			if(role2.getIdRole() == 2) {
				affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
			}
			affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
			request.setAttribute("affichageNav", affichage);
		}
		final List<Article> articles = this.getArticles();
		if(articles.isEmpty()) {
			request.setAttribute("affichage", "Nous n'avons aucun article disponible !");
			requestDispatcher.forward(request, response);
			return;
		}
		
		final StringBuilder resultBuilder = new StringBuilder();
		for(Article article : articles) {
			if(article.getCategorie().getCatId() != 3 && article.getCategorie().getCatId() != 5) {
				resultBuilder.append("<div class=\"div" + (article.getArtId()-1) + "\">");
				resultBuilder.append("<form action=\"ajoutPanierServlet\" method=\"post\">");
				resultBuilder.append("<input type=\"text\" name=\"from\" id=\"from\" value=\"cafe\" hidden>");
				resultBuilder.append("<div class=\"card\">");
				resultBuilder.append("<img class=\"photox" + (article.getArtId()-1) + "\" src=\"" + article.getArtImg() + "\">");
				resultBuilder.append("<div class=\"cardcontain\">");
				resultBuilder.append("<input type=\"text\" name=\"id\" id=\"id\" value=\"" + (article.getArtId()-1) + "\" hidden>");
				resultBuilder.append("<p class=\"textP\"> " + article.getArtDesc() + " </p>");
				resultBuilder.append("<p class=\"textMC\"> <span class=\"marque\">" + article.getMarque().getMarqueNom() + "</span> <span class=\"catégorie\">" + article.getCategorie().getCatNom() + "</span> </p>");
				resultBuilder.append("<div class=\"divQP\"><div class=\"btnQuantite\"><span onclick=\"removeIncrement(this);\" class=\"minus\" id=\"" + (article.getArtId()-1) + "\">-</span>");
				resultBuilder.append("<input type=\"text\" name=\"quantity-" + (article.getArtId()-1) + "\" id=\"quantity-" + (article.getArtId()-1) + "\" value=\"1\" hidden><span class=\"num\" id=\"num-" + (article.getArtId()-1) + "\" >1</span>");
				resultBuilder.append("<span onclick=\"addIncrement(this);\" id=\"" + (article.getArtId()-1) + "\"  class=\"plus\">+</span></div><p style=\"text-align: right;\">A partir de </p>");
				resultBuilder.append("<h3 class=\"price\">" + article.getArtPrix() + "€</h3>");
				resultBuilder.append("</div></div></div><div class=\"ajouterPanier\"><input type=\"submit\" value=\"Ajouter au panier\"></div></form></div>");
			}
		}
		session.close();
		request.setAttribute("affichage", resultBuilder.toString());
		requestDispatcher.forward(request, response);
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
