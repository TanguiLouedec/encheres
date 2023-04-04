package fr.eni.enchere.bll;

public class UserManagerSingleton {
	
	private static UserManagerImpl instance;
	
	public static UserManagerImpl getInstance() {
		if (instance == null) {
			instance = new UserManagerImpl();
		}
		return instance;
	}
}
