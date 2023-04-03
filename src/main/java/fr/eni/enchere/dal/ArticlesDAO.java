package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ArticlesDAO {

	public class EncheresDAO implements CommonDao {
		protected final String SELECT_ALL = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus";
		protected final String SELECT_BY_ID = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus WHERE no_articles = ?";
		protected final String INSERT_ARTICLE = "insert into articles_vendus(no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) values(?,?,?,?,?,?,?,?,?)";

		public void selectall() {
		}

		public void selectByID(int id) {
			try (Connection con = ConnectionProvider.getConnection()) {
				PreparedStatement psmt = con.prepareStatement(SELECT_BY_ID);
				psmt.setInt(1, id);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
