package business;

import dataAccess.CoachDao;
import dataAccess.CoachDaoImp;

public class CoachServiceImp implements CoachService {
    private CoachDao coachDao;

    public CoachServiceImp() {
        setCoachDao(new CoachDaoImp());
    }

    public void setCoachDao(CoachDao coachDao) {
        this.coachDao = coachDao;
    }
}
