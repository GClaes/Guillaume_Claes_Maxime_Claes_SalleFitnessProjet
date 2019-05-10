package business;

import model.Candidat;

import java.util.ArrayList;
import java.util.Date;

public interface CandidatService {
    Candidat rechercherCandidat(int numeroInscription);
    ArrayList<Candidat> listingCandidats();
    void ajoutCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
    void modifierCandidat(Candidat candidat);
    ArrayList<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin);
}
