package business;

import model.Candidat;

import java.util.Date;
import java.util.List;

public interface CandidatService {
    Candidat rechercherCandidat(int numeroInscription);
    List<Candidat> listingCandidats();
    void ajoutCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
    void modifierCandidat(Candidat candidat);
    List<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin);
}
