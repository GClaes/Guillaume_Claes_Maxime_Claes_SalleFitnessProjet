import dataAccess.AdresseDao;
import dataAccess.AdresseDaoImp;
import dataAccess.RowMapper;
import dataAccess.SingletonConnection;
import dataAccess.exceptions.AdresseExisteException;
import model.Adresse;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        AdresseDao dao = new AdresseDaoImp();
        Adresse adr = new Adresse("Gesves", "5340", "quelque part", "29a");
        String str = "0";

        if (dao.adresseUtilisee(str)) {
            System.out.println("utilisee");
        } else {
            System.out.println("pas utilisee");
        }

    }
}
