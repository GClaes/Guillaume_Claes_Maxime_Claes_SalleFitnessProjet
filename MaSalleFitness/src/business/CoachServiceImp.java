package business;

import dataAccess.CoachDao;
import dataAccess.CoachDaoImp;
import model.Coach;

import java.util.ArrayList;

public class CoachServiceImp implements CoachService {
    private CoachDao coachDao;

    public CoachServiceImp() {
        setCoachDao(new CoachDaoImp());
    }

    public ArrayList<Coach> listingCoachs() {
        return coachDao.listingCoach();
    }

    public int nbHeuresCoachingUtilisees(int matriculeCoach) {
        return coachDao.nbHeuresCoaching(matriculeCoach);
    }

    public boolean coachExiste(int matriculeCoach) {
        return coachDao.coachExiste(matriculeCoach);
    }

    public double calculSalaireHebdomadaire(int matriculeCoach) {
        int nbHeuresCoachingHebdo = nbHeuresCoachingUtilisees(matriculeCoach);
        Coach coach = coachDao.obtentionCoach(matriculeCoach);

        return coach.getSalaireHoraire() * nbHeuresCoachingHebdo;
    }

    public void setCoachDao(CoachDao coachDao) {
        this.coachDao = coachDao;
    }
}
