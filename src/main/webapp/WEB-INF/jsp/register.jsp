<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/register-style.css">
		<meta charset="UTF-8">
		<title>Register</title>
	</head>
	<body>
		<div class="container">
	        <form method="post" action="./RegisterServlet">    
	            <label for="pseudo">Pseudo : (3-16 caractères)</label>
	            <input type="text" name="pseudo" id="pseudo" pattern="^\w{3,16}$" required>
	
	            <label for="nom">Nom :</label>
	            <input type="text" name="nom" id="nom" pattern="^\w{2,}$" required>
	
	            <label for="prenom">Prenom :</label>
	            <input type="text" name="prenom" id="prenom" pattern="^\w{2,}$" required>
	
	            <label for="email">Email :</label>
	            <input type="email" name="email" id="email" required>
	
	            <label for="telephone">Telephone :</label>
	            <input type="tel" name="telephone" id="telephone" required>
	
	            <label for="rue">Adresse :</label>
	            <input type="text" name="rue" id="rue" pattern="^\w{2,}$" required>
	
	            <label for="cp">Code postal :</label>
	            <input type="text" name="cp" id="cp" required>
	
	            <label for="ville"> Ville</label>
	            <input type="text" name="ville" id="ville" required>
	
	            <label for="mdp">Mot de Passe :</label>
	            <input type="password" name="mdp" id="mdp" required>
	
	            <label for="mdpConfirm">Confirmez le mot de passe :</label>
	            <input type="password" name="mdpConfirm" id="mdpConfirm" required>
	
	            <input type="submit" value="Submit" id="submit">
	        </form>    
	    </div>
	</body>
</html>