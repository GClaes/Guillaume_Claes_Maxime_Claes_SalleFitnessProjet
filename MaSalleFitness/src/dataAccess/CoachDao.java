package dataAccess;

import model.Coach;

import java.util.ArrayList;

public interface CoachDao {
    ArrayList<Coach> listingCoachs();
    int nbHeuresCoachingUtilisees(int matriculeCoach);
    boolean coachExiste(int matriculeCoach);
    Coach obtentionCoach(int matriculeCoach);
    ArrayList<Coach> coachsDesCandidatsInscritsParUnResponsable(int responsableMatricule);
}
