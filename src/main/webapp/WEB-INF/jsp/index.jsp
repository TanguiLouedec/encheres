<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.eni.enchere.bo.Articles"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">

	<title>Enchere</title>
</head>
<body>
	<a href="./profile.jsp">
		<button>
			Profil
		</button>
	</a>
	
	<div>
		<ul>
			<c:forEach items="${articleList}" var="item">
			    ${item.nomArticle}<br>
			    ${item.description}<br>
   			    ${item.dateDebutEncheres}<br>
			    ${item.dateFinEncheres}<br>
			    ${item.prixInitial}<br>
			    ${item.utilisateur.nom}<br>
			    ${item.categorie.libelle}<br>	
			</c:forEach>
		</ul>
	</div>

</body>
</html>