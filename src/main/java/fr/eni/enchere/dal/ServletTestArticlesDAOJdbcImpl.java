package fr.eni.enchere.dal;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Utilisateurs;

/**
 * Servlet implementation class ServletTestArticlesDAOJdbcImpl
 */
@WebServlet("/ServletTestArticlesDAOJdbcImpl")
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

			Articles articleTest = new Articles(1, "Doudou Napoléonien",
					"Doudou maléfique du 18e siècle ayant appartenu à Napoléon. Attention doudou susceptible, à manipuler avec précaution",
					LocalDate.of(2023, 03, 31), LocalDate.of(2023, 04, 30), 666, 666, 3, 2);

			articleTest.setCategories(new Categories(2,"test"));
			Byte bit = 1;
			articleTest.setUtilisateurs(new Utilisateurs (3, "test", "test","test","test","test","test","test","test","test", bit));
			
			ArticlesDAOJdbcImpl articlesDAOJdbcImpl = new ArticlesDAOJdbcImpl();
			
			Articles article = ArticlesDAOJdbcImpl.insert(articleTest);
			
			System.out.println(articleTest);
			System.out.println(article);
			
			String affichage = article.toString();
			response.getWriter().append("Test : ").append(affichage);
//			articlesDAOJdbcImpl.insert(articleTest);
//			response.getWriter().append("Insertion de l'article dont l'id est : ").append(articleTest.getNoArticle()+"");
//			response.getWriter().append("Test : ").append(articlesDAOJdbcImpl.selectByID(1).toString()+"");
//			Articles article = articlesDAOJdbcImpl.insert(articleTest);
//
//			System.out.println(articleTest);
//			System.out.println(article);
//
//			String affichage = article.toString();
//			response.getWriter().append(affichage);

		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("Raté mais pas loin");
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());

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
