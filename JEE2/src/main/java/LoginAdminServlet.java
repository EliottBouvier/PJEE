

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import models.Utilisateur;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String mail = request.getParameter("id");
		final String password = request.getParameter("mdp");
		final Utilisateur adminUtil = this.getAdminUtilisateur(mail);
		
		if(adminUtil == null) {
			response.sendRedirect("accueil.jsp");
		} else {
			if(BCrypt.checkpw(password, adminUtil.getUtilPassword())) {
				response.sendRedirect("panelAdmin.jsp");
			} else {
				response.sendRedirect("accueil.jsp");
			}
		}
	}
	
	public Utilisateur getAdminUtilisateur(String mail) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Utilisateur> result = new ArrayList<>();
		result = session.createQuery("from Utilisateur where utilMail = '" + mail + "' and utilRole=1").list();
		if(result.isEmpty()) return null;
		session.getTransaction().commit();
		session.close();
		return result.stream().findFirst().orElse(null);
	}

}
