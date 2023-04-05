<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
		
		<meta charset="UTF-8">
		<title>Register</title>
	</head>
	<body>
		<div class="container">
		
			<a href="./IndexServlet">
				<button>Home</button>
			</a> 
			
	        <form method="post" action="./RegisterServlet">    
	            <label for="pseudo">Pseudo : (3-16 caractères)</label>
	            <input type="text" name="pseudo" id="pseudo" pattern="^\w{3,16}$">
	
	            <label for="nom">Nom :</label>
	            <input type="text" name="nom" id="nom" pattern="^\w{2,}$">
	
	            <label for="prenom">Prenom :</label>
	            <input type="text" name="prenom" id="prenom" pattern="^\w{2,}$">
	
	            <label for="email">Email :</label>
	            <input type="email" name="email" id="email">
	
	            <label for="telephone">Telephone :</label>
	            <input type="tel" name="telephone" id="telephone">
	
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
	
	            <input type="submit" value="S'inscrire" id="submit">
	        </form>    
	    </div>
	</body>
</html>