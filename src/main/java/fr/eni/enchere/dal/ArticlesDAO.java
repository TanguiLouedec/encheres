package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Articles;

public interface ArticlesDAO {
	
	public void insert(Articles article) throws DALException, SQLException;
	public void update(Articles article) throws DALException, SQLException;
	public void delete(Articles article) throws DALException, SQLException;
	public void select(Articles article) throws DALException, SQLException;

	
}
