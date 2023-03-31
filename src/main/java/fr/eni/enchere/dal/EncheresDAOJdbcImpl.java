package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.enchere.bo.Encheres;



public class EncheresDAOJdbcImpl {
	protected final String INSERT="INSERT INTO encheres(date_enchere, montant_enchere) VALUES(?,?);";
	protected final String SELECT_ALL = "SELECT * FROM encheres";
	protected final String SELECT_BY_ID = "SELECT date_enchere,montant_enchere,no_enchere FROM encheres WHERE no_enchere =?";
	
	public void selectAll() {
    }
	 public Encheres selectByID(int id) {
	        try (Connection con = ConnectionProvider.getConnection()){
	            PreparedStatement psmt = con.prepareStatement(SELECT_BY_ID);
	            psmt.setInt(1, id);
	            	            
	            ResultSet rs = psmt.executeQuery();
	            
	            if (rs.next()) {
	            	Integer noEnchere = rs.getInt(1);
	            	LocalDate dateEnchere = rs.getDate(2).toLocalDate();
	            	Integer montantEnchere = rs.getInt(3);
	            	
	            	
	            	Encheres bid = new Encheres(dateEnchere,montantEnchere,noEnchere);
	            	
	            	return bid;
	            } else {
		            return null;
	            }
	            }catch (SQLException e) {
	            	throw new RuntimeException(e);

	            }
        
	        }
	        public Encheres insert(Encheres bid) {
		        try (Connection con = ConnectionProvider.getConnection()){
		        	
		            PreparedStatement psmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		            //psmt.setInt(1, bid.getNoEnchere());
		            psmt.setDate(2, java.sql.Date.valueOf(bid.getDateEnchere()));
		            psmt.setInt(3, bid.getMontantEnchere());
		            psmt.executeUpdate();

		            //récuppérer l'index auto généré par la base de donnée pour hydrater l'objet
		            
		            ResultSet rs = psmt.getGeneratedKeys();

		            if (rs.next()) {
		            	bid.setNoEnchere(rs.getInt(1));
		            }

			        psmt.close();
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
				return null;
	 }
	 
	 }
