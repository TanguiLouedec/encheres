package fr.eni.enchere.serlvets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UserManagerSingleton;
import fr.eni.enchere.bo.Utilisateurs;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		Utilisateurs currentUser = null;
		
		ArrayList<Utilisateurs> checkUsers = null;
		checkUsers = UserManagerSingleton.getInstance().selectAll();
		
		
		for (Utilisateurs utilisateurs : checkUsers) {

			if (email.equals(utilisateurs.getEmail()) && mdp.equals(utilisateurs.getMotDePasse())) {
				HttpSession session = request.getSession();
				currentUser = UserManagerSingleton.getInstance().selectByID(utilisateurs.getNoUtilisateur());
				session.setAttribute("user",  currentUser);
				session.setAttribute("isConnected", true);
			}
		}

		request.getRequestDispatcher("./IndexServlet").forward(request, response);		
		doGet(request, response);
	}

}
