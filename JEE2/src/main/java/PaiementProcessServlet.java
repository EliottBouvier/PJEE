

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
import models.Banque;
import models.Commande;
import models.EtatCommande;
import models.Facture;
import models.Role;

/**
 * Servlet implementation class PaiementProcessServlet
 */
@WebServlet("/PaiementProcessServlet")
public class PaiementProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaiementProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	this.doPost(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession httpSession = request.getSession();
		final String panier = (String) httpSession.getAttribute("panier");
		final String utilID = ((Integer) httpSession.getAttribute("utilID")).toString();
		final String cvc = (String) request.getAttribute("cvc");
		final String expir = (String) request.getAttribute("dateExp");
		if(utilID == null || utilID.equalsIgnoreCase("")) {
			final HttpSession htse = request.getSession();
			final RequestDispatcher dis = request.getRequestDispatcher("authentification.jsp");
			if(htse.getAttribute("utilRole") != null) {
				final Role role2 = (Role) htse.getAttribute("utilRole");
				String affichage = "";
				if(role2.getIdRole() == 2) {
					affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
				}
				affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
				request.setAttribute("affichageNav", affichage);
			}
			dis.forward(request, response);
			return;
		}

		final Banque banque = this.getBanque(((String)httpSession.getAttribute("utilCB")));
		if(banque == null || (banque.getCvc().equalsIgnoreCase(cvc) && banque.getExpir().equalsIgnoreCase(expir))) {
			final RequestDispatcher requestDispatcher = request.getRequestDispatcher("PaiementServlet");
			request.setAttribute("result", "<center><p style=\"color:wheat\";>Il y a une erreur dans la carte bleue !</p></center>");
			requestDispatcher.forward(request, response);
			return;
		}
		
		float prixTotal = 0;
		final String[] panierArticles = panier.split(";");
		float totalTVA = 0;
		float totalHT = 0;
		int nombreArticle = 0;
		for(String articleStr : panierArticles) {
			final Integer idInt = Integer.parseInt(articleStr.split("/")[0]) + 1;
			final Article article = this.getArticle(idInt.toString());
			final float tauxTVAPourcent = article.getArtTauxTva();
			final float tauxTVA = tauxTVAPourcent / 100;
			final Integer quantity = Integer.parseInt(articleStr.split("/")[1]);
			final float totalTTC = quantity * article.getArtPrix();
			final float totHT = totalTTC / (1+tauxTVA);
			final float tvaMontant = totalTTC - totalHT;
			totalTVA += tvaMontant;
			totalHT += totHT;
			nombreArticle += quantity;
			prixTotal += (quantity * article.getArtPrix());
			article.setArtStock(article.getArtStock() - quantity);
			this.saveArticle(article);
		}
		if(banque.getSolde() < prixTotal) {
			final RequestDispatcher requestDispatcher = request.getRequestDispatcher("paiement.jsp");
			request.setAttribute("result", "<center><p style=\"color:wheat\";>Le solde est trop faible !</p></center>");
			requestDispatcher.forward(request, response);
			return;
		}
		
		final Commande commande = new Commande();
		final Date date = new Date();
		commande.setCmdArticles(panier);
		commande.setCmdDate(date);
		commande.setCmdDesc("");
		commande.setCmdEtat(this.getEtatCommande().getEtatcmdId());
		commande.setCmdNbArt(nombreArticle);
		commande.setCmdPrix(prixTotal);
		commande.setCmdUtil(Integer.parseInt(utilID));
		this.saveCommande(commande);
		banque.setSolde(banque.getSolde() - prixTotal);
		this.updateBanque(banque);
		final Facture facture = new Facture();
		facture.setCommande(commande);
		facture.setFactDate(date);
		facture.setFactTtc(commande.getCmdPrix());
		facture.setFactTva(totalTVA);
		facture.setFactHt(totalHT);
		this.saveFacture(facture);
		httpSession.removeAttribute("panier");
		final HttpSession htse = request.getSession();
		final RequestDispatcher dis = request.getRequestDispatcher("Accueil");
		if(htse.getAttribute("utilRole") != null) {
			final Role role2 = (Role) htse.getAttribute("utilRole");
			String affichage = "";
			if(role2.getIdRole() == 2) {
				affichage = "<li><a href=\"AdminClient\"> <i class=\"fas fa-cog\"></i> </a></li>";	
			}
			affichage += "<li><a href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt\"></i> </a></li>";
			request.setAttribute("affichageNav", affichage);
		}
		dis.forward(request, response);
	}
	
	private void saveArticle(Article article) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(article);
		session.getTransaction().commit();
		session.close();
	}
	
	private void saveFacture(Facture facture) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(facture);
		session.getTransaction().commit();
		session.close();
	}
	
	private void updateBanque(Banque banque) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(banque);
		session.getTransaction().commit();
		session.close();
	}
	
	private void saveCommande(Commande commande) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(commande);
		session.getTransaction().commit();
		session.close();
	}
	
	private EtatCommande getEtatCommande() {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<EtatCommande> result = new ArrayList<>();
		result = session.createQuery("from EtatCommande where etatcmdID='1'").list();
		session.getTransaction().commit();
		if(result.isEmpty()) return null;
		session.close();
		return result.stream().findFirst().orElse(null);
	}

	private Banque getBanque(String numCarte) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Banque> result = new ArrayList<>();
		result = session.createQuery("from Banque where numCarte='" + numCarte + "'").list();
		session.getTransaction().commit();
		if(result.isEmpty()) return null;
		session.close();
		return result.stream().findFirst().orElse(null);
	}
	
	private Article getArticle(String id) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Article> result = new ArrayList<>();
		result = session.createQuery("from Article where artID='" + id + "'").list();
		if(result.isEmpty()) return null;
		session.getTransaction().commit();
		session.close();
		return result.stream().findFirst().orElse(null);
	}

}
