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
        return coachDao.nbHeuresCoachingUtilisees(matriculeCoach);
    }

    public boolean coachExiste(int matriculeCoach) {
        return coachDao.coachExiste(matriculeCoach);
    }

    public void setCoachDao(CoachDao coachDao) {
        this.coachDao = coachDao;
    }
}
