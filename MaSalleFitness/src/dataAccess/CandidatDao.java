package dataAccess;

import model.Candidat;
import model.Responsable;

import java.util.ArrayList;
import java.util.Date;

public interface CandidatDao {
    Candidat rechercherCandidat(int numeroInscription);
    ArrayList<Candidat> listingCandidats();
    void ajouterCandidat(Candidat candidat);
    void supprimerCandidat(int numeroInscription);
    void modifierCandidat(Candidat candidat);
    ArrayList<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin);
}
