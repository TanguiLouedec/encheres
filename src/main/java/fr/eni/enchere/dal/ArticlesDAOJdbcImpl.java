package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.tools.ConnectionProvider;

public class ArticlesDAOJdbcImpl implements IArticleDAO {

	protected final String INSERT_ARTICLE = "insert into articles_vendus(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) values(?,?,?,?,?,?,?,?)";
	protected final String SELECT_ALL = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus";
	protected final String SELECT_BY_ID = "SELECT" + "a.no_article," + "a.nom_article," + "a.description,"
			+ "a.date_debut_encheres," + "a.date_fin_encheres," + "a.prix_initial" + "a.prix_vente,"
			+ "u.no_utilisateur," + "c.no_categorie" + "FROM" + "articles_vendus a "
			+ "JOIN utilisateurs u ON a.no_utilisateur = u.no_utilisateur "
			+ "JOIN categories c ON a.no_categorie = c.no_categorie ";
	protected final String DELETE_ARTICLE = "DELETE FROM articles_vendus WHERE no_article = ?";

	public void insert(Articles article) {

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement psmt = con.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);

			psmt.setString(1, article.getNomArticle());
			psmt.setString(2, article.getDescription());
			psmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			psmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			psmt.setInt(5, article.getPrixInitial());
			psmt.setInt(6, article.getPrixVente());
			psmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			psmt.setInt(8, article.getCategorie().getNoCategorie());
			psmt.executeUpdate();

			// Recuperer l'index auto généré par la base de données pour hydrater l'objet
			ResultSet rs = psmt.getGeneratedKeys();

			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
			psmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Articles selectByID(int id) {
		Articles article = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(SELECT_BY_ID);
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

				// Debut de jointure. Le "Utilisateurs" n'est pas reconnu.
				Utilisateurs utilisateur = new Utilisateurs();
				utilisateur.setNoUtilisateur(noUtilisateur);

				// Jointure le "Categories" n'est pas reconnu
				Categories categorie = new Categories();
				categorie.setNoCategorie(noCategorie);

				article = new Articles(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres,
						prixInitial, prixVente, utilisateur, categorie);

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return article;

	}

	@Override
	public List<Articles> selectAll() {
		List<Articles> articlesList = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer noArticle = rs.getInt(1);
				String nomArticle = rs.getString(2);
				String description = rs.getString(3);
				LocalDate dateDebutEncheres = rs.getDate(4).toLocalDate();
				LocalDate dateFinEncheres = rs.getDate(5).toLocalDate();
				Integer prixInitial = rs.getInt(6);
				Integer prixVente = rs.getInt(7);

				Integer noUtilisateur = rs.getInt(8);
				Integer noCategorie = rs.getInt(9);

				// Debut de jointure. Le "Utilisateurs" n'est pas reconnu.
				Utilisateurs utilisateur = new Utilisateurs();
				utilisateur.setNoUtilisateur(noUtilisateur);

				// Debut de jointure. Le "Categories" n'est pas reconnu.
				Categories categorie = new Categories();
				categorie.setNoCategorie(noCategorie);

				Articles article = new Articles(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres,
						prixInitial, prixVente, utilisateur, categorie);

				if (articlesList == null) {
					articlesList = new ArrayList<Articles>();
				}

				articlesList.add(article);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return articlesList;
	}

	// suppression d'article
	@Override
	public void delete(int id) {

		// Etape 1 : ouvrir une connexion
		try (Connection connection = ConnectionProvider.getConnection()) {
			// Etape 2 : créer une requêt paramétrée (PreparedStatement)
			PreparedStatement pstmt = connection.prepareStatement(DELETE_ARTICLE);
			{

				// Etape 3 : valoriser les paramètres
				pstmt.setInt(1, id);

				// Etape 4 : exécuter la requete
				pstmt.executeUpdate();

			}
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}
}
