import dataAccess.*;
import dataAccess.exceptions.AdresseExisteException;
import model.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        /*
        CandidatDao daoCandidat = new CandidatDaoImp();
        CoachDao daoCoach = new CoachDaoImp();
        ResponsableDao daoResponsable = new ResponsableDaoImp();
        NutritionnisteDao daoNutritionniste = new NutritionnisteDaoImp();
        AdresseDao daoAdresse = new AdresseDaoImp();

        Date date = new Date(1995, 5, 5);
        Coach coach = daoCoach.obtentionCoach(1);
        Responsable responsable = new Responsable(1, "meurdesoif", "jean");
        Nutritionniste nutritionniste = new Nutritionniste(1, "cohen", "jean-michel ","tres bon nutritionniste");
        Adresse adresse = new Adresse("bruxelles", "1049", "rue de la loi", "86");
        Candidat candidat = new Candidat(1, "coucou", "hello", date, 'h', coach, responsable, nutritionniste, adresse);

        daoCandidat.ajouterCandidat(candidat);

         */
/*
        ArrayList<Candidat> candidats;

        candidats = dao.listingCandidats();

        for (int i = 0 ; i < candidats.size() ; i++) {
            System.out.println(candidats.get(i).getNom());
        }
*/

        /*
        if (dao.coachExiste(1)) {
            System.out.println("oui");
        } else {
            System.out.println("non");
        }
        */

        /*
        Candidat candidat = dao.rechercherCandidat(8);
        System.out.println(candidat.getNom());
        */

        CandidatDao daoCandidat = new CandidatDaoImp();
        daoCandidat.supprimerCandidat(8);
    }
}
