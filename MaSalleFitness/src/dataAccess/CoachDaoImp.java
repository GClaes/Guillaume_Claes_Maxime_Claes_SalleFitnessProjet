package dataAccess;

import dataAccess.exceptions.ListingException;
import dataAccess.exceptions.RechercherException;
import model.Coach;

import java.sql.*;
import java.util.ArrayList;

public class CoachDaoImp implements CoachDao {
    public static RowMapper<Coach> rowMapper = new RowMapper<Coach>() {
        @Override
        public Coach map(ResultSet res) throws SQLException {
            java.util.Date utilDate = res.getTimestamp("co.date_debut_coaching");
            return new Coach(res.getInt("co.matricule"), res.getString("co.nom"), res.getString("co.prenom"), res.getString("co.recompenses"), res.getInt("co.salaire_horaire"), utilDate);  //getDouble pour le salaireHoraire
        }
    };

    public ArrayList<Coach> listingCoach() {
        ArrayList<Coach> coachs = new ArrayList<Coach>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select * from coach co";
            statement = connection.prepareStatement(requete);
            res = statement.executeQuery();

            while(res.next()) {
                coachs.add(rowMapper.map(res));
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

        return coachs;
    }
}
