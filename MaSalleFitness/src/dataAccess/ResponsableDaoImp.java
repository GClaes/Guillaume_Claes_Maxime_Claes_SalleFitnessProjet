package dataAccess;

import dataAccess.exceptions.ListingException;
import model.Responsable;

import java.sql.*;
import java.util.ArrayList;

public class ResponsableDaoImp implements ResponsableDao {
    public static RowMapper<Responsable> rowMapper = new RowMapper<Responsable>() {
        @Override
        public Responsable map(ResultSet res) throws SQLException {
            return new Responsable(res.getInt("resp.matricule"), res.getString("resp.nom"), res.getString("resp.prenom"));
        }
    };

    public ArrayList<Responsable> listingResponsables() {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select matricule, nom, prenom from responsable resp";
        ArrayList<Responsable> responsables = new ArrayList<Responsable>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    responsables.add(rowMapper.map(rs));
                }
                return responsables;
            }
        } catch (SQLException e) {
            throw new ListingException(e);
        }
    }
}
