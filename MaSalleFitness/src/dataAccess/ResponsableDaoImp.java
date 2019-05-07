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
        ArrayList<Responsable> responsables = new ArrayList<Responsable>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select matricule, nom, prenom from responsable resp";
            statement = connection.prepareStatement(requete);
            res = statement.executeQuery();

            while(res.next()) {
                responsables.add(rowMapper.map(res));
            }
        } catch (SQLException e) {
            throw new ListingException(e);
        } finally {
            try {
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new ListingException(e);
            }
        }

        return responsables;
    }
}
