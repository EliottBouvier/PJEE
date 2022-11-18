

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
 * Servlet implementation class EditArticleAdminServlet
 */
@WebServlet("/EditArticleAdminServlet")
public class EditArticleAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session = HibernateUtil.getSessionFactory().openSession();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditArticleAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("utilRole") != null) {
			final Role role = (Role) httpSession.getAttribute("utilRole");
			if(role.getIdRole() != 2) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("accueil.jsp");
				requestDispatcher.forward(request, response);
			}
			final String id = request.getParameter("id");
			
			final Article article = this.getArticle(id);
			if(article == null) {
				
			} else {
				String affichage = "<div class=\"wrapper\">\r\n"
						+ "	<div class=\"title\"> <span>Changement article</span></div>\r\n"
						+ "	<form method=\"POST\" action=\"EditArticleAdminProcessServlet\">\r\n"
						+ "<input type=\"text\" name=\"id\" id=\"id\" value=\"" + id +  "\" hidden>" 
						+ "	<div class=\"row\">\r\n"
						+ "			<i class=\"fas fa-user\"></i>\r\n"
						+ "			<input type=\"text\" name=\"stock\" id=\"stock\" placeholder=\"Entrez le nouveau stock\" maxlength=\"200\" required>\r\n"
						+ "		</div>\r\n"
						+ "		<div class=\"row\">\r\n"
						+ "			<i class=\"fas fa-lock\"></i>\r\n"
						+ "			<input type=\"text\" name=\"prix\" id=\"prix\" placeholder=\"Entrez le nouveau prix TTC\" maxlength=\"200\" required >\r\n"
						+ "		</div>\r\n"
						+ "		<div class=\"row button\">\r\n"
						+ "			<input type=\"submit\" value=\"Editer\">\r\n"
						+ "		</div>\r\n"
						+ "	</form>\r\n"
						+ "</div>";
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
				request.setAttribute("affichage", affichage);
				requestDispatcher.forward(request, response);
			}
			
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("accueil.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	private Article getArticle(String id) {
		if(!this.session.isOpen()) this.session = HibernateUtil.getSessionFactory().openSession();
		this.session.beginTransaction();
		List<Article> result = new ArrayList<>();
		result = this.session.createQuery("from Article where artID='" + id + "'").list();
		this.session.getTransaction().commit();
		this.session.close();
		return result.stream().findFirst().orElse(null);
	}
}
