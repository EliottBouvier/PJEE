

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * TODO:
		 * Récupérer le panier via HTTPSession V
		 * Récupérer les data de l'utilisateur via HTTPSession V
		 * Check si le solde de la carte peut supporter la transaction V
		 * Si oui => créer une commande V, émettre une facture V, et débiter carte V et envoyer un mail (si possible)
		 * Si non => Envoyer un message d'erreur  V
		 * GERER STOCK V
		 */
		final HttpSession httpSession = request.getSession();
		final String panier = (String) httpSession.getAttribute("panier");
		final String utilID = (String) httpSession.getAttribute("utilID");
		final Banque banque = this.getBanque(((String)httpSession.getAttribute("utilCB")));
		if(banque == null) {
			/*
			 * Return erreur pour la récupération de la banque
			 */
			return;
		}
		
		float prixTotal = 0;
		final String[] panierArticles = panier.split(";");
		float totalTVA = 0;
		float totalHT = 0;
		int nombreArticle = 0;
		for(String articleStr : panierArticles) {
			final Article article = this.getArticle(articleStr.split("/")[0]);
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
			/*
			 * Return erreur solde trop faible
			 */
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
		session.update(facture);
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
		if(result.isEmpty()) return null;
		session.getTransaction().commit();
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
