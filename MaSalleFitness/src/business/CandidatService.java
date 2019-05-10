package business;

import model.Candidat;
import model.Coach;
import model.Nutritionniste;

import java.util.Date;
import java.util.List;

public interface CandidatService {
    Candidat rechercherCandidat(int numeroInscription);
    List<Candidat> listingCandidats();
    void ajoutCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
    void modifierCandidat(Candidat candidat);
    List<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin);
    List<Candidat> candidatsDUnCoach(Coach coach);
    List<Candidat> candidatsDUnNutritionniste(Nutritionniste nutritionniste);
}
