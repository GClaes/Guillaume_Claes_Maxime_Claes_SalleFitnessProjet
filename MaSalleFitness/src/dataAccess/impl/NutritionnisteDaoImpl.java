package dataAccess.impl;

import dataAccess.NutritionnisteDao;
import dataAccess.exceptions.NutritionnisteDaoException;
import model.Nutritionniste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NutritionnisteDaoImpl implements NutritionnisteDao {
    private static NutritionnisteDao nutritionnisteDao;

    private NutritionnisteDaoImpl() { }

    public static NutritionnisteDao getInstance() {
        if (nutritionnisteDao == null) {
            nutritionnisteDao = new NutritionnisteDaoImpl();
        }
        return nutritionnisteDao;
    }

    public static final RowMapper<Nutritionniste> rowMapper = new RowMapper<Nutritionniste>() {
        @Override
        public Nutritionniste map(ResultSet res) throws SQLException {
            return new Nutritionniste(res.getInt("nutri.num_reference"), res.getString("nutri.nom"),
                    res.getString("nutri.prenom"), res.getString("nutri.avis")
            );
        }
    };

    public List<Nutritionniste> listingNutritionnistes() {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from nutritionniste nutri " +
                "order by nutri.num_reference";
        List<Nutritionniste> nutritionnistes = new ArrayList<Nutritionniste>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            try (ResultSet rs  = statement.executeQuery()) {
                while(rs.next()) {
                    nutritionnistes.add(rowMapper.map(rs));
                }
                return nutritionnistes;
            }
        } catch (SQLException e) {
            throw new NutritionnisteDaoException(e);
        }
    }

    /**
     *
     * @param coachMatricule
     * @return liste des nutritionnistes qui ont été choisis par les candidats qui eux-mêmes sont entrainés par un coach donné
     */
    public List<Nutritionniste> nutritionnistesDesCandidatsEntrainesParUnCoach(int coachMatricule) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select distinct nutri.num_reference, nutri.nom, nutri.prenom, nutri.avis " +
                "from nutritionniste nutri " +
                "join candidat candi on candi.nutritionniste_num_reference = nutri.num_reference " +
                "join coach co on candi.coach_matricule = co.matricule " +
                "and co.matricule = ?";

        List<Nutritionniste> nutritionnistes = new ArrayList<Nutritionniste>();

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setInt(1, coachMatricule);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    nutritionnistes.add(rowMapper.map(rs));
                }
                return nutritionnistes;
            }
        } catch (SQLException e) {
            throw new NutritionnisteDaoException(e);
        }
    }
}
