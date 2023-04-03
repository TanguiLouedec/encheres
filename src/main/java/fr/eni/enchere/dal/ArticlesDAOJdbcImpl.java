package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.tools.ConnectionProvider;

public class ArticlesDAOJdbcImpl implements IArticleDAO{

	protected  final String INSERT_ARTICLE = "insert into articles_vendus(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) values(?,?,?,?,?,?,?,?)";
	protected final String SELECT_ALL = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus";
	//protected final String SELECT_BY_ID = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus WHERE no_articles = ?";
	protected final String SELECT_BY_ID = "SELECT a.noArticle, a.nomArticle, a.description, a.dateDebutEncheres, a.dateFinEncheres, a.prixInitial, a.prixVente, u.noUtilisateur, c.noCategorie " +
			 "FROM Articles a " +
			 "JOIN Utilisateurs u ON a.noUtilisateur = u.noUtilisateur " +
			 "JOIN Categories c ON a.noCategorie = c.noCategorie " +
			 "WHERE a.noArticle = ?";
	
	public Articles selectByID(int id) {
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
				

				//Debut de jointure. Le "Utilisateurs" n'est pas reconnu.
				Utilisateurs utilisateur = new Utilisateurs();
				utilisateur.setNoUtilisateur(noUtilisateur);

				Categories categorie = new Categories();
				categorie.setNoCategorie(noCategorie);
				
				Articles article = new Articles(noArticle,nomArticle,description,dateDebutEncheres,dateFinEncheres,prixInitial,prixVente,utilisateur,categorie);
				
				return article;
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
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

				//Recuperer l'index auto généré par la base de données pour hydrater l'objet
			ResultSet rs = psmt.getGeneratedKeys();
			
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
			psmt.close();
			

        } catch (SQLException e) {
            throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Articles> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}


		
	

}
