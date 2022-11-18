

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import models.Contact;
import models.Role;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String prenom = request.getParameter("prenom");
		final String nom = request.getParameter("nom");
		final String email = request.getParameter("email");
		final String contenu = request.getParameter("contenu");
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/contact.jsp");
		final HttpSession htse = request.getSession();
		final RequestDispatcher dis = request.getRequestDispatcher("contact.jsp");
		if(htse.getAttribute("utilRole") != null) {
			final Role role2 = (Role) htse.getAttribute("utilRole");
			String affichage = "";
			if(role2.getIdRole() == 2) {
				affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
			}
			affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
			request.setAttribute("affichageNav", affichage);
		}
		if(prenom == "" || nom == "" || email == "" || contenu == "") {
			request.setAttribute("result", "<center><p style=\"color:wheat\";>Un des champs est vide !</p></center>");
			dispatcher.forward(request, response);
			return;
		}
		
		final Contact contact = new Contact();
		contact.setContenu(contenu);
		contact.setEmail(email);
		contact.setNom(nom);
		contact.setPrenom(prenom);
		
        final Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(contact);
        session.getTransaction().commit();
        session.close();
        
        request.setAttribute("result", "<center><p style=\"color:wheat\";>Le message est bien envoyé !</p></center>");
        dispatcher.forward(request, response);
	}

}
