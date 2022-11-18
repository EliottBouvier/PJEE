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
				<a href="http://localhost:8080/JEE2/inscription.jsp"> Kahoueh. </a>
			</div>
		<ul class="nav-links">
			<li><a href=""> Accueil </a></li>
			<li><a href="http://localhost:8080/JEE2/cafes.jsp"> Nos Cafés </a></li>
			<li><a href="http://localhost:8080/JEE2/tasse.jsp"> Nos Tasses </a></li>
			<li><a href="http://localhost:8080/JEE2/contact.jsp"> Contact </a></li>
			<li><a href="http://localhost:8080/JEE2/panier.jsp"> Panier </a></li>
			<li><a href="http://localhost:8080/JEE2/authentification.jsp"> <i class="fas fa-user"></i> </a></li>
			<li><a href="http://localhost:8080/JEE2/admin.jsp"> <i class="fas fa-cog"></i> </a></li>
			<li><a href="http://localhost:8080/JEE2/deco.jsp"> <i class="fas fa-sign-out-alt"></i> </a></li>
		</ul>
		</div>
	</nav>
<br> <br> <br> <br>
<div class="carousel">
<div class="Mennu">Menu Administration</div>
<nav class="Mennulist">
  <ul>
    <li><a href="admin.jsp">Clients</a></li>
    <li><a href="articles.jsp">Articles</a></li>
    <li><a href="commandes.jsp">Commandes</a></li>
  </ul>
</nav>

<div class="conteneurx">
  <p>Clients</p>

<table class="tftable" border="1">
<<<<<<< Updated upstream
<tr><th>Nom</th><th>Prenom</th><th>Mail</th><th>Adresse</th><th>Numéro de Tel</th><th>Code Postal</th><th>Ville</th><th>Modifier</th></tr>
<tr><td>Row:1 Cell:1</td><td>Row:1 Cell:2</td><td>Row:1 Cell:3</td><td>Row:1 Cell:4</td><td>Row:1 Cell:5</td><td>Row:1 Cell:6</td><td>Row:1 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
<tr><td>Row:2 Cell:1</td><td>Row:2 Cell:2</td><td>Row:2 Cell:3</td><td>Row:2 Cell:4</td><td>Row:2 Cell:5</td><td>Row:2 Cell:6</td><td>Row:2 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
<tr><td>Row:3 Cell:1</td><td>Row:3 Cell:2</td><td>Row:3 Cell:3</td><td>Row:3 Cell:4</td><td>Row:3 Cell:5</td><td>Row:3 Cell:6</td><td>Row:3 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
<tr><td>Row:4 Cell:1</td><td>Row:4 Cell:2</td><td>Row:4 Cell:3</td><td>Row:4 Cell:4</td><td>Row:4 Cell:5</td><td>Row:4 Cell:6</td><td>Row:4 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
<tr><td>Row:5 Cell:1</td><td>Row:5 Cell:2</td><td>Row:5 Cell:3</td><td>Row:5 Cell:4</td><td>Row:5 Cell:5</td><td>Row:5 Cell:6</td><td>Row:5 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
<tr><td>Row:6 Cell:1</td><td>Row:6 Cell:2</td><td>Row:6 Cell:3</td><td>Row:6 Cell:4</td><td>Row:6 Cell:5</td><td>Row:6 Cell:6</td><td>Row:6 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
<tr><td>Row:7 Cell:1</td><td>Row:7 Cell:2</td><td>Row:7 Cell:3</td><td>Row:7 Cell:4</td><td>Row:7 Cell:5</td><td>Row:7 Cell:6</td><td>Row:7 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
<tr><td>Row:8 Cell:1</td><td>Row:8 Cell:2</td><td>Row:8 Cell:3</td><td>Row:8 Cell:4</td><td>Row:8 Cell:5</td><td>Row:8 Cell:6</td><td>Row:8 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
<tr><td>Row:9 Cell:1</td><td>Row:9 Cell:2</td><td>Row:9 Cell:3</td><td>Row:9 Cell:4</td><td>Row:9 Cell:5</td><td>Row:9 Cell:6</td><td>Row:9 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Retirer du panier"></div></form> </td></tr>
</table>
		
  
=======
<tr><th>Nom</th><th>Prenom</th><th>Mail</th><th>Adresse</th><th>Numéro de Tel</th><th>Code Postal</th><th>Ville</th> <th>Modification</th></tr>
<tr><td>Row:1 Cell:1</td><td>Row:1 Cell:2</td><td>Row:1 Cell:3</td><td>Row:1 Cell:4</td><td>Row:1 Cell:5</td><td>Row:1 Cell:6</td><td>Row:1 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
<tr><td>Row:2 Cell:1</td><td>Row:2 Cell:2</td><td>Row:2 Cell:3</td><td>Row:2 Cell:4</td><td>Row:2 Cell:5</td><td>Row:2 Cell:6</td><td>Row:2 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
<tr><td>Row:3 Cell:1</td><td>Row:3 Cell:2</td><td>Row:3 Cell:3</td><td>Row:3 Cell:4</td><td>Row:3 Cell:5</td><td>Row:3 Cell:6</td><td>Row:3 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
<tr><td>Row:4 Cell:1</td><td>Row:4 Cell:2</td><td>Row:4 Cell:3</td><td>Row:4 Cell:4</td><td>Row:4 Cell:5</td><td>Row:4 Cell:6</td><td>Row:4 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
<tr><td>Row:5 Cell:1</td><td>Row:5 Cell:2</td><td>Row:5 Cell:3</td><td>Row:5 Cell:4</td><td>Row:5 Cell:5</td><td>Row:5 Cell:6</td><td>Row:5 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
<tr><td>Row:6 Cell:1</td><td>Row:6 Cell:2</td><td>Row:6 Cell:3</td><td>Row:6 Cell:4</td><td>Row:6 Cell:5</td><td>Row:6 Cell:6</td><td>Row:6 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
<tr><td>Row:7 Cell:1</td><td>Row:7 Cell:2</td><td>Row:7 Cell:3</td><td>Row:7 Cell:4</td><td>Row:7 Cell:5</td><td>Row:7 Cell:6</td><td>Row:7 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
<tr><td>Row:8 Cell:1</td><td>Row:8 Cell:2</td><td>Row:8 Cell:3</td><td>Row:8 Cell:4</td><td>Row:8 Cell:5</td><td>Row:8 Cell:6</td><td>Row:8 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
<tr><td>Row:9 Cell:1</td><td>Row:9 Cell:2</td><td>Row:9 Cell:3</td><td>Row:9 Cell:4</td><td>Row:9 Cell:5</td><td>Row:9 Cell:6</td><td>Row:9 Cell:7</td><td><form id="form-1"><div class="row button"><input type="submit" value="Modifier du panier"></div></form></td></tr>
</table>
 
>>>>>>> Stashed changes
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