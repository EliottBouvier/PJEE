<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification r�ussie</title>
</head>
<body>
	<h1>Authentification r�ussie</h1>
	<br/>
	<form method="post">
		<div>
			S�lectionner un module : <br/>
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