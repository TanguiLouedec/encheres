package fr.eni.enchere.bll;

import java.util.ArrayList;

import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.dal.ArticlesDAOJdbcImpl;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UserDAOJdbcImpl;

public class ArticleManagerImpl implements IArticleManager{

	public ArticleManagerImpl() {}
	
	@Override
	public ArrayList<Articles> selectAll() {
		ArticlesDAOJdbcImpl articleDAO = DAOFactory.getArticleDAO();
		System.out.println("Manager ok");
		return articleDAO.selectAll();
	}

	@Override
	public Articles selectByID(int id) {
		ArticlesDAOJdbcImpl articleDAO = DAOFactory.getArticleDAO();
		return articleDAO.selectByID(id);
	}

	@Override
	public void insert(Articles article) {
		ArticlesDAOJdbcImpl articleDAO = DAOFactory.getArticleDAO();
		articleDAO.insert(article);
	}

}
