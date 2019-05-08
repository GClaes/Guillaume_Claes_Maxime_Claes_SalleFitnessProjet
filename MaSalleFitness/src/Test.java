import dataAccess.*;
import dataAccess.exceptions.AdresseExisteException;
import model.Adresse;
import model.Coach;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        CoachDao dao = new CoachDaoImp();
        /*
        ArrayList<Coach> coachs;

        coachs = dao.listingCoach();

        for (int i = 0 ; i < coachs.size() ; i++) {
            System.out.println(coachs.get(i).getMatricule());
        }
        */

        /*
        if (dao.coachExiste(1)) {
            System.out.println("oui");
        } else {
            System.out.println("non");
        }
        */

        Coach coach = dao.obtentionCoach(0);
        System.out.println(coach.getNom());

    }
}
