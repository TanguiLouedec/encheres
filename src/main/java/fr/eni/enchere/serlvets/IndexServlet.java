package fr.eni.enchere.serlvets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManagerSingleton;
import fr.eni.enchere.bll.CatManagerSingleton;
import fr.eni.enchere.bll.UserManagerSingleton;
import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Categories;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Articles> articleList = new ArrayList<Articles>();
		articleList = null;
		ArrayList<Categories> catList = new ArrayList<Categories>();
		catList = null;
		try {
			articleList = ArticleManagerSingleton.getInstance().selectAll();
			catList = CatManagerSingleton.getInstance().selectAll();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("test");
		/*for (Articles articles : articleList) {
			sellerUsernames.add(UserManagerSingleton.getInstance().selectByID(articles.getUtilisateur().getNoUtilisateur()).getPseudo());
		}
		System.out.println("test2");
		for (String string : sellerUsernames) {
			System.out.println(string);
		}*/
		
		for (Articles article: articleList) {
			System.out.println(article.toString());
		}
		
		for (Categories categories : catList) {
			System.out.println(categories);
		}
		
		request.setAttribute("catList", catList);
		request.setAttribute("articleList", articleList);
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
