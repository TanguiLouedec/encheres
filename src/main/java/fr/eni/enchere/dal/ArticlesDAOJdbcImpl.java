package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.enchere.bo.Articles;


public class ArticlesDAOJdbcImpl implements ArticlesDAO {

	private static final String INSERT_ARTICLE = "insert into articles_vendus(no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) values(?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL="SELECT" + "no_articles" + "nom_article" + "description" + "date_debut_encheres" + "date_fin_encheres" + "prix_initial" + "prix_vente" + "no_utilisateur" + "no_categorie";
//
//	
	
	@Override
	public void insert(Articles article) {
		// TODO Auto-generated method stub

		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(2, article.getNomArticle());
				pstmt.setString(3, article.getDescription());
				pstmt.setDate(4, java.sql.Date.valueOf(article.getDateDebutEncheres()));
				pstmt.setDate(5, java.sql.Date.valueOf(article.getDateFinEncheres()));
				pstmt.setInt(6, article.getPrixInitial());
				pstmt.setInt(7, article.getPrixVente());
				pstmt.setInt(8, article.getNoUtilisateur());
				pstmt.setInt(9, article.getNoCategorie());
				pstmt.setInt(9, article.getPrixInitial());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					article.setNoArticle(rs.getInt(1));
				}
				rs.close();
				pstmt.close();

			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void update(Articles article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Articles article){
		// TODO Auto-generated method stub

	}

	@Override
	public void select(Articles article) {
		// TODO Auto-generated method stub

	}
}
