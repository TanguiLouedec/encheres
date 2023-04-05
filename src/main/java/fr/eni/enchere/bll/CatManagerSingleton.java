package fr.eni.enchere.bll;

public class CatManagerSingleton {
	private static CategorieManagerImpl instance;
	
	public static CategorieManagerImpl getInstance() {
		if (instance == null) {
			instance = new CategorieManagerImpl();
		}
		return instance;
	}
}
