package business;

import model.Candidat;

import java.util.ArrayList;

public interface CandidatService {
    Candidat rechercherCandidat(int numeroInscription);
    ArrayList<Candidat> listingCandidats();
    void ajoutCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
}
