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
			<li><a href="NosCafes"> Nos Cafés </a></li>
			<li><a href="NosTasses"> Nos Tasses </a></li>
			<li><a href="http://localhost:8080/JEE2/contact.jsp"> Contact </a></li>
			<li><a href="http://localhost:8080/JEE2/panier.jsp"> Panier </a></li>
			<li><a href="http://localhost:8080/JEE2/authentification.jsp"> <i class="fas fa-user"></i> </a></li>

		</ul>
		</div>
	</nav>
	
<div class="carousel">
  <div class="carousel-inner">
    <!-- Bloco da imagem 1 -->
    <input
      class="carousel-open"
      type="radio"
      id="carousel-1"
      name="carousel"
      aria-hidden="true"
      hidden=""
      checked="checked"
    />
    <div class="carousel-item">
      <img
        src="images/cafe1.jpg"
      />
    </div>
    <!-- Bloco da imagem 2 -->
    <input
      class="carousel-open"
      type="radio"
      id="carousel-2"
      name="carousel"
      aria-hidden="true"
      hidden=""
    />
    <div class="carousel-item">
      <img
        src="images/cafe2.jpg"
      />
    </div>
    <!-- Bloco da imagem 3 -->
    <input
      class="carousel-open"
      type="radio"
      id="carousel-3"
      name="carousel"
      aria-hidden="true"
      hidden=""
    />
    <div class="carousel-item">
      <img
        src="images/cafe3.jpg"
      />
    </div>

    <!-- Pode adicionar mais blocos de imagens aqui -->

    <!-- Adicionar o prev de acordo com a quantidade de páginas que adicionar -->
    <label for="carousel-1" class="carousel-control prev control-2">‹</label>
    <label for="carousel-2" class="carousel-control prev control-3">‹</label>
    <label for="carousel-3" class="carousel-control prev control-1">‹</label>
    <!-- Adicionar o next de acordo com a quantidade de páginas que adicionar -->
    <label for="carousel-1" class="carousel-control next control-3">›</label>
    <label for="carousel-2" class="carousel-control next control-1">›</label>
    <label for="carousel-3" class="carousel-control next control-2">›</label>
    <!-- 
        Abaixo são os indicadores da página ativa. Se não quiser basta remover. 
        E caso adicione mais páginas, é preciso adicionar mais itens e alterar 
        a numeração 
    -->
    <ol class="carousel-indicators">
      <li>
        <label for="carousel-1" class="carousel-bullet">•</label>
      </li>
      <li>
        <label for="carousel-2" class="carousel-bullet">•</label>
      </li>
      <li>
        <label for="carousel-3" class="carousel-bullet">•</label>
      </li>
    </ol>
  </div>
</div>

<div class="cont">
	<div class="txtacc">
	<br>
	<br>
	<p style="text-align: center;"><span style="font-family: georgia, palatino, serif; color: #800000;">Cr&eacute;e en 2015 Kahoueh est un revendeur de caf&eacute; en vrac unique.</span></p>
<p style="text-align: center;"><span style="font-family: georgia, palatino, serif; color: #800000;">Nous proposons des caf&eacute; moulus ou en grain. Un large panel de caf&eacute;s s&rsquo;offre &agrave; vous : arabica, Robusta, et m&ecirc;me le fameux et pris&eacute; Kowi Luwak. Vous trouverez des caf&eacute;s des 4 coins du monde pour un choix de saveurs toujours plus diversifi&eacute;.</span><br /><span style="font-family: georgia, palatino, serif; color: #800000;">D&egrave;s le d&eacute;but, nous avons fait le choix de privil&eacute;gier la qualit&eacute; et la vari&eacute;t&eacute; de nos produits. Pour cela Kahoueh s&rsquo;engage &agrave; utiliser des fournisseurs Locaux sur la totalit&eacute; des produits propos&eacute;.</span><br /><span style="font-family: georgia, palatino, serif; color: #800000;">De plus nous avons d&eacute;velopp&eacute; plusieurs partenariats avec des fournisseurs Sud-Americain, Africain et Asiatique de confiance qui nous accompagne depuis nos d&eacute;buts.</span><br /><span style="font-family: georgia, palatino, serif; color: #800000;">Nos caf&eacute;s sont ensuite torr&eacute;fi&eacute; dans nos installations proches de Paris. </span><br /><span style="font-family: georgia, palatino, serif; color: #800000;">Kahoueh s&rsquo;engage dans une d&eacute;marche &eacute;co-responsable et garantie des caf&eacute;s issus du commerce &eacute;quitable.</span></p></p>
</div>
<br>
<br>
<p style="text-align: center;"><span style="font-family: georgia, palatino, serif;"><span style="font-family: georgia, palatino, serif; color: #800000;">Avec l'arriv&eacute; de l'hiver et des faibles temp&eacute;ratures, nous vous proposons ce mois-ci une s&eacute;lection de caf&eacute; intenses et doux.</span><br /><spa style="font-family: georgia, palatino, serif; color: #800000;">Parfait pour en profiter au coins du feu !&nbsp;</span>&nbsp;</span></p>
<br><br>
<p style="text-align: center;"><span style="font-family: 'arial black', sans-serif; font-size: 14pt;"><strong><span style="font-family: georgia, palatino, serif;">Nos S&eacute;lections du moment</span></strong></span></p>
<br>
<br>
<br>
	<div class="parentpromo">
	
	<div class="promo1"> 
	<div class="card">
  	<img class="img1" src="https://magazine.bellesdemeures.com/sites/default/files/styles/735x412/public/edito_migrate/article/image/cafe_en_grains_et_expresso.jpg" style="width:100%">
  	<div class="cardcontain">
    <p><b>Café aka</b></p>
    <p>viens de loin</p>
    <p style="text-align: right;">A partir de </p>
    <h3 class="price">10.99 €</h3>
  </div>
  <a href="cafes.jsp" class='card-link'></a>
</div>
	</div>
	
	<div class="promo2">
	<div class="card">
  	<img class="img1" src="https://magazine.bellesdemeures.com/sites/default/files/styles/735x412/public/edito_migrate/article/image/cafe_en_grains_et_expresso.jpg" style="width:100%">
  	<div class="cardcontain">
    <p><b>Café aka</b></p>
    <p>viens de loin</p>
    <p style="text-align: right;">A partir de </p>    
    <h3 class="price">10.99 €</h3>
  </div>
  <a href="cafes.jsp" class='card-link'></a>
</div>
	</div>
	
		<div class="promo3">
	<div class="card">
  	<img class="img1" src="https://magazine.bellesdemeures.com/sites/default/files/styles/735x412/public/edito_migrate/article/image/cafe_en_grains_et_expresso.jpg" style="width:100%">
  	<div class="cardcontain">
    <p><b>Café aka</b></p>
    <p>viens de loin</p>
    <p style="text-align: right;">A partir de </p>
    <h3 class="price">10.99 €</h3>
  </div>
  <a href="cafes.jsp" class='card-link'></a>
</div>
	</div>
	
	
	<div class="promo4">
	<div class="card">
  	<img class="img1" src="https://magazine.bellesdemeures.com/sites/default/files/styles/735x412/public/edito_migrate/article/image/cafe_en_grains_et_expresso.jpg" style="width:100%">
  	<div class="cardcontain">
    <p><b>Café aka</b></p>
    <p>viens de loin</p>
    <p style="text-align: right;">A partir de </p>
    <h3 class="price">10.99 €</h3>
  </div>
  <a href="cafes.jsp" class='card-link'></a>
</div>
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