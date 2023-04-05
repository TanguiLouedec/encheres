<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.enchere.bo.Articles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">

<title>Enchere</title>
</head>
<body>

	<header class="card container">
		<a href="./RegisterServlet">
			<button>S'inscrire</button>
		</a> 
		<a href="./ConnectionServlet">
			<button>Se connecter</button>
		</a>
		<a href="./ProfileServlet">
			<button>Profil</button>
		</a>
		<a href="">
			<button>
				Vendre un article
			</button>
		</a>
		<a href="">
			<button>Deconnexion</button>
		</a>
		
		<select name="Categories" id="catMenu">
	
		    <option value="">--Please choose a categorie--</option>
		    <option value="all">Toutes</option>
	    	
			<c:forEach items="${catList}" var="cat">
				<option value="test">${cat.libelle}</option>
			</c:forEach>
		
		</select>
	</header>
	

		
	<div>
		<article class="container">
			<c:forEach items="${articleList}" var="item">
				<article class="card">
					<a href="">${item.nomArticle}</a><br>
					${item.description}<br> Début d'enchère :
					${item.dateDebutEncheres}<br> Fin d'enchère :
					${item.dateFinEncheres}<br> ${item.prixInitial}€<br>
					Vendeur : ${item.utilisateur.pseudo}<br>
					${item.categorie.libelle}<br>
				</article>
			</c:forEach>
		</article>
	</div>

</body>
</html>