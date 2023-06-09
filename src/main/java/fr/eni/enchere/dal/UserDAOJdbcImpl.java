package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.tools.ConnectionProvider;

public class UserDAOJdbcImpl implements IUserDAO{
	    protected final String SELECT_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, administrateur FROM utilisateurs WHERE no_utilisateur = ?";
	    protected final String SELECT_ALL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, administrateur FROM utilisateurs";

	    protected final String INSERT = "INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?)";
	    protected final String DELETE = " DELETE FROM `utilisateurs` WHERE `utilisateurs`.`no_utilisateur` = ?";

	    public Utilisateurs selectByID(int id) {
	        try (Connection con = ConnectionProvider.getConnection()){
	            PreparedStatement psmt = con.prepareStatement(SELECT_BY_ID);
	            psmt.setInt(1, id);
	            	            
	            ResultSet rs = psmt.executeQuery();
	            
	            if (rs.next()) {
	            	Integer no_utilisateur = rs.getInt(1);
	            	String pseudo = rs.getString(2);
	            	String nom = rs.getString(3);
	            	String prenom = rs.getString(4);
	            	String email = rs.getString(5);
	            	String telephone = rs.getString(6);
	            	String rue = rs.getString(7);
	            	String cp = rs.getString(8);
	            	String ville = rs.getString(9);
	            	String mdp = rs.getString(10);
	            	Boolean administrateur = rs.getBoolean(11);

	            	Utilisateurs user = new Utilisateurs(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp, administrateur);
	            	
	            	return user;
	            } else {
		            return null;
	            }
	            
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public void insert(Utilisateurs user) {
	        try (Connection con = ConnectionProvider.getConnection()){
	        	
	            PreparedStatement psmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	            psmt.setString(1, user.getPseudo()); 
	            psmt.setString(2, user.getNom());
	            psmt.setString(3, user.getPrenom());
	            psmt.setString(4, user.getEmail());
	            psmt.setString(5, user.getTelephone());
	            psmt.setString(6, user.getRue());
	            psmt.setString(7, user.getCodePostal());
	            psmt.setString(8, user.getVille());
	            psmt.setString(9, user.getMotDePasse());
	            psmt.setBoolean(10, user.getAdministrateur());
	            psmt.executeUpdate();

	            //récuppérer l'index auto généré par la base de donnée pour hydrater l'objet
	            
	            ResultSet rs = psmt.getGeneratedKeys();

	            if (rs.next()) {
	            	user.setNoUtilisateur(rs.getInt(1));
	            }

		        psmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    public ArrayList<Utilisateurs> selectAll(){
	    	System.out.println("dao ok");
	    	try (Connection con = ConnectionProvider.getConnection()){
	            PreparedStatement psmt = con.prepareStatement(SELECT_ALL);
	            System.out.println("dao connection ok");
	            ResultSet rs = psmt.executeQuery();
	            System.out.println("query ok");
	            ArrayList<Utilisateurs> allUsers = new ArrayList<Utilisateurs>();
	            
	            while (rs.next()) {
	            	System.out.println("rs ok");
	            	Integer no_utilisateur = rs.getInt(1);
	            	String pseudo = rs.getString(2);
	            	String nom = rs.getString(3);
	            	String prenom = rs.getString(4);
	            	String email = rs.getString(5);
	            	String telephone = rs.getString(6);
	            	String rue = rs.getString(7);
	            	String cp = rs.getString(8);
	            	String ville = rs.getString(9);
	            	String mdp = rs.getString(10);
	            	Boolean administrateur = rs.getBoolean(11);

	            	Utilisateurs user = new Utilisateurs(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp, administrateur);
	            	
	            	allUsers.add(user);	            	
	            }
	            
            	return allUsers;

	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

		public void delete(int id) {
			try (Connection con = ConnectionProvider.getConnection()){
				
	            PreparedStatement psmt = con.prepareStatement(DELETE);
	            psmt.setInt(1, id);
	            	            
	            psmt.executeUpdate();	       
	            
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
		}
}
