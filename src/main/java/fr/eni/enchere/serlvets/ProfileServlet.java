package fr.eni.enchere.serlvets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UserManagerImpl;
import fr.eni.enchere.bll.UserManagerSingleton;
import fr.eni.enchere.bo.Utilisateurs;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			Utilisateurs user = UserManagerSingleton.getInstance().selectByID(14);			
			/*request.setAttribute("nickname", user.getPseudo());
			request.setAttribute("lastName", user.getNom());
			request.setAttribute("firstName", user.getPrenom());
			request.setAttribute("nickname", user.getPseudo());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("adress", user.getRue());
			request.setAttribute("cp", user.getCodePostal());
			request.setAttribute("city", user.getVille());	*/
			
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(request, response);

			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
