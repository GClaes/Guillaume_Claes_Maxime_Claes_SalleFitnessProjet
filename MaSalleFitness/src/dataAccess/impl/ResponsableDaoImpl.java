package dataAccess.impl;

import dataAccess.ResponsableDao;
import dataAccess.exceptions.ResponsableDaoException;
import model.Responsable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResponsableDaoImpl implements ResponsableDao {
    private static ResponsableDao responsableDao;

    private ResponsableDaoImpl() { }

    public static ResponsableDao getInstance() {
        if (responsableDao == null) {
            responsableDao = new ResponsableDaoImpl();
        }
        return responsableDao;
    }

    public static final RowMapper<Responsable> rowMapper = new RowMapper<Responsable>() {
        @Override
        public Responsable map(ResultSet res) throws SQLException {
            return new Responsable(res.getInt("resp.matricule"), res.getString("resp.nom"), res.getString("resp.prenom"));
        }
    };

    public List<Responsable> listingResponsables() {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select matricule, nom, prenom from responsable resp";
        List<Responsable> responsables = new ArrayList<Responsable>();

        try (PreparedStatement statement = connection.prepareStatement(requete)){
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    responsables.add(rowMapper.map(rs));
                }
                return responsables;
            }
        } catch (SQLException e) {
            throw new ResponsableDaoException(e);
        }
    }
}
