package business.imp;

import business.CoachService;
import dataAccess.CoachDao;
import dataAccess.imp.CoachDaoImp;
import model.Coach;

import java.util.ArrayList;

public class CoachServiceImp implements CoachService {
    private final CoachDao coachDao = CoachDaoImp.getInstance();
    private static CoachService coachService;

    private CoachServiceImp() { }

    public static CoachService getInstance() {
        if (coachService == null) {
            coachService = new CoachServiceImp();
        }
        return coachService;
    }

    public ArrayList<Coach> listingCoachs() {
        return coachDao.listingCoachs();
    }

    public int nbHeuresCoachingUtilisees(int matriculeCoach) {
        return coachDao.nbHeuresCoachingUtilisees(matriculeCoach);
    }

    public Coach obtentionCoach(int matriculeCoach) {
        return coachDao.obtentionCoach(matriculeCoach);
    }

    public ArrayList<Coach> coachsDesCandidatsInscritsParUnResponsable(int responsableMatricule) {
        return coachsDesCandidatsInscritsParUnResponsable(responsableMatricule);
    }

    public double calculSalaireHebdomadaire(int matriculeCoach) {
        int nbHeuresCoachingHebdo = nbHeuresCoachingUtilisees(matriculeCoach);
        Coach coach = coachDao.obtentionCoach(matriculeCoach);

        return coach.getSalaireHoraire() * nbHeuresCoachingHebdo;
    }
}
