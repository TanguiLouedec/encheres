package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Retraits;

public interface IRetraitDAO {
	public void insert (Retraits retrait);
	public Retraits selectByID(int id);
}
