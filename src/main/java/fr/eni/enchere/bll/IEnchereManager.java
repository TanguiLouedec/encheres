package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Encheres;

public interface IEnchereManager {
	public Encheres selectByID(int id);
	public void inesrt(Encheres enchere);
}
