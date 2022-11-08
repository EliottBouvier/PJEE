<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification réussie</title>
</head>
<body>
	<h1>Authentification réussie</h1>
	<br/>
	<form method="post">
		<div>
			Sélectionner un module : <br/>
			<div>
		      <input type="radio" id="jee" name="drone" value="jee">
		      <label for="dewey">JEE et framework</label>
		    </div>
		    <div>
		      <input type="radio" id="cloud" name="drone" value="cloud">
		      <label for="dewey">Cloud Computing</label>
		    </div>
		    <div>
		      <input type="radio" id="design" name="drone" value="design">
		      <label for="dewey">Design patterns</label>
		    </div>
		</div>		
		<br/>
		<button>Valider</button>
	</form>
</body>
</html>