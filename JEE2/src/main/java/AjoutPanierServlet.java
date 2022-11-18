

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
 * Servlet implementation class AjoutPanierServlet
 */
@WebServlet("/ajoutPanierServlet")
public class AjoutPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutPanierServlet() {
    	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String quantityStr = request.getParameter("quantity-" + id);
		String from = request.getParameter("from");
		RequestDispatcher dispatcher;
		if(from.equalsIgnoreCase("cafe")) {
			dispatcher = request.getRequestDispatcher("NosCafes");
			final HttpSession htse = request.getSession();
			final RequestDispatcher dis = request.getRequestDispatcher("NosCafes");
			if(htse.getAttribute("utilRole") != null) {
				final Role role2 = (Role) htse.getAttribute("utilRole");
				String affichage = "";
				if(role2.getIdRole() == 2) {
					affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
				}
				affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
				request.setAttribute("affichageNav", affichage);
			}
		} else {
			dispatcher = request.getRequestDispatcher("NosTasses");
			final HttpSession htse = request.getSession();
			final RequestDispatcher dis = request.getRequestDispatcher("NosTasses");
			if(htse.getAttribute("utilRole") != null) {
				final Role role2 = (Role) htse.getAttribute("utilRole");
				String affichage = "";
				if(role2.getIdRole() == 2) {
					affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
				}
				affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
				request.setAttribute("affichageNav", affichage);
			}
		}
		Integer quantity = Integer.parseInt(quantityStr);
		final HttpSession session = request.getSession();
		String panier = "";
		if(session.getAttribute("panier") != null) {
			panier = (String) session.getAttribute("panier");
			final String[] articles = panier.split(";");
			boolean changed = false;
			for (int i = 0; i < articles.length; i++) {
				String article = articles[i];
				if(article.split("/")[0].equalsIgnoreCase(id)) {
					final String quantityArticleStr = article.split("/")[1];
					final Integer quantityArticle = Integer.parseInt(quantityArticleStr);
					final Integer newQuantityArticle = quantityArticle + quantity;
					String ancientArticle = article;
					article = id + "/" + newQuantityArticle;
					changed = true;
					panier = panier.replace(ancientArticle, article);
					break;
				}
			}
			if(!changed) {
				panier += id + "/" + quantity + ";";
			}
		} else {
			panier += id + "/" + quantity + ";";
		}
		session.removeAttribute("panier");
		session.setAttribute("panier", panier);
        request.setAttribute("result", "<center><p style=\"color:#88421D\";>L'article a bien été ajouté au panier !</p></center>");
        dispatcher.forward(request, response);
	}

}
