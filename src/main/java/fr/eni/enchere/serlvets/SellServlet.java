package fr.eni.enchere.serlvets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManagerSingleton;
import fr.eni.enchere.bll.CatManagerSingleton;
import fr.eni.enchere.bll.UserManagerSingleton;
import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Utilisateurs;

/**
 * Servlet implementation class SellServlet
 */
@WebServlet("/SellServlet")
public class SellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Categories> catList = null;

		try {
			catList = CatManagerSingleton.getInstance().selectAll();

		} catch (Exception e) {
		}
	
		request.setAttribute("catList", catList);
		request.getRequestDispatcher("/WEB-INF/jsp/sell.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("descr");
		String price = request.getParameter("price");
		HttpSession session = request.getSession();

		ArticleManagerSingleton.getInstance().insert(new Articles(nomArticle, description, LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.WEEKS), Integer.valueOf(price), Integer.valueOf(price), UserManagerSingleton.getInstance().selectByID(((Utilisateurs) session.getAttribute("user")).getNoUtilisateur()), 
																  CatManagerSingleton.getInstance().selectByID(Integer.valueOf(request.getParameter("catMenu")))));
		
		doGet(request, response);
	}

}
