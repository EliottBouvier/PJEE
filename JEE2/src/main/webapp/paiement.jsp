<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/JEE2/css/index.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
	<nav>
		<div class="nav-content">
			<div class="logo">
				<a href="http://localhost:8080/JEE2/inscription.jsp"> Kahoueh. </a>
			</div>
		<ul class="nav-links">
			<li><a href="http://localhost:8080/JEE2/accueil.jsp"> Accueil </a></li>
			<li><a href="NosCafes"> Nos Cafés </a></li>
			<li><a href="NosTasses"> Nos Tasses </a></li>
			<li><a href="http://localhost:8080/JEE2/contact.jsp"> Contact </a></li>
			<li><a href="http://localhost:8080/JEE2/panier.jsp"> Panier </a></li>
			<li><a href="http://localhost:8080/JEE2/authentification.jsp"> <i class="fas fa-user"></i> </a></li>
			<li><a href="http://localhost:8080/JEE2/admin.jsp"> <i class="fas fa-cog"></i> </a></li>
		</ul>
		</div>
	</nav>
	
<div class="container1">
	${result}
    <div class="title3"><span> Vérifications de paiement </span></div>
    <form name="Enregistrement" method="post" action="ContactServlet">
    
        <div class="user-details">

            <div class="input-box">
                <span class="details">Carte Bancaire</span>
                <input type="text" name="cb" placeholder="Entrez votre Carte bancaire" maxlength="30">
            </div>

            <div class="input-box">
                <span class="details">Numéro CVC</span>
                <input type="text" name="prenom" placeholder="Entrez votre code confidentiel cvc" maxlength="3">
            </div>

            <div class="input-box">
                <span class="details">Date d'expiration</span>
                <input type="date" name="dateExp">
            </div>

        </div>

        <div class="button">
            <input type="submit" value="Envoyer">
            <input id="reset" type="reset" value="Effacer" />
        </div>
       
    </form>	
    </div>
    
<br> <br>
<div class="footer-dark">
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-3 item">
                        <h3>Nos réseaux</h3>
                        <ul>
                            <li><a href="https://www.facebook.com/">Facebook</a></li>
                            <li><a href="https://twitter.com/home?lang=fr">Twitter</a></li>
                            <li><a href="https://www.snapchat.com/l/fr-fr/">Snapchat</a></li>
                            <li><a href="https://www.instagram.com/">Instagram </a></li>
                        </ul>
                    </div>
                    <div class="col-md-6 item text" id='about'>
                        <h3>Kahoueh Industries</h3>
                        <p>.</p>
                    </div> 
                </div>
                <p class="copyright"> Kahoueh Industries © 2022  </p>
            </div>
        </footer>
</div>

<script src="js/nav.js"></script>

</body>
</html>