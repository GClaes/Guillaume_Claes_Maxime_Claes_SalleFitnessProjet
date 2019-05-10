package business;

import model.Coach;

import java.util.List;

public interface CoachService {
    List<Coach> listingCoachs();
    int nbHeuresCoachingUtilisees(int matriculeCoach);
    Coach obtentionCoach(int matriculeCoach);
    List<Coach> coachsDesCandidatsInscritsParUnResponsable(int responsableMatricule);
    double calculSalaireHebdomadaire(int matriculeCoach);
}
