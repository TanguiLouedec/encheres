package fr.eni.enchere.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Articles;

public interface IArticleDAO {
	public List<Articles> selectAll();
	public Articles selectByID(int id);
	public void insert(Articles article);
	public void delete(int id);
}
