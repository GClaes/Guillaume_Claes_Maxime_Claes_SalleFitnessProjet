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
        return coachDao.listingCoach();
    }

    public int nbHeuresCoachingUtilisees(int matriculeCoach) {
        return coachDao.nbHeuresCoachingUtilisees(matriculeCoach);
    }

    public boolean coachExiste(int matriculeCoach) {
        return coachDao.coachExiste(matriculeCoach);
    }

    public double calculSalaireHebdomadaire(int matriculeCoach) {
        int nbHeuresCoachingHebdo = nbHeuresCoachingUtilisees(matriculeCoach);
        Coach coach = coachDao.obtentionCoach(matriculeCoach);

        return coach.getSalaireHoraire() * nbHeuresCoachingHebdo;
    }
}
