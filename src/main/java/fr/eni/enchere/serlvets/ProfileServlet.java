package fr.eni.enchere.serlvets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			
			HttpSession session = request.getSession();
			
			
			
			Utilisateurs user = UserManagerSingleton.getInstance().selectByID(((Utilisateurs) session.getAttribute("user")).getNoUtilisateur());
			
			request.setAttribute("nickname", user.getPseudo());
			request.setAttribute("lastName", user.getNom());
			request.setAttribute("firstName", user.getPrenom());
			request.setAttribute("nickname", user.getPseudo());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("adress", user.getRue());
			request.setAttribute("cp", user.getCodePostal());
			request.setAttribute("city", user.getVille());	
			
			
			System.out.println(user.toString());
			//request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
