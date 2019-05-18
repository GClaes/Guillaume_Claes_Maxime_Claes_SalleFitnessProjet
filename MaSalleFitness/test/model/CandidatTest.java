package model;

import model.exceptions.DateNaissanceException;
import model.exceptions.DateTestValideException;
import model.exceptions.NbHeuresCoachingException;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CandidatTest {
    Coach coach = new Coach(1, "NomCoachTest", "PrenomCoachTest", null, 10.55, new Date());
    Responsable responsable = new Responsable(2, "NomResponsableTest", "PrenomResponsableTest");
    Nutritionniste nutritionniste = new Nutritionniste(3, "NomNutritionnisteTest", "PrenomNutritionnisteTest", null);
    Adresse adresse = new Adresse("Hondelange", "6780", "Emile-Kirsch", "29");

    @Test(expected = NbHeuresCoachingException.class)
    public void doitDonnerUneExceptionSiNbHeuresCoachingEgalZero() {
        LocalDate dateN = LocalDate.of(1995, 10, 25);
        Date dateNaissance = Date.from(dateN.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Candidat candidat = new Candidat(1, "NbHeuresCoachingException", "NbHeuresCoachingException", dateNaissance, 'h', coach, responsable, nutritionniste, adresse);
        candidat.setNbHeuresCoaching(0);
    }

    @Test(expected = DateNaissanceException.class)
    public void doitDonnerUneExceptionSiAgeAvantAgeMinimum() {
        LocalDate toDay = LocalDate.now();
        LocalDate dateN = LocalDate.of(toDay.getYear() + 1 - Candidat.AGE_MINIMUM, toDay.getMonth(), toDay.getDayOfMonth());
        Date dateNaissance = Date.from(dateN.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Candidat candidat = new Candidat(1, "DateNaissanceException", "DateNaissanceException", dateNaissance, 'h', coach, responsable, nutritionniste, adresse);
    }

    @Test(expected = DateTestValideException.class)
    public void doitDonnerUneExceptionSiDateTestValideAvantDateInscription() {
        LocalDate dateN = LocalDate.of(1995, 10, 25);
        Date dateNaissance = Date.from(dateN.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Candidat candidat = new Candidat(1, "DateTestValideException", "DateTestValideException", dateNaissance, 'h', coach, responsable, nutritionniste, adresse);

        LocalDate dateT = LocalDate.of(2000, 01, 01);
        Date dateTestValide = Date.from(dateT.atStartOfDay(ZoneId.systemDefault()).toInstant());
        candidat.setDateTestValide(dateTestValide);
    }


}