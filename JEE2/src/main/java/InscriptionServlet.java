

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import models.Banque;
import models.Role;
import models.Utilisateur;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String mail = request.getParameter("mail");
		final String nom = request.getParameter("nom");
		final String prenom = request.getParameter("prenom");
		final String password = request.getParameter("password");
		final String tel = request.getParameter("tel");
		final String adresse = request.getParameter("adresse");
		final String cp = request.getParameter("cp");
		final String ville = request.getParameter("ville");
		final String cb = request.getParameter("cb");
		
		if(mail == "" | nom == "" | prenom == "" | password == "" | tel == "" | adresse == "" | cp == "" | ville == "" | cb == "") {
			/* TODO:
			 * Un des champs est vide renvoyer une erreur
			 */
			return;
		}
		
		final Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setRole(getSimpleRole());
		utilisateur.setUtilAddresse(adresse);
		utilisateur.setUtilCb(cb);
		utilisateur.setUtilCp(cp);
		utilisateur.setUtilMail(mail);
		utilisateur.setUtilNom(nom);
		utilisateur.setUtilPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		utilisateur.setUtilPrenom(prenom);
		utilisateur.setUtilTel(tel);
		utilisateur.setUtilVille(ville);
		if(verifyMailAndTel(utilisateur) && verifyCB(utilisateur)) {
			addUtilisateur(utilisateur);
			final HttpSession session = request.getSession();
			session.setAttribute("utilMail", utilisateur.getUtilMail());
			session.setAttribute("utilNom", utilisateur.getUtilNom());
			session.setAttribute("utilPrenom", utilisateur.getUtilPrenom());
			session.setAttribute("utilTel", utilisateur.getUtilTel());
			session.setAttribute("utilAddresse", utilisateur.getUtilAddresse());
			session.setAttribute("utilCP", utilisateur.getUtilCp());
			session.setAttribute("utilVille", utilisateur.getUtilVille());
			session.setAttribute("utilCB", utilisateur.getUtilCb());
			return;
		}
		/* TODO:
		 * Utilisateur non valide (mail ou tel) renvoyer une erreur 
		 */
	}
	
	/**
	 * Check if mail and tel are unique
	 * @param utilisateur
	 * @return true if yes and false if not
	 */
	private boolean verifyMailAndTel(Utilisateur utilisateur) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Utilisateur> result = new ArrayList<>();
		result = session.createQuery("from Utilisateur where utilMail='" + utilisateur.getUtilMail() + "' or utilTel='" + utilisateur.getUtilTel() + "'").list();
		return result.isEmpty();
	}
	
	/**
	 * Check if the card number is valid or not
	 * @param utilisateur
	 * @return true if yes and false if not
	 */
	private boolean verifyCB(Utilisateur utilisateur) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Banque> result = new ArrayList<>();
		result = session.createQuery("from Banque where numCarte='" + utilisateur.getUtilCb() + "'").list();
		return !result.isEmpty();
	}
	
	private Role getSimpleRole() {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Role> result = new ArrayList<>();
		result = session.createQuery("from Role where idRole = 1").list();
		session.getTransaction().commit();
		session.close();
		return result.stream().findFirst().orElse(null);
	}
	
	private void addUtilisateur(Utilisateur utilisateur) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(utilisateur);
		session.getTransaction().commit();
		session.close();
	}

}