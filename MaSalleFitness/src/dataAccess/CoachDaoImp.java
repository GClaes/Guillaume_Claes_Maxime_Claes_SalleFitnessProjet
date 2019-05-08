package dataAccess;

import dataAccess.exceptions.*;
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
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from coach co";
        ArrayList<Coach> coachs = new ArrayList<Coach>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    coachs.add(rowMapper.map(rs));
                }
                return coachs;
            }
        } catch (SQLException e) {
            throw new ListingException(e);
        }
    }

    public int nbHeuresCoaching(int matriculeCoach) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select sum(candi.nb_heures_coaching) from candidat candi, coach co\n" +
                "where candi.coach_matricule = co.matricule\n" +
                "and co.matricule = ?";
        int nbHeuresCoaching = -1;

        if (coachExiste(matriculeCoach)) {
            try (PreparedStatement statement  = connection.prepareStatement(requete)) {
                statement.setInt(1, matriculeCoach);

                try (ResultSet rs = statement.executeQuery()) {
                    rs.next();
                    nbHeuresCoaching = rs.getInt(1);
                }
            } catch (SQLException e) {
                throw new NbHeuresCoachingUtiliseesException(e);
            }
        }

        return nbHeuresCoaching;
    }

    public boolean coachExiste(int matriculeCoach) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select count(*) from coach where matricule = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            statement.setInt(1, matriculeCoach);

            try (ResultSet rs = statement.executeQuery()){
                rs.next();
                return rs.getInt(1) == 1;
            }
        } catch (SQLException e) {
            throw new CoachExisteException(e);
        }
    }

    /**
     *
     * @param matriculeCoach
     * @return si coach existe, return coach ; sinon return null
     */
    public Coach obtentionCoach(int matriculeCoach) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from coach co where matricule = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setInt(1, matriculeCoach);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rowMapper.map(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new ObtentionCoachException(e);
        }
    }
}
