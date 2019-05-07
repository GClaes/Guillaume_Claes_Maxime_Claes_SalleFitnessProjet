package dataAccess;

import dataAccess.exceptions.RechercherException;
import model.Nutritionniste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NutritionnisteDaoImp implements NutritionnisteDao {
    public static RowMapper<Nutritionniste> rowMapper = new RowMapper<Nutritionniste>() {
        @Override
        public Nutritionniste map(ResultSet res) throws SQLException {
            return new Nutritionniste(res.getInt("num_reference"), res.getString("nom"), res.getString("prenom"), res.getString("avis"));
        }
    };

    public ArrayList<Nutritionniste> listingNutritionnistes() {
        ArrayList<Nutritionniste> nutritionnistes = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select * from nutritionniste";
            statement = connection.prepareStatement(requete);
            res = statement.executeQuery();

            while(res.next()) {
                nutritionnistes.add(rowMapper.map(res));
            }
        } catch (SQLException e) {
            throw new RechercherException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new RechercherException(e);
            }
        }

        return nutritionnistes;
    }
}
