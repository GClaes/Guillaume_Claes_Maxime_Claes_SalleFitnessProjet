package business.impl;

import business.CoachService;
import dataAccess.CoachDao;
import dataAccess.impl.CoachDaoImpl;
import model.Coach;

import java.util.List;

public class CoachServiceImpl implements CoachService {
    private CoachDao coachDao = CoachDaoImpl.getInstance();
    private static CoachService coachService;

    private CoachServiceImpl() { }

    public static CoachService getInstance() {
        if (coachService == null) {
            coachService = new CoachServiceImpl();
        }
        return coachService;
    }

    public List<Coach> listingCoachs() {
        return coachDao.listingCoachs();
    }

    public int nbHeuresCoachingUtilisees(int matriculeCoach) {
        return coachDao.nbHeuresCoachingUtilisees(matriculeCoach);
    }

    public Coach obtentionCoach(int matriculeCoach) {
        return coachDao.obtentionCoach(matriculeCoach);
    }

    public List<Coach> coachsDesCandidatsInscritsParUnResponsable(int responsableMatricule) {
        return coachDao.coachsDesCandidatsInscritsParUnResponsable(responsableMatricule);
    }

    public double calculSalaireHebdomadaire(int matriculeCoach) {
        int nbHeuresCoachingHebdo = nbHeuresCoachingUtilisees(matriculeCoach);
        Coach coach = coachDao.obtentionCoach(matriculeCoach);

        return coach.getSalaireHoraire() * nbHeuresCoachingHebdo;
    }
}
