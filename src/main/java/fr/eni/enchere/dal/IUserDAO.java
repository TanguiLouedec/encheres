package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateurs;

public interface IUserDAO {
	public Utilisateurs selectByID(int id);
	public void insert(Utilisateurs user);
}
