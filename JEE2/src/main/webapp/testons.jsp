<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/JEE2/testons.css">
</head>
<body>
<nav>
		<div class="nav-content">
			<div class="logo">
				<a href="#"> Kahoueh. </a>
			</div>
		<ul class="nav-links">
			<li><a href=""> Accueil </a></li>
			<li><a href=""> Nos Cafés </a></li>
			<li><a href=""> Nos Tasses </a></li>
			<li><a href=""> Contact </a></li>
			<li><a href=""> Panier </a></li>
			<li><a href=""> <i class="fas fa-user"></i> </a></li>

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
</body>
</html>