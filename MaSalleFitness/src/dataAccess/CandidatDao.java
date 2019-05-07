package dataAccess;

import model.Candidat;

import java.util.ArrayList;

public interface CandidatDao {
    Candidat rechercherCandidat(int numeroInscription);
    ArrayList<Candidat> listingCandidats();
    void ajoutCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
    //void modifierCandidat(Candidat candidat);
}
