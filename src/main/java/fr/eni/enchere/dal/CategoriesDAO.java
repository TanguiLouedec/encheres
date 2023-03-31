package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriesDAO {
	protected final String SELECT_ALL = "SELECT * FROM categories";
	protected final String SELECT_BY_ID = "SELECT * FROM categories WHERE categories = ?";
	
	public void selectall() {
	}
	 public void selectByID(int id) {
	        try (Connection con = ConnectionProvider.getConnection()){
	            PreparedStatement psmt = con.prepareStatement(SELECT_BY_ID);
	            psmt.setInt(1, id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

}
