package dataAccess;

import dataAccess.exceptions.AjoutAdresseException;
import dataAccess.exceptions.RechercheAdresseException;
import model.Adresse;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseDaoImp implements AdresseDao {
    public static RowMapper<Adresse> rowMapper = new RowMapper<Adresse>() {
        @Override
        public Adresse map(ResultSet res) throws SQLException {
            Adresse adresse = new Adresse(res.getString("localite"), res.getString("code_postal"), res.getString("rue"), res.getString("numero"));

            try {
                Field field = Adresse.class.getDeclaredField("code");
                field.setAccessible(true);
                field.set(adresse, res.getString("code_hash"));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }

            return adresse;
        }
    };

    public boolean adresseExiste(String codeHash) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;
        boolean existe;

        try {
            connection = SingletonConnection.getInstance();
            requete = "select count(*) from adresse where code_hash = ?";

            statement = connection.prepareStatement(requete);
            statement.setString(1, codeHash);
            res = statement.executeQuery();

            res.next();
            existe = res.getInt(1) == 1;
        } catch (SQLException e) {
            throw new RechercheAdresseException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new RechercheAdresseException(e);
            }
        }

        return existe;
    }

    public void ajouterAdresse(Adresse adresse) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String requete;
        try {
            connection = SingletonConnection.getInstance();
            requete = "insert into adresse (code_hash, localite, code_postal, rue, numero) " +
                    "values (?, ?, ?, ?, ?)";

            statement = connection.prepareStatement(requete);

            statement.setString(1, adresse.getCode());
            statement.setString(2, adresse.getLocalite());
            statement.setString(3, adresse.getCodePostal());
            statement.setString(4, adresse.getRue());
            statement.setString(5, adresse.getNumero());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new AjoutAdresseException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                res.close();
            } catch (SQLException e) {
                throw new AjoutAdresseException(e);
            }
        }

    }
}
