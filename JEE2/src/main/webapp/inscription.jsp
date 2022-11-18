<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
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
			<li><a href="NosCafes"> Nos Caf�s </a></li>
			<li><a href="NosTasses"> Nos Tasses </a></li>
			<li><a href="http://localhost:8080/JEE2/contact.jsp"> Contact </a></li>
			<li><a href="http://localhost:8080/JEE2/panier.jsp"> Panier </a></li>
			<li><a href="http://localhost:8080/JEE2/authentification.jsp"> <i class="fas fa-user"></i> </a></li>

		</ul>
		</div>
	</nav>
	
<div class="container12">
    <div class="title2"><span>Inscriptions </span></div>
    ${result}
    <form name="Enregistrement" method="post" action="InscriptionServlet">
    
        <div class="user-details">

            <div class="input-box">
                <span class="details">Nom</span>
                <input type="text" name="utilNom" placeholder="Entrez votre nom" maxlength="20">
            </div>

            <div class="input-box">
                <span class="details">Prenom</span>
                <input type="text" name="utilPrenom" placeholder="Entrez votre Prenom" maxlength="20">
            </div>

            <div class="input-box">
                <span class="details">Email</span>
                <input type="email" name="utilMail"  placeholder="Entrez votre mail">
            </div>
            
            <div class="input-box">
                <span class="details">Mot de passe</span>
                <input type="password" name="mdp"  placeholder="Entrez votre mot de passe">
            </div>
     
            <div class="input-box">
                <span class="details">Num�ro de t�l�phone</span>
                <input type="tel" name="utilTel"  placeholder="Entrez votre num�ro de t�l�phone ">
            </div>
            
            <div class="input-box">
                <span class="details">Addresse</span>
                <input type="text" name="utilAddresse"  placeholder="Entrez votre addresse">
            </div>
            
            <div class="input-box">
                <span class="details">Ville</span>
                <input type="text" name="utilVille"  placeholder="Entrez votre ville">
            </div>
            
            <div class="input-box">
                <span class="details">Code postal</span>
                <input type="number" name="utilCP"  placeholder="Entrez votre code postal">
            </div>
            
            <div class="input-box">
                <span class="details">Carte Bancaire</span>
                <input type="text" name="utilCB"  placeholder="Entrez votre carte bancaire">
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
                        <h3>Nos r�seaux</h3>
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
                <p class="copyright"> Kahoueh Industries � 2022  </p>
            </div>
        </footer>
</div>

<script src="js/nav.js"></script>

</body>
</html>