package dataAccess;

import dataAccess.exceptions.RechercheException;
import model.Coach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoachDaoImp implements CoachDao {
    public static RowMapper<Coach> rowMapper = new RowMapper<Coach>() {
        @Override
        public Coach map(ResultSet res) throws SQLException {
            java.util.Date utilDate = res.getTimestamp("date_debut_coaching");
            return new Coach(res.getInt("matricule"), res.getString("nom"), res.getString("prenom"), res.getString("recompenses"), res.getInt("salaire_horaire"), utilDate);  //getDouble pour le salaireHoraire
        }
    };

    public ArrayList<Coach> listingCoach() {
        ArrayList<Coach> coachs = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select * from coach";
            statement = connection.prepareStatement(requete);
            res = statement.executeQuery();

            while(res.next()) {
                coachs.add(rowMapper.map(res));
            }
        } catch (SQLException e) {
            throw new RechercheException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new RechercheException(e);
            }
        }

        return coachs;
    }
}
