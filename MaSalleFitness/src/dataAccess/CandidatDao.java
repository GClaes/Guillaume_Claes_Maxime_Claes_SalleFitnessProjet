package dataAccess;

import model.Candidat;
import model.Coach;
import model.Nutritionniste;

import java.util.Date;
import java.util.List;

public interface CandidatDao {
    Candidat rechercherCandidat(int numeroInscription);
    List<Candidat> listingCandidats();
    void ajouterCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
    void modifierCandidat(Candidat candidat);
    List<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin);
    List<Candidat> candidatsDUnCoach(Coach coach);
    List<Candidat> candidatsDUnNutritionniste(Nutritionniste nutritionniste);
}
