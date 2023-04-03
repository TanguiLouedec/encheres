package fr.eni.enchere.dal;

import java.util.ArrayList;

import fr.eni.enchere.bo.Categories;

public interface ICategorieDAO {
	public ArrayList<Categories> selectAll();
	public Categories selectByID(int id);
	public void insert(Categories categorie);
}
