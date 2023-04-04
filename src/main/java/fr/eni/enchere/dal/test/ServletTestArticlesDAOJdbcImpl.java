package fr.eni.enchere.dal.test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.ArticlesDAOJdbcImpl;

/**
 * Servlet implementation class ServletTestArticlesDAOJdbcImpl
 */
@WebServlet("/ServletTestArticlesDAOJDBCImpl")
public class ServletTestArticlesDAOJdbcImpl extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestArticlesDAOJdbcImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			//Test Insertion Article

			Boolean bit = true;
			Utilisateurs user = new Utilisateurs(1, "test", "test", "test", "test", "test", "test", "test", "test",
					"test", bit);
			Categories cat = new Categories(2, "test");

			Articles articleTest = new Articles(1, "test1", "test", LocalDate.of(2023, 03, 31),
					LocalDate.of(2023, 04, 30), 3, 3, user, cat);
			ArticlesDAOJdbcImpl articlesDAO = new ArticlesDAOJdbcImpl();
			articlesDAO.insert(articleTest);

			
			// Test Select All
			
			ArticlesDAOJdbcImpl articlesDAOListe = new ArticlesDAOJdbcImpl();
			List<Articles> liste = articlesDAOListe.selectAll();

			for (Articles article : liste) {
			    response.getWriter().append(article.toString() + "\n");}
			
			// Test Select ByID
			
//	        Articles selectedArticle = articleDAO.selectByID(article.getNoArticle());
//	        System.out.println("Selected article:");
//	        System.out.println(selectedArticle.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("Fail");
			e.printStackTrace();
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
