<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
</head>
<body>
	<h1>Authentification pour les étudiants ING2</h1>
	<br/>
	<form method="get" action="http://localhost:8080/JEE2/LoginServlet">
	<div class="row">
			<i class="fas fa-user"></i>
			<input type="text" name="id" id="id" placeholder="Email ou téléphone" maxlength="20" required>
		</div>
		<div class="row">
			<i class="fas fa-lock"></i>
			<input type="password" name="mdp" id="mdp" placeholder="Mot de passe" maxlength="20" required >
		</div>
		<div class="row button">
			<input type="submit" value="Connexion">
		</div>
		<button>Effacer</button>
	</form>
</body>
</html>