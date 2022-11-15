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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String mdp=request.getParameter("mdp");
		Utilisateur utilisateur = this.getUtilisateur(id, mdp);
		if (utilisateur != null){
			System.out.println("gg");
			response.sendRedirect("accueil.jsp");
		} else{
			System.out.println("rip");
			response.sendRedirect("accueil.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("param1");
		String mdp=request.getParameter("param2");
		
		if (id == "ING2" && mdp == "ING2pw"){
			System.out.println("gg");
			//response.sendRedirect("http://localhost:8080/JEE2/successAuthentification.jsp");
			//System.out.println(login);
			//System.out.println(password);
		} else{
			System.out.println("rip");
			//response.sendRedirect("http://localhost:8080/JEE2/failedAuthentification.jsp");
			//System.out.println(login);
			//System.out.println(password);
		}
	}

    public Utilisateur getUtilisateur(String id, String password)
    {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Utilisateur> result = session.createQuery("from Utilisateur where utilMail = '" + id + "' AND utilPassword = '" + password + "'").list();
        session.close();

        Utilisateur utilisateur = null;

        if ( result.isEmpty() == false) {
        	utilisateur = result.get(0);
        }

        return utilisateur;
    }
}
