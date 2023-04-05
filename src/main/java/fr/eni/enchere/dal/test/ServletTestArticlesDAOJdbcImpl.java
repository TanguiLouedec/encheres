package fr.eni.enchere.dal.test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManagerSingleton;
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

		// Test insertion Article
		try {

			Utilisateurs user = new Utilisateurs(1, "test", "test", "test", "test", "test", "test", "test", "test",
					"test", false);
			Categories cat = new Categories(2, "test");

			Articles articleTest = new Articles(1, "test1", "test", LocalDate.of(2023, 03, 31),
					LocalDate.of(2023, 04, 30), 3, 3, user, cat);
			
			ArticlesDAOJdbcImpl articlesDAO = new ArticlesDAOJdbcImpl();
			
			articlesDAO.insert(articleTest);
		} catch (Exception e) {
			response.getWriter().append("Fail Insertion");
			e.printStackTrace();
		}

		// Test Select All
		try {
			ArticlesDAOJdbcImpl articlesDAO1 = new ArticlesDAOJdbcImpl();
			List<Articles> articlesList = articlesDAO1.selectAll();

			for (Articles article : articlesList) {
				response.getWriter().append(article.toString() + "\n");
			}

			ArticlesDAOJdbcImpl articlesDAOListe = new ArticlesDAOJdbcImpl();
			List<Articles> liste = articlesDAOListe.selectAll();

			for (Articles article : liste) {
				response.getWriter().append(article.toString() + "\n");
			}
		} catch (Exception e) {
			response.getWriter().append("Fail Select All");
			e.printStackTrace();
		}

		// Test Select ByID

		try {
			Articles selectedArticle = ArticleManagerSingleton.getInstance().selectByID(1823);
			System.out.println("Article :");
			System.out.println(selectedArticle.toString());

		} catch (Exception e) {
			response.getWriter().append("Fail SelectByID");
			e.printStackTrace();
		}

		// Test Delete
		ArticlesDAOJdbcImpl articlesDAO = new ArticlesDAOJdbcImpl();

		// insérer l'id de l'article a supprimer

		int idArticleASupprimer = 1816;
		try {
			articlesDAO.delete(idArticleASupprimer);

		} catch (Exception e) {
			response.getWriter().append("Fail Delete");
			e.printStackTrace();

		}

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
