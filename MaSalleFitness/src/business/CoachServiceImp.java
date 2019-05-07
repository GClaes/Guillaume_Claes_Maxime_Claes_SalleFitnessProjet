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

    public ArrayList<Coach> listingCoach() {
        return coachDao.listingCoach();
    }

    public void setCoachDao(CoachDao coachDao) {
        this.coachDao = coachDao;
    }
}
