

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupprimerArticlePanierServlet
 */
@WebServlet("/SupprimerArticlePanierServlet")
public class SupprimerArticlePanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerArticlePanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String idArticle = request.getParameter("id");
		final Integer idArticleint = Integer.parseInt(idArticle);
		final HttpSession httpSession = request.getSession();
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("panier.jsp");
		String panier = (String) httpSession.getAttribute("panier");
		final String[] articles = panier.split(";");
		if(articles.length == 1) {
			httpSession.removeAttribute("panier");
		} else {
			for (int i = 0; i < articles.length; i++) {
				String article = articles[i];
				if(article.split("/")[0].equalsIgnoreCase((idArticleint -1)+"")) {
					panier = panier.replace(article, "");
					break;
				}
			}
		}
		request.setAttribute("result", "<center>L'article a bien été supprimé.</center>");
		requestDispatcher.forward(request, response);
	}

}
