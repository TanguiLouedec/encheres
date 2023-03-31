package fr.eni.enchere.dal;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Encheres;
import fr.eni.enchere.bo.Utilisateurs;

/**
 * Servlet implementation class ServletTestEnchereDAOJdbcImpl
 */
@WebServlet("/ServletTestEnchereDAOJdbcImpl")
public class ServletTestEnchereDAOJdbcImpl extends HttpServlet {
	private static final long serialVersionUID = 3L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestEnchereDAOJdbcImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			Encheres testBid = new Encheres(LocalDate.of(2012,12,12),12,12121212);

			testBid.setArticle(new Articles (1, "nom", "prenom ", LocalDate.of(2012,12,12), LocalDate.of(2012,12,12), 1,1,1, 1));
			Byte bit = 1 ;
			testBid.setUtilisateurs(new Utilisateurs (1, "test", "test","test","test","test","test","test","test","test", bit));
			
			EncheresDAOJdbcImpl EncheresDAOJdbcImpl = new EncheresDAOJdbcImpl();

			Encheres enchere = EncheresDAOJdbcImpl.insert(testBid);

			System.out.println(enchere);
			System.out.println(testBid);
			
			String affichage = enchere.toString();
			response.getWriter().append("Test : ").append(affichage);

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
