package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import fr.eni.enchere.bll.UserManagerSingleton;
import fr.eni.enchere.bo.Articles;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.tools.ConnectionProvider;


public class CategoriesDAOJdbcImpl implements ICategorieDAO {
	protected final String INSERT="INSERT INTO categories(libelle) VALUES(?);";
	protected final String SELECT_ALL = "SELECT no_categorie,libelle FROM categories";
	protected final String SELECT_BY_ID = "SELECT no_categorie,libelle FROM categories WHERE no_categorie =?";
        
	public ArrayList<Categories> selectAll() {
		ArrayList<Categories> catList = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);

			ResultSet rs = pstmt.executeQuery();

	

			while (rs.next()) {
				Integer noCategorie = rs.getInt(1);
				String libelle = rs.getString(2);

				Categories categorie = new Categories(noCategorie, libelle);
				
				if (catList== null) {
					catList= new ArrayList<Categories>();
				}
				
				catList.add(categorie);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return catList;
	}

	public Categories selectByID(int id) {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement psmt = con.prepareStatement(SELECT_BY_ID);
			psmt.setInt(1, id);

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				Integer noCategorie = rs.getInt(1);
				String libelle = rs.getString(2);

				Categories categorie = new Categories(noCategorie, libelle);

				return categorie;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	public void insert(Categories categorie) {
		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement psmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

			psmt.setString(1, categorie.getLibelle());
			psmt.executeUpdate();

			ResultSet rs = psmt.getGeneratedKeys();

			if (rs.next()) {
				categorie.setNoCategorie(rs.getInt(1));
			}

			psmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
