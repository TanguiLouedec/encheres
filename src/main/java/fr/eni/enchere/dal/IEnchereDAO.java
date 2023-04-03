package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Encheres;

public interface IEnchereDAO {
	public Encheres selectByID(int id);
	public void insert(Encheres enchere);
}
