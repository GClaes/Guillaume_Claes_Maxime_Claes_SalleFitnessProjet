package dataAccess;

import model.Candidat;

import java.util.Date;
import java.util.List;

public interface CandidatDao {
    Candidat rechercherCandidat(int numeroInscription);
    List<Candidat> listingCandidats();
    void ajouterCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
    void modifierCandidat(Candidat candidat);
    List<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin);
}
