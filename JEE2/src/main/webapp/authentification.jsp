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
		<div>
			Login : <input type="text" name="param1"><br/><br/>
			Mot de passe : <input type="password" name="param2">
		</div>		
		<br/>
		<button type="submit">Envoyer</button>
		<button>Effacer</button>
	</form>
</body>
</html>