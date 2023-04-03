package fr.eni.enchere.dal;

import java.util.ArrayList;

import fr.eni.enchere.bo.Articles;

public interface IArticleDAO {
	public ArrayList<Articles> selectAll();
	public Articles selectByID(int id);
	public void insert(Articles article);
}
