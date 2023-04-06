package fr.eni.enchere.dal;

public class DAOFactory {
	public static UserDAOJdbcImpl getUserDAO() {
		return new UserDAOJdbcImpl();
	}
	
	public static ArticlesDAOJdbcImpl getArticleDAO() {
		System.out.println("factory ok");
		return new ArticlesDAOJdbcImpl();
	}
	
	public static CategoriesDAOJdbcImpl getCatDAO() {
		return new CategoriesDAOJdbcImpl();
	}
}
