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
		
		<h1>ENIbay</h1>

				
		<%  
			//HttpSession session = request.getSession();
			if(session.getAttribute("isConnected")==null) {
				%>
					<a href="./RegisterServlet">
						<button>Sign up</button>
					</a>
					<a href="./ConnectionServlet">
						<button>Login</button>
					</a> 
				<%
			} else {
				%>
					<a href="./ProfileServlet">
						<button>Profile</button>
					</a>
					<a href="">
						<button>
							Sell
						</button>
					</a>
					<form action="./DisconnectServlet" method="post">
						<input type="submit" value="Disconnect"></input>
					</form>
				<%
			}
		%>
				
		<form action="./IndexServlet" method="post">		
			<select name="Categories" id="catMenu">
			    <option value="all">All</option>
			    
		    	<c:forEach items="${catList}" var="item">
					<option value=$item.noCategorie>${item.libelle}</option>
				</c:forEach>
			 
			</select>
			
            <input type="submit" value="Search" id="search">		
		</form>		
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