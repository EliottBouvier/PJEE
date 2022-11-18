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

import models.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public LoginServlet() {

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String mdp=request.getParameter("mdp");
		Utilisateur utilisateur = this.getUtilisateur(id, mdp);
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("authentification.jsp");
		if (utilisateur != null && BCrypt.checkpw(mdp, utilisateur.getUtilPassword())){
			HttpSession session = request.getSession();
			session.setAttribute("utilID", utilisateur.getUtilId());
			session.setAttribute("utilMail", utilisateur.getUtilMail());
			session.setAttribute("utilNom", utilisateur.getUtilNom());
			session.setAttribute("utilPrenom", utilisateur.getUtilPrenom());
			session.setAttribute("utilTel", utilisateur.getUtilTel());
			session.setAttribute("utilAddresse", utilisateur.getUtilAddresse());
			session.setAttribute("utilCP", utilisateur.getUtilCp());
			session.setAttribute("utilVille", utilisateur.getUtilVille());
			session.setAttribute("utilCB", utilisateur.getUtilCb());
			response.sendRedirect("accueil.jsp");
		} else{
			request.setAttribute("result", "<center><p style=\"color:wheat\";>L'identifiant ou le mot de passe est invalide !</p></center>");
			requestDispatcher.forward(request, response);
		}
	}

    public Utilisateur getUtilisateur(String id, String password)
    {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Utilisateur> result = new ArrayList<>();
        
    	if(id.contains("@")) {
            result = session.createQuery("from Utilisateur where utilMail = '" + id + "'").list();
    	} else {
            result = session.createQuery("from Utilisateur where utilTel = '" + id + "'").list();
    	}
        session.close();

        Utilisateur utilisateur = null;

        if (result.isEmpty() == false) {
        	utilisateur = result.get(0);
        }

        return utilisateur;	
    }
}
