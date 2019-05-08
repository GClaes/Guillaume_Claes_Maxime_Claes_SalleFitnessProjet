package dataAccess;

import model.Coach;

import java.util.ArrayList;

public interface CoachDao {
    ArrayList<Coach> listingCoach();
    int nbHeuresCoachingUtilisees(int matriculeCoach);
    boolean coachExiste(int matriculeCoach);
    Coach obtentionCoach(int matriculeCoach);
}
