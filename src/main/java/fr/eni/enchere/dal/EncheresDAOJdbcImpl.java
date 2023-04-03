package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.enchere.bo.Encheres;
import fr.eni.enchere.dal.tools.ConnectionProvider;



public class EncheresDAOJdbcImpl implements IEnchereDAO{

	protected final String SELECT_ALL = "SELECT date_enchere,montant_enchere,no_enchere FROM encheres";
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
	            	
	            	
	            	//TODO r�cup�rer l'utilisateur et l'article
	            	
	            	//r�cup�rzer l'id puis r�cup�er l'objet
	            	
	            	// ====> soit faire une jointure
	            	
	            	Encheres bid = new Encheres(dateEnchere,montantEnchere,noEnchere);
	            	
	            	return bid;
	            } else {
		            return null;
	            }
	            }catch (SQLException e) {
	            	throw new RuntimeException(e);

	            }
        
	        }


			public final String INSERT="INSERT INTO encheres(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?);";
		
		
	        public void insert(Encheres bid) {
		        try (Connection con = ConnectionProvider.getConnection()){
		        	
		            PreparedStatement psmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		            //psmt.setInt(1, bid.getNoEnchere());
		            psmt.setDate(1, java.sql.Date.valueOf(bid.getDateEnchere()));
		            psmt.setInt(2, bid.getMontantEnchere());
		            psmt.setInt(3, bid.getArticle().getNoArticle());
		            psmt.setInt(4, bid.getUtilisateurs().getNoUtilisateur());
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
	        }
	 
	 }
