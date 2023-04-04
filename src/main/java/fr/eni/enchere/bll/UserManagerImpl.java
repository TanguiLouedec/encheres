package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UserDAOJdbcImpl;

public class UserManagerImpl implements IUserManager{
	
	
	
	public UserManagerImpl() {}


	public Utilisateurs selectByID(int id) {
		UserDAOJdbcImpl userDAO = DAOFactory.getUserDAO();
		return userDAO.selectByID(id);
	}

	
	public void insert(Utilisateurs user) {
		UserDAOJdbcImpl userDAO = DAOFactory.getUserDAO();
		userDAO.insert(user);
	}

}
