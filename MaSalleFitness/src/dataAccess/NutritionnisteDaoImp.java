package dataAccess;

import dataAccess.exceptions.ListingException;
import model.Nutritionniste;

import java.sql.*;
import java.util.ArrayList;

public class NutritionnisteDaoImp implements NutritionnisteDao {
    private static NutritionnisteDaoImp nutritionnisteDaoImp;

    private NutritionnisteDaoImp() { }

    public static NutritionnisteDaoImp getInstance() {
        if (nutritionnisteDaoImp == null) {
            nutritionnisteDaoImp = new NutritionnisteDaoImp();
        }
        return nutritionnisteDaoImp;
    }

    public static RowMapper<Nutritionniste> rowMapper = new RowMapper<Nutritionniste>() {
        @Override
        public Nutritionniste map(ResultSet res) throws SQLException {
            return new Nutritionniste(res.getInt("nutri.num_reference"), res.getString("nutri.nom"), res.getString("nutri.prenom"), res.getString("nutri.avis"));
        }
    };

    public ArrayList<Nutritionniste> listingNutritionnistes() {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select * from nutritionniste nutri";
        ArrayList<Nutritionniste> nutritionnistes = new ArrayList<Nutritionniste>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            try (ResultSet rs  = statement.executeQuery()) {
                while(rs.next()) {
                    nutritionnistes.add(rowMapper.map(rs));
                }
                return nutritionnistes;
            }
        } catch (SQLException e) {
            throw new ListingException(e);
        }
    }
}
