package fr.eni.enchere.dal;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Articles;

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
					"Doudou maléfique du 18e siècle ayant appartenu à Napoléon et ayant survécu à Waterloo. Attention doudou susceptible, à manipuler avec précaution",
					LocalDate.of(2023, 03, 31), LocalDate.of(2023, 04, 30), 666, 666, 1, 66);
			ArticlesDAOJdbcImpl articlesDAOJdbcImpl = new ArticlesDAOJdbcImpl();
			articlesDAOJdbcImpl.insert(articleTest);
			response.getWriter().append("Insertion de l'article dont l'ID est : ")
					.append(articleTest.getNoArticle() + ".");

		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("Fail");
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
