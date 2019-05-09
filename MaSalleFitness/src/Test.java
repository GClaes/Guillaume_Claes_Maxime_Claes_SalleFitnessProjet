import business.CandidatServiceImp;
import dataAccess.*;
import model.Adresse;
import model.Candidat;
import model.Coach;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        CandidatDao candidatDao = CandidatDaoImp.getInstance();
        Candidat candidat = candidatDao.rechercherCandidat(1);

        System.out.println(candidat.getNom());
        System.out.println(candidat.getCoach().getSalaireHoraire());
        System.out.println(candidat.getAdresse().getCode());

        CoachDao coachDao = CoachDaoImp.getInstance();
        ArrayList<Coach> coachs = coachDao.coachsParCandidatsParResponsable(1);

        for (int i = 0 ; i < coachs.size() ; i++) {
            System.out.println(coachs.get(i).getNom());
            System.out.println(coachs.get(i).getSalaireHoraire());
            for (int j = 0 ; j < coachs.get(i).getCandidats().size() ; j++) {
                System.out.println(coachs.get(i).getCandidats().get(i).getAdresse().getCode());
            }
        }
    }

}
