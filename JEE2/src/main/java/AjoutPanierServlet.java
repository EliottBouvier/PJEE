

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String quantityStr = request.getParameter("quantity");
		Integer quantity = Integer.parseInt(quantityStr);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/cafes.jsp");
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
        request.setAttribute("result", "L'article a bien été ajouté au panier !");
        dispatcher.forward(request, response);
	}

}
