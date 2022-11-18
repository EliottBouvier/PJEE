<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	
<div class="parent">
	${result }
	<div class="div1">
	<form action="ajoutPanierServlet" method="post">
		<div class="card">
		<img class="photox1" src="https://graindesail.com/900-home_default/cafe-de-colombie-pitalito.jpg">
		<div class="cardcontain">
		<input type="text" name="id" id="id" value="2" hidden>
		<p class="textP">  Arabica : Café Origine Colombie </p>
			<p class="textMC"> <span class="marque">Désir du soir</span> <span class="catégorie">Bio</span> </p>
			
			<div class="divQP">
			
				<div class="btnQuantite">
					<span class="minus">-</span>
					<input type="text" name="quantity" id="quantity" value="1" hidden><span class="num">01</span>
					<span class="plus">+</span>
				</div>
				
				<p style="text-align: right;">A partir de </p>    
	    		<h3 class="price">10.99 €</h3>
				
			</div>
		</div>
		</div>
			<div class="ajouterPanier">
				<input type="submit" value="Ajouter au panier">
			</div> 	
	</form>
	</div>
	
	<div class="div2">
		<form method="post" action="ajoutPanierServlet">
				<div class="card">
				<img class="photox1" src="https://magazine.bellesdemeures.com/sites/default/files/styles/735x412/public/edito_migrate/article/image/cafe_en_grains_et_expresso.jpg">
				<div class="cardcontain">
				<p class="textP">  Arabica: Café de Paris </p>
				<input type="text" name="id" id="id" value="3" hidden>
				<p class="textMC"> <span class="marque">Eco+</span> <span class="catégorie">En grain</span> </p>
					
					<div class="divQP">
					
						<div class="btnQuantite">
						<span class="minus">-</span>
						<input type="text" name="quantity" id="quantity" value="1" hidden><span class="num">01</span>
						<span class="plus">+</span>
						</div>
						
						<p style="text-align: right;">A partir de </p>    
			    		<h3 class="price">10.99 €</h3>
						
					</div>
				</div>
				</div>
					<div class="ajouterPanier">
						<input type="submit" value="Ajouter au panier">
					</div> 
		</form>
	</div>
	
	<div class="div3">
	<form method="post" action="ajoutPanierServlet">
			<div class="card">
	<img class="photox1" src="https://factum-info.net/images/1_Fakty/5_Raznoe/34_2_kopi-luwak-1.jpg">
	<div class="cardcontain">
	<p class="textP">  Kowi Luwak: Café sensation Sahara </p>
	<input type="text" name="id" id="id" value="4" hidden>
	<p class="textMC"> <span class="marque">Eco+</span> <span class="catégorie">Bio</span> </p>
		
		<div class="divQP">
		
			<div class="btnQuantite">
			<span class="minus">-</span>
			<input type="text" name="quantity" id="quantity" value="1" hidden><span class="num">01</span>
			<span class="plus">+</span>
			</div>
			
			<p style="text-align: right;">A partir de </p>    
    		<h3 class="price">10.99 €</h3>
			
		</div>
	</div>
	</div>
		<div class="ajouterPanier">
			<input type="submit" value="Ajouter au panier">
		</div>	
	</form>
	</div>
	
	<div class="div4">
	<form method="post" action="ajoutPanierServlet">
		<div class="card">
	<img class="photox1" src="https://www.monsieurcafe.org/wp-content/uploads/2017/08/monsieur_cafe_guide_cafe_moulu.jpg">
	<div class="cardcontain">
	<p class="textP">  Robusta : Café </p>
	<input type="text" name="id" id="id" value="5" hidden>
	<p class="textMC"> <span class="marque">Désir du soir</span> <span class="catégorie">Moulus</span> </p>
		
		<div class="divQP">
		
			<div class="btnQuantite">
			<span class="minus">-</span>
			<input type="text" name="quantity" id="quantity" value="1" hidden><span class="num">01</span>
			<span class="plus">+</span>
			</div>
			
			<p style="text-align: right;">A partir de </p>    
    		<h3 class="price">10.99 €</h3>
			
		</div>
	</div>
	</div>
		<div class="ajouterPanier">
			<input type="submit" value="Ajouter au panier">
		</div>
	</form>
	</div>
	
	<div class="div5">
	<form>
		<div class="card"> 
	<img class="photox1" src="https://media1.coffee-webstore.com/img/cms/Blog/2020/11%20-%20NOVEMBRE/caf%C3%A9-en-grains-espresso.jpg">
	<div class="cardcontain">
	<p class="textP">  Arabica : café matin légé </p>
	<input type="text" name="id" id="id" value="6" hidden>
	<p class="textMC"> <span class="marque">Eco+</span> <span class="catégorie">Moulus</span> </p>
		
		<div class="divQP">
		
			<div class="btnQuantite">
			<span class="minus">-</span>
			<input type="text" name="quantity" id="quantity" value="1" hidden><span class="num">01</span>
			<span class="plus">+</span>
			</div>
			
			<p style="text-align: right;">A partir de </p>    
    		<h3 class="price">10.99 €</h3>
			
		</div>
	</div>
	</div>
		<div class="ajouterPanier">
			<input type="submit" value="Ajouter au panier">
		</div>
	</form>
	</div>
	
	<div class="div6">
	<form>
			<div class="card">
	<img class="photox1" src="https://occitanie-cafe.fr/img/cms/cafe-bio-machine-tasse-grain-capsule-occitanie.jpg"> 
	<div class="cardcontain">
	<p class="textP">  Robusta: Café noir corsé </p>
	<input type="text" name="id" id="id" value="7" hidden>
	<p class="textMC"> <span class="marque">Désir du soir</span> <span class="catégorie">En grain</span> </p>
		
		<div class="divQP">
		
			<div class="btnQuantite">
			<span class="minus">-</span>
			<input type="text" name="quantity" id="quantity" value="1" hidden><span class="num">01</span>
			<span class="plus">+</span>
			</div>
			
			<p style="text-align: right;">A partir de </p>    
    		<h3 class="price">10.99 €</h3>
			
		</div>
	</div>
	</div>
		<div class="ajouterPanier">
			<input type="submit" value="Ajouter au panier">
		</div>
	</form>
	</div>
	
</div>
<br> <br> <br>
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