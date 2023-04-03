package fr.eni.enchere.bll;

import java.util.ArrayList;

import fr.eni.enchere.bo.Categories;

public interface ICategorieManager {
	public ArrayList<Categories> selectAll();
	public Categories selectByID(int id);
	public void insert(Categories categorie);
}
