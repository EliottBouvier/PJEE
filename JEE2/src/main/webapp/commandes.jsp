<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/JEE2/css/index.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
<nav>
		<div class="nav-content">
			<div class="logo">
				<a href="Accueil"> Kahoueh. </a>
			</div>
		<ul class="nav-links">
			<li><a href="Accueil"> Accueil </a></li>
			<li><a href="NosCafes"> Nos Cafés </a></li>
			<li><a href="NosTasses"> Nos Tasses </a></li>
			<li><a href="contact.jsp"> Contact </a></li>
			<li><a href="VoirPanierServlet"> Panier </a></li>
			<li><a href="authentification.jsp"> <i class="fas fa-user"></i> </a></li>
			${affichageNav}
		</ul>
		</div>
	</nav>
	
<div class="carousel">
<div class="Mennu">Menu Administration</div>
<nav class="Mennulist">
  <ul>
    <li><a href="AdminClient">Clients</a></li>
    <li><a href="AdminArticles">Articles</a></li>
    <li><a href="AdminCommande">Commandes</a></li>
  </ul>
</nav>

<div class="conteneurx">
  <p>Commandes</p>

${affichage}

  
</div>

</div>


<br>
<br>
<br>

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