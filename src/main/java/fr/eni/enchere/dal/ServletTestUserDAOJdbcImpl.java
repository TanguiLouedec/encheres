package fr.eni.enchere.dal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Utilisateurs;

/**
 * Servlet implementation class testDAO
 */
@WebServlet("/testDAOtemp")
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
			
			Utilisateurs userTest = new Utilisateurs( "test", "test", "test", "test", "test", "test", "test", "test", "test", (byte) 1);
			UserDAOJdbcImpl userDAOJdbcImpl = new UserDAOJdbcImpl();
			userDAOJdbcImpl.insert(userTest);
			response.getWriter().append("Insertion de l'user dont l'id est : ").append(userTest.getNoUtilisateur()+"");
			response.getWriter().append("Test : ").append(userDAOJdbcImpl.selectByID(4).toString()+"");

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
