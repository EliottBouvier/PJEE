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
				<a href="#"> Kahoueh. </a>
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
	
<div class="carousel">
  <div class="carousel-inner">
    
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

    <label for="carousel-1" class="carousel-control prev control-2"> < </label>
    <label for="carousel-2" class="carousel-control prev control-3"> < </label>
    <label for="carousel-3" class="carousel-control prev control-1"> < </label>
   
    <label for="carousel-1" class="carousel-control next control-3"> > </label>
    <label for="carousel-2" class="carousel-control next control-1"> > </label>
    <label for="carousel-3" class="carousel-control next control-2"> > </label>
    
    <ol class="carousel-indicators">
      <li>
        <label for="carousel-1" class="carousel-bullet"> . </label>
      </li>
      <li>
        <label for="carousel-2" class="carousel-bullet"> . </label>
      </li>
      <li>
        <label for="carousel-3" class="carousel-bullet"> . </label>
      </li>
    </ol>
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

<script src="nav.js"></script>

</body>
</html>