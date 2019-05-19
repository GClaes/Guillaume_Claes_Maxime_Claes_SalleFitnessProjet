package model;

import model.exceptions.DateNaissanceException;
import model.exceptions.DateTestValideException;
import model.exceptions.NbHeuresCoachingException;
import model.exceptions.SexeException;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CandidatTest {
    Coach coach = new Coach(1, "NomCoachTest", "PrenomCoachTest", null, 10.55, new Date());
    Responsable responsable = new Responsable(2, "NomResponsableTest", "PrenomResponsableTest");
    Nutritionniste nutritionniste = new Nutritionniste(3, "NomNutritionnisteTest", "PrenomNutritionnisteTest", null);
    Adresse adresse = new Adresse("Hondelange", "6780", "Emile-Kirsch", "29");
    LocalDate dateN = LocalDate.of(1995, 10, 25);
    Date dateNaissanceCandidat = Date.from(dateN.atStartOfDay(ZoneId.systemDefault()).toInstant());

    @Test(expected = NbHeuresCoachingException.class)
    public void doitDonnerUneExceptionSiNbHeuresCoachingEgalZero() {
        Candidat candidat = new Candidat(0, "NbHeuresCoachingException", "NbHeuresCoachingException", dateNaissanceCandidat, 'h', coach, responsable, nutritionniste, adresse);
        candidat.setNbHeuresCoaching(0);
    }

    @Test(expected = NbHeuresCoachingException.class)
    public void doitDonnerUneExceptionSiNbHeuresCoachingNegatif() {
        Candidat candidat = new Candidat(-1, "NbHeuresCoachingException", "NbHeuresCoachingException", dateNaissanceCandidat, 'h', coach, responsable, nutritionniste, adresse);
        candidat.setNbHeuresCoaching(0);
    }

    @Test(expected = NbHeuresCoachingException.class)
    public void doitDonnerUneExceptionSiNbHeuresCoachingNull() {
        Candidat candidat = new Candidat(null, "NbHeuresCoachingException", "NbHeuresCoachingException", dateNaissanceCandidat, 'h', coach, responsable, nutritionniste, adresse);
        candidat.setNbHeuresCoaching(0);
    }

    @Test(expected = DateNaissanceException.class)
    public void doitDonnerUneExceptionSiAgeAvantAgeMinimum() {
        LocalDate toDay = LocalDate.now();
        LocalDate dateN = LocalDate.of(toDay.getYear() + 1 - Candidat.AGE_MINIMUM, toDay.getMonth(), toDay.getDayOfMonth());
        Date dateNaissanceEronnee = Date.from(dateN.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Candidat candidat = new Candidat(1, "DateNaissanceException", "DateNaissanceException", dateNaissanceEronnee, 'h', coach, responsable, nutritionniste, adresse);
    }

    @Test(expected = DateNaissanceException.class)
    public void doitDonnerUneExceptionSiAgeNull() {
        Candidat candidat = new Candidat(1, "DateNaissanceException", "DateNaissanceException", null, 'h', coach, responsable, nutritionniste, adresse);
    }

    @Test(expected = DateTestValideException.class)
    public void doitDonnerUneExceptionSiDateTestValideAvantDateInscription() {
        Candidat candidat = new Candidat(1, "DateTestValideException", "DateTestValideException", dateNaissanceCandidat, 'h', coach, responsable, nutritionniste, adresse);

        LocalDate dateT = LocalDate.of(2000, 01, 01);
        Date dateTestValide = Date.from(dateT.atStartOfDay(ZoneId.systemDefault()).toInstant());
        candidat.setDateTestValide(dateTestValide);
    }

    @Test
    public void doitDonnerNumeroDeGsmNullSiEntreeVide() {
        Candidat candidat = new Candidat(1, "DateTestValideException", "DateTestValideException", dateNaissanceCandidat, 'h', coach, responsable, nutritionniste, adresse);
        candidat.setNumeroGSM("");
        assertNull(candidat.getNumeroGSM());
    }

    @Test
    public void doitDonnerNumeroDeGsmNullSiEntreeNull() {
        Candidat candidat = new Candidat(1, "DateTestValideException", "DateTestValideException", dateNaissanceCandidat, 'h', coach, responsable, nutritionniste, adresse);
        candidat.setNumeroGSM(null);
        assertNull(candidat.getNumeroGSM());
    }

    @Test(expected = SexeException.class)
    public void doitDonnerUneExceptionSiSexeVide() {
        Candidat candidat = new Candidat(1, "DateTestValideException", "DateTestValideException", dateNaissanceCandidat, ' ', coach, responsable, nutritionniste, adresse);
    }


}