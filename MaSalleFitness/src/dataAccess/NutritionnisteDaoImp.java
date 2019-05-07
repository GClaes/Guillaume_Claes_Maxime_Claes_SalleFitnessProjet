package dataAccess;

import dataAccess.exceptions.RechercherException;
import model.Nutritionniste;

import java.sql.*;
import java.util.ArrayList;

public class NutritionnisteDaoImp implements NutritionnisteDao {
    public static RowMapper<Nutritionniste> rowMapper = new RowMapper<Nutritionniste>() {
        @Override
        public Nutritionniste map(ResultSet res) throws SQLException {
            return new Nutritionniste(res.getInt("nutri.num_reference"), res.getString("nutri.nom"), res.getString("nutri.prenom"), res.getString("nutri.avis"));
        }
    };

    public ArrayList<Nutritionniste> listingNutritionnistes() {
        ArrayList<Nutritionniste> nutritionnistes = new ArrayList<Nutritionniste>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select * from nutritionniste nutri";
            statement = connection.prepareStatement(requete);
            res = statement.executeQuery();

            while(res.next()) {
                nutritionnistes.add(rowMapper.map(res));
            }
        } catch (SQLException e) {
            throw new RechercherException(e);
        } finally {
            try {
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new RechercherException(e);
            }
        }

        return nutritionnistes;
    }
}
