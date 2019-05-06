package dataAccess;

import model.Responsable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponsableDaoImp implements ResponsableDao {
    public static RowMapper<Responsable> rowMapper = new RowMapper<Responsable>() {
        @Override
        public Responsable map(ResultSet res) throws SQLException {
            return new Responsable(res.getInt("matricule"), res.getString("nom"), res.getString("prenom"));
        }
    };
}
