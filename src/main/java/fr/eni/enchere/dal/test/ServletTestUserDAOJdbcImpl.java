package fr.eni.enchere.dal.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.UserDAOJdbcImpl;

/**
 * Servlet implementation class testDAO
 */
@WebServlet("/testDAO")
public class ServletTestUserDAOJdbcImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestUserDAOJdbcImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			Utilisateurs userTest = new Utilisateurs( "Koff", "Jean", "Benoit", "jean.benoit@gmail.com", "0615254895", "27 rue de la ritournelle", "37051", "Champigny-sur-Veude", "motDePasse", false);
			UserDAOJdbcImpl userDAOJdbcImpl = new UserDAOJdbcImpl();
			System.out.println(userTest.toString());
			userDAOJdbcImpl.insert(userTest);
			response.getWriter().append("Insertion de l'user dont l'id est : ").append(userTest.getNoUtilisateur()+"");
			response.getWriter().append("Test : ").append(userDAOJdbcImpl.selectByID(9).toString()+"");

		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("Fail");
			e.printStackTrace();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
