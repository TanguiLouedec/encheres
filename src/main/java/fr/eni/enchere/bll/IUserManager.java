package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateurs;

public interface IUserManager {
	public Utilisateurs selectByID(int id);
	public void insert(Utilisateurs user);
}
