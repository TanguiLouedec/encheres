package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.enchere.bo.Articles;

public class ArticlesDAOJdbcImpl implements ArticlesDAO {

	private static final String INSERT_ARTICLE = "insert into articles_vendus(no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) values(?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL = "SELECT no_articles, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus";
	private static final String SELECT_BY_ID = "SELECT no_articles, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus WHERE no_articles = ?";
//	

	@Override
	public void insert(Articles article) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(2, article.getNomArticle());
			pstmt.setString(3, article.getDescription());
			pstmt.setDate(4, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			pstmt.setDate(5, java.sql.Date.valueOf(article.getDateFinEncheres()));
			pstmt.setInt(6, article.getPrixInitial());
			pstmt.setInt(7, article.getPrixVente());
			pstmt.setInt(8, article.getNoUtilisateur());
			pstmt.setInt(9, article.getNoCategorie());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Articles selectByID(int id) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Integer noArticle = rs.getInt(1);
				String nomArticle = rs.getString(2);
				String description = rs.getString(3);
				LocalDate dateDebutEncheres = rs.getDate(4).toLocalDate();
				LocalDate dateFinEncheres = rs.getDate(5).toLocalDate();
				Integer prixInitial = rs.getInt(6);
				Integer prixVente = rs.getInt(7);
				Integer noUtilisateur = rs.getInt(8);
				Integer noCategorie = rs.getInt(9);
				
				Articles article = new Articles(noArticle,nomArticle,description,dateDebutEncheres,dateFinEncheres,prixInitial,prixVente,noUtilisateur,noCategorie);
				
				return article;
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void selectAll() {

	}

	@Override
	public void update(Articles article) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Articles article) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void select(Articles article) throws SQLException {
		// TODO Auto-generated method stub

	}
}
