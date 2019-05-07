package dataAccess;

import model.Adresse;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
}
