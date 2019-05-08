package business;

import model.Coach;

import java.util.ArrayList;

public interface CoachService {
    ArrayList<Coach> listingCoachs();
    int nbHeuresCoachingUtilisees(int matriculeCoach);
    boolean coachExiste(int matriculeCoach);
}
