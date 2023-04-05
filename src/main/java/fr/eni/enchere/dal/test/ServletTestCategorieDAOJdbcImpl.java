package fr.eni.enchere.dal.test;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.CatManagerSingleton;
import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.CategoriesDAOJdbcImpl;

/**
 * Servlet implementation class ServletTestCategorieDAOJdbcImpl
 */
@WebServlet("/ServletTestCategorieDAOJdbcImpl")
public class ServletTestCategorieDAOJdbcImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestCategorieDAOJdbcImpl() {
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
			//boolean admin = true;
			Categories tech = new Categories("Tech");
			Categories home = new Categories("home");

			CatManagerSingleton.getInstance().insert(tech);
			CatManagerSingleton.getInstance().insert(home);

			//testCategories.setNoCategorie(1);
			//Utilisateurs user = new Utilisateurs(1,"Heisenberg","White","Walter","SayMyName@thegoat.meth","708-764-6288","308 Negra Arroyo Lane","87104","Albuquerque","WalterJr",admin);
			//testCategories.setArticle(new Articles(1, "methamphetamine", "blue meth", LocalDate.of(2012, 12, 12),
			//		LocalDate.of(2012, 12, 12), 1, 1,user, testCategories));

			//CategoriesDAOJdbcImpl CategoriesDAOJdbcImpl = new CategoriesDAOJdbcImpl();

			//Categories cat2 = new Categories("pokemon");
			//CategoriesDAOJdbcImpl.insert(cat2);
			
			//response.getWriter().append("Test : ").append(CategoriesDAOJdbcImpl.selectByID(2).toString());

		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("Fail");
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
