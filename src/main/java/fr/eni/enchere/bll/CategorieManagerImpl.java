package fr.eni.enchere.bll;

import java.util.ArrayList;

import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.dal.ArticlesDAOJdbcImpl;
import fr.eni.enchere.dal.CategoriesDAOJdbcImpl;
import fr.eni.enchere.dal.DAOFactory;

public class CategorieManagerImpl implements ICategorieManager{

	public CategorieManagerImpl() {}
	
	@Override
	public ArrayList<Categories> selectAll() {
		CategoriesDAOJdbcImpl catDAO = DAOFactory.getCatDAO();
		return catDAO.selectAll();
	}

	@Override
	public Categories selectByID(int id) {
		CategoriesDAOJdbcImpl catDAO = DAOFactory.getCatDAO();
		return catDAO.selectByID(id);
	}

	@Override
	public void insert(Categories categorie) {
		CategoriesDAOJdbcImpl catDAO = DAOFactory.getCatDAO();
		catDAO.insert(categorie);
	}

}
