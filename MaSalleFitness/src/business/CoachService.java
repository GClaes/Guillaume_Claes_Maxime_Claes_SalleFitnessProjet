package business;

import model.Coach;

import java.util.ArrayList;

public interface CoachService {
    ArrayList<Coach> listingCoachs();
    int nbHeuresCoachingUtilisees(int matriculeCoach);
    Coach obtentionCoach(int matriculeCoach);
    ArrayList<Coach> coachsDesCandidatsInscritsParUnResponsable(int responsableMatricule);
    double calculSalaireHebdomadaire(int matriculeCoach);
}
