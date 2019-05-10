package dataAccess;

import model.Coach;

import java.util.List;

public interface CoachDao {
    List<Coach> listingCoachs();
    int nbHeuresCoachingUtilisees(int matriculeCoach);
    boolean coachExiste(int matriculeCoach);
    Coach obtentionCoach(int matriculeCoach);
    List<Coach> coachsDesCandidatsInscritsParUnResponsable(int responsableMatricule);
}
