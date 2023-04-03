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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			
			Categories testCategories = new Categories(1,"drogue");

			testCategories.setArticle(new Articles (1, "methamphetamine", "blue meth", LocalDate.of(2012,12,12), LocalDate.of(2012,12,12), 1,1,1, 1));
			
			
			
			CategoriesDAOJdbcImpl CategoriesDAOJdbcImpl = new CategoriesDAOJdbcImpl();

			
			response.getWriter().append("Test : ").append(CategoriesDAOJdbcImpl.selectByID(2).toString());

		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("Fail");
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
