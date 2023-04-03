package fr.eni.enchere.bll;

import java.util.ArrayList;

import fr.eni.enchere.bo.Articles;

public interface IArticleManager {
	public ArrayList<Articles> selectAll();
	public Articles selectByID(int id);
	public void insert(Articles article);
}
