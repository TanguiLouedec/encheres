<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<link rel="stylesheet" href="/WEB-INF/style/register-style.css">
		<meta charset="UTF-8">
		<title>Register</title>
	</head>
	<body>
	    <div class="container">
	        <form method="post" action="register">    
	            <label for="pseudo">Pseudo :</label>
	            <input type="text" name="pseudo" id="pseudo">
	
	            <label for="nom">Nom :</label>
	            <input type="text" name="nom" id="nom">
	
	            <label for="prenom">Prenom :</label>
	            <input type="text" name="prenom" id="prenom">
	
	            <label for="email">Email :</label>
	            <input type="text" name="email" id="email">
	
	            <label for="telephone">Telephone :</label>
	            <input type="text" name="telephone" id="telephone">
	
	            <label for="rue">Adresse :</label>
	            <input type="text" name="rue" id="rue">
	
	            <label for="cp">Code postal :</label>
	            <input type="text" name="cp" id="cp">
	
	            <label for="ville"> Ville</label>
	            <input type="text" name="ville" id="ville">
	
	            <label for="mdp">Mot de Passe :</label>
	            <input type="password" name="mdp" id="mdp">
	
	            <label for="mdpConfirm">Confirmez le mot de passe :</label>
	            <input type="password" name="mdpConfirm" id="mdpConfirm">
	
	            <input type="submit" value="Submit" id="submit">
            </div>
        </form>    
	</body>
</html>