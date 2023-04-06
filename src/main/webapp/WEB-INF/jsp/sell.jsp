<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
	
</head>
<body>
	<div class="container">
	
		<a href="./IndexServlet">
			<button>Home</button>
		</a> 
		
        <form method="post" action="./SellServlet">
      
            <label for="nomArticle">Title : </label>
            <input type="text" name="nomArticle" id="psenomArticleudo">

            <label for="descr">Description :</label>
            <input type="text" name="descr" id="descr">

            <label for="price">Price :</label>
            <input type="text" name="price" id="price"">

			<select name="catMenu" id="catMenu">			    
		    	<c:forEach items="${catList}" var="item">
					<option value=$item.noCategorie>${item.libelle}</option>
				</c:forEach>			 
			</select>
			
            <input type="submit" value="Sell" id="sell">		

        </form>    
    </div>
</body>
</html>