package fr.eni.enchere.dal.test;

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
import fr.eni.enchere.dal.ArticlesDAOJdbcImpl;

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
			
			//Test Methode 01
//			Articles articleTest = new Articles(1, "Doudou Napoléonien",
//					"Doudou maléfique du 18e siècle ayant appartenu à Napoléon. Attention doudou susceptible, à manipuler avec précaution",
//					LocalDate.of(2023, 03, 31), LocalDate.of(2023, 04, 30), 666, 666, 3, 2);
//			ArticlesDAOJdbcImpl articleDAOJdbcImpl = new ArticlesDAOJdbcImpl();
//			articleDAOJdbcImpl.insert(articleTest);
//			response.getWriter().append("Insertion de l'article dont l'id est : ").append(articleTest.getNoArticle()+"");
//			response.getWriter().append("Test : ").append(articleDAOJdbcImpl.selectByID(1).toString()+"");
			//fin Test Methode 01

			Byte bit = 1;
			//test Methode 02
			Articles articleTest = new Articles(1,"test","test",LocalDate.of(2023, 03, 31), 
					LocalDate.of(2023, 04, 30), 3, 3, 
					new Utilisateurs (1, "test", "test","test","test","test","test","test","test","test", bit), 
					new Categories (1,"test"));
		
			ArticlesDAOJdbcImpl articlesDAO = new ArticlesDAOJdbcImpl(); 
			
			articlesDAO.insert(articleTest);
		
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("Fail");
			e.printStackTrace();
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());

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
