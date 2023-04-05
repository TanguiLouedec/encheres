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

			// Test insertion Article

			Utilisateurs user = new Utilisateurs(14, "test", "test", "test", "test", "test", "test", "test", "test", "test", false);
			Categories cat = new Categories(2, "test");

			Articles articleTest = new Articles(1, "test1", "test", LocalDate.of(2023, 03, 31),
					LocalDate.of(2023, 04, 30), 3, 3, user, cat);
			ArticlesDAOJdbcImpl articlesDAO = new ArticlesDAOJdbcImpl();
			articlesDAO.insert(articleTest);
<<<<<<< HEAD

=======
			
		
			//Test Select All
			ArticlesDAOJdbcImpl articlesDAO1 = new ArticlesDAOJdbcImpl();
			List<Articles> articlesList = articlesDAO1.selectAll();
//
			for (Articles article : articlesList) {
			    response.getWriter().append(article.toString() + "\n");}
>>>>>>> branch 'master' of https://github.com/TanguiLouedec/encheres.git
			// Test Select All

			ArticlesDAOJdbcImpl articlesDAOListe = new ArticlesDAOJdbcImpl();
			List<Articles> liste = articlesDAOListe.selectAll();

			for (Articles article : liste) {
				response.getWriter().append(article.toString() + "\n");
			}

			// Test Select ByID

//			Articles selectedArticle = articleTest.selectByID(articleTest.getNoArticle());
//			System.out.println("Article :");
//			System.out.println(selectedArticle.toString());
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			response.getWriter().append("Fail");
//			e.printStackTrace();
//		}


			// Test Delete
//			ArticlesDAOJdbcImpl articlesDAO = new ArticlesDAOJdbcImpl();
//			int idArticleASupprimer = 1790; // insérer l'ID de l'article à supprimer
//			articlesDAO.delete(idArticleASupprimer);
			
	        // PENSER A VERIFIER QUE L'ID DE LA LISTE EXISTE DANS VOTRE BASE, SINON LA SUPPRESSION N'AURA AUCUN EFFET
	        Integer idArticleASupprimer = 1780;
	        ListeCourseManager manager = new ListeCourseManager();
	        try {
	            manager.supprimerListeCourse(idListeASupprimer);
	        } catch (BusinessException e) {
	            e.printStackTrace();
	            // LORSQUE LA BUSINESSEXPCETION SURVIENT, ON DUMP LES CODES ERREURS DANS LA CONSOLE, POUR MIEUX COMPRENDRE D'OU VIENT L'ERREUR
	            for(Integer code : e.getListeCodesErreur()) {
	                System.err.println("Code erreur rencontré au niveau BLL/DAL : " + code);
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        response.getWriter().append("Servlet Test Suppresion ListeCourse");

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
