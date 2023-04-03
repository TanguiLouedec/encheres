package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Categories;


public class CategoriesDAOJdbcImpl {
	protected final String INSERT="INSERT INTO categories(libelle) VALUES(?);";
	protected final String SELECT_ALL = "SELECT * FROM categories";
	protected final String SELECT_BY_ID = "SELECT no_categorie,libelle FROM categories WHERE no_categorie =?";
	
	public void selectAll() {
    }
	 public Categories selectByID(int id) {
	        try (Connection con = ConnectionProvider.getConnection()){
	            PreparedStatement psmt = con.prepareStatement(SELECT_BY_ID);
	            psmt.setInt(1, id);
	            	            
	            ResultSet rs = psmt.executeQuery();
	            
	            if (rs.next()) {
	            	Integer noCategorie = rs.getInt(1);
	            	String libelle = rs.getString(2);
	            	
	            	
	            	Categories categorie = new Categories(noCategorie,libelle);
	            	
	            	return categorie;
	            } else {
		            return null;
	            }
	            }catch (SQLException e) {
	            	throw new RuntimeException(e);

	            }
        
	        }
	        public Categories insert(Categories categorie) {
		        try (Connection con = ConnectionProvider.getConnection()){
		        	
		            PreparedStatement psmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		            
		            psmt.setString(2, categorie.getLibelle());
		            psmt.executeUpdate();

		            
		            
		            ResultSet rs = psmt.getGeneratedKeys();

		            if (rs.next()) {
		            	categorie.setNoCategorie(rs.getInt(1));
		            }

			        psmt.close();
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
				return null;
	 }
}