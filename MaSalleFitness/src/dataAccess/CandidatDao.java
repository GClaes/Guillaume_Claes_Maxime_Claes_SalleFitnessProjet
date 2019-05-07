package dataAccess;

import model.Candidat;

import java.util.ArrayList;

public interface CandidatDao {
    ArrayList<Candidat> listingCandidats();
    void ajoutCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
    Candidat rechercherCandidat(int numeroInscription);
    //void modifierCandidat(Candidat candidat);
}
