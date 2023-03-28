package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Administrateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDAO implements CommonDao{
    protected final String SELECT_ALL = "SELECT * FROM administrateur";
    protected final String SELECT_BY_ID = "SELECT * FROM administrateur WHERE administrateur = ?";

    public void selectAll() {
    }

    public void selectByID(int id) {
        try (Connection con = ConnectionProvider.getConnection()){
            PreparedStatement psmt = con.prepareStatement(SELECT_BY_ID);
            psmt.setInt(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Administrateur admin) {

    }
}
