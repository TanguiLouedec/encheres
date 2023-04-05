<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
	
	<title>Connexion</title>
</head>
<body>
	<a href="./IndexServlet">
		<button>Home</button>
	</a> 
	<form method="post" action="./RegisterServlet" class="container card">
			    
            <label for="email">Email :</label>
            <input type="email" name="email" id="email">

            <label for="mdp">Mot de Passe :</label>
            <input type="password" name="mdp" id="mdp">

            <input type="submit" value="Se connecter" id="submit">
       </form>    
</body>
</html>