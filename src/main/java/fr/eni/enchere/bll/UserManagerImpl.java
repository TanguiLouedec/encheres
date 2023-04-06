package fr.eni.enchere.bll;

import java.util.ArrayList;

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
		try {
			UserDAOJdbcImpl userDAO = DAOFactory.getUserDAO();
			userDAO.insert(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	@Override
	public void delete(int id) {
		UserDAOJdbcImpl userDAO = DAOFactory.getUserDAO();
		userDAO.delete(id);
	}

	public ArrayList<Utilisateurs> selectAll() {
		UserDAOJdbcImpl userDAO = DAOFactory.getUserDAO();
		return userDAO.selectAll();
	}
	
	
}
