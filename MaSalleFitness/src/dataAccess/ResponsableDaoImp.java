package dataAccess;

import dataAccess.exceptions.ListingException;
import model.Responsable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResponsableDaoImp implements ResponsableDao {
    public static RowMapper<Responsable> rowMapper = new RowMapper<Responsable>() {
        @Override
        public Responsable map(ResultSet res) throws SQLException {
            return new Responsable(res.getInt("matricule"), res.getString("nom"), res.getString("prenom"));
        }
    };

    public ArrayList<Responsable> listingResponsables() {
        ArrayList<Responsable> responsables = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select matricule, nom, prenom from responsable";
            statement = connection.prepareStatement(requete);
            res = statement.executeQuery();

            while(res.next()) {
                responsables.add(rowMapper.map(res));
            }
        } catch (SQLException e) {
            throw new ListingException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new ListingException(e);
            }
        }

        return responsables;
    }
}
