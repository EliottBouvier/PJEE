

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
 * Servlet implementation class EditArticleAdminProcessServlet
 */
@WebServlet("/EditArticleAdminProcessServlet")
public class EditArticleAdminProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session = HibernateUtil.getSessionFactory().openSession();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditArticleAdminProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession httpSession = request.getSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Accueil");
		if(httpSession.getAttribute("utilRole") != null) {
			final Role role = (Role) httpSession.getAttribute("utilRole");
			if(role.getIdRole() != 2) {
				requestDispatcher.forward(request, response);
			}
			final String id = request.getParameter("id");
			
			final Article article = this.getArticle(id);
			System.out.println(id);
			if(article == null) {
				
			} else {
				final HttpSession htse = request.getSession();
				final RequestDispatcher dis = request.getRequestDispatcher("AdminArticles");
				if(htse.getAttribute("utilRole") != null) {
					final Role role2 = (Role) htse.getAttribute("utilRole");
					String affichage = "";
					if(role2.getIdRole() == 2) {
						affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
					}
					affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
					request.setAttribute("affichageNav", affichage);
				}
				final Integer newStockInt = Integer.parseInt(((String) request.getParameter("stock")));
				final Float newPriceFloat = Float.parseFloat(((String) request.getParameter("prix")));
				article.setArtPrix(newPriceFloat);
				article.setArtStock(newStockInt);
				this.updateArticle(article);
				response.sendRedirect("AdminArticles");
			}
			
		} else {
			requestDispatcher.forward(request, response);
		}
	}

	private Article getArticle(String id) {
		if(!this.session.isOpen()) this.session = HibernateUtil.getSessionFactory().openSession();
		this.session.beginTransaction();
		List<Article> result = new ArrayList<>();
		result = this.session.createQuery("from Article where artID='" + id + "'").list();
		this.session.getTransaction().commit();
		return result.stream().findFirst().orElse(null);
	}
	
	private void updateArticle(Article article) {
		if(!this.session.isOpen()) this.session = HibernateUtil.getSessionFactory().openSession();
		this.session.beginTransaction();
		this.session.update(article);
		this.session.getTransaction().commit();
		this.session.close();
	}
	
}
