package dataAccess.imp;

import dataAccess.AdresseDao;
import dataAccess.RowMapper;
import dataAccess.exceptions.*;
import model.Adresse;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseDaoImp implements AdresseDao {
    private static AdresseDao adresseDao;

    private AdresseDaoImp() { }

    public static AdresseDao getInstance() {
        if (adresseDao == null) {
            adresseDao = new AdresseDaoImp();
        }
        return adresseDao;
    }

    public static RowMapper<Adresse> rowMapper = new RowMapper<Adresse>() {
        @Override
        public Adresse map(ResultSet res) throws SQLException {
            Adresse adresse = new Adresse(res.getString("adr.localite"), res.getString("adr.code_postal"),
                    res.getString("adr.rue"), res.getString("adr.numero")
            );

            try {
                Field field = Adresse.class.getDeclaredField("code");
                field.setAccessible(true);
                field.set(adresse, res.getString("adr.code_hash"));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }

            return adresse;
        }
    };

    public boolean adresseExiste(String codeHash) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select count(*) from adresse where code_hash = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setString(1, codeHash);

            try (ResultSet rs = statement.executeQuery()) {
                rs.next();
                return rs.getInt(1) >= 1;
            }
        } catch (SQLException e) {
            throw new AdresseExisteException(e);
        }
    }

    public void ajouterAdresse(Adresse adresse) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "insert into adresse (code_hash, localite, code_postal, rue, numero) " +
                "values (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setString(1, adresse.getCode());
            statement.setString(2, adresse.getLocalite());
            statement.setString(3, adresse.getCodePostal());
            statement.setString(4, adresse.getRue());
            statement.setString(5, adresse.getNumero());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new AjouterAdresseException(e);
        }
    }

    public boolean supprimerAdresse(String codeHash) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "delete from adresse where code_hash = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setString(1, codeHash);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new SupprimerAdresseException(e);
        }
    }

    public boolean adresseUtilisee(String codeHash) {
        Connection connection = SingletonConnection.getInstance();
        String requete = "select count(*) from candidat where adresse_code_hash = ?";

        try (PreparedStatement statement = connection.prepareStatement(requete)) {
            statement.setString(1, codeHash);

            try (ResultSet rs = statement.executeQuery()) {
                rs.next();
                return rs.getInt(1) >= 1;
            }
        } catch (SQLException e) {
            throw new AdresseUtiliseeException(e);
        }
    }
}