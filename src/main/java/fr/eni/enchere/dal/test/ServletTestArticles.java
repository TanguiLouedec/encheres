package fr.eni.enchere.dal.test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.dal.ArticlesDAOJdbcImpl;
import fr.eni.enchere.dal.IArticleDAO;

/**
 * Servlet implementation class ServletTestArticles
 */
@WebServlet("/ServletTestArticles")
public class ServletTestArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestArticles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // Create a new Article object for testing purposes
        Articles article = new Articles();
        article.setNomArticle("Article de test");
        article.setDescription("Ceci est un article de test.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        article.setDateDebutEncheres(LocalDate.parse("2023-04-04", formatter));
        article.setDateFinEncheres(LocalDate.parse("2023-04-11", formatter));
        article.setPrixInitial(100);
        article.setPrixVente(0);

        IArticleDAO articleDAO = new ArticlesDAOJdbcImpl();

        // Insert the test article
        articleDAO.insert(article);
        System.out.println("Test article inserted");

        // Select all articles
        ArrayList<Articles> articlesList = articleDAO.selectAll();
        System.out.println("All articles:");
        for (Articles a : articlesList) {
            System.out.println(a.toString());
        }

        // Select an article by ID
        Articles selectedArticle = articleDAO.selectByID(article.getNoArticle());
        System.out.println("Selected article:");
        System.out.println(selectedArticle.toString());
    	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
