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
			<li><a href="http://localhost:8080/JEE2/cafes.jsp"> Nos Cafés </a></li>
			<li><a href="http://localhost:8080/JEE2/tasse.jsp"> Nos Tasses </a></li>
			<li><a href="http://localhost:8080/JEE2/contact.jsp"> Contact </a></li>
			<li><a href="http://localhost:8080/JEE2/panier.jsp"> Panier </a></li>
			<li><a href="http://localhost:8080/JEE2/authentification.jsp"> <i class="fas fa-user"></i> </a></li>
		</ul>
		</div>
	</nav>

<table id="panier">
	<caption>Votre Panier</caption>
	<thead>
	<tr>
		<th>Article</th>
		<th>Prix unité</th>
		<th>Quantité</th>
		<th>Total</th>
		<th> Actions </th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>apu</td>
		<td>apu</td>
		<td>apu</td>
		<td>apu</td>
		<td> <button> Retirer du panier </button> </td>
	</tr>
	<tr>
		<td>apu</td>
		<td>apu</td>
		<td>apu</td>
		<td>apu</td>
		<td> <button> Retirer du panier </button> </td>
	</tr>
	<tr>
		<td>apu</td>
		<td>apu</td>
		<td>apu</td>
		<td>apu</td>
		<td> <button> Retirer du panier </button> </td>
	</tr>
	<tr>
		<td>apu</td>
		<td>apu</td>
		<td>apu</td>
		<td>apu</td>
		<td> <button> Retirer du panier </button> </td>
	</tr>
	
	
	</tbody>
</table>

<a href="http://localhost:8080/JEE2/paiement.jsp"> <button class="btnpayer"> PASSER COMMANDE </button> </a>

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