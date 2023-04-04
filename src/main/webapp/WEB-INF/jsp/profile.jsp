<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
	<meta charset="UTF-8">
	<title>Mon profil</title>
</head>
<body>
	<div class="container">
		<div class = "card container article">
			<div class="container">
				<h4>Mon profil</h4>
				<a>
					<button>Modifier</button>
				</a>	
			</div>
			
			<p>Pseudo : ${user.pseudo}</p>
			<p>Nom : ${user.nom}</p>
			<p>Prenom : ${user.prenom}</p>
			<p>Email : ${user.email}</p>
			<p>Telephone : ${user.telephone}</p>
			<p>Adresse : ${user.rue}</p>
			<p>Code postal : ${user.codePostal}</p>
			<p>Ville : ${user.ville}</p>
		</div>
	</div>
</body>
</html>