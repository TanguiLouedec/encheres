package fr.eni.enchere.bll;

public class ArticleManagerSingleton {
	private static ArticleManagerImpl instance;
	
	public static ArticleManagerImpl getInstance() {
		if (instance == null) {
			instance = new ArticleManagerImpl();
		}
		return instance;
	}
}
