package fr.eni.enchere.dal;

public class DAOFactory {
	public static UserDAOJdbcImpl getUserDAO() {
		return new UserDAOJdbcImpl();
	}
}
