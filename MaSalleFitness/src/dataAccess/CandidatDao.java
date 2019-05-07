package dataAccess;

import model.Candidat;
import model.Coach;
import model.Nutritionniste;

import java.util.ArrayList;

public interface CandidatDao {
    //ArrayList<Candidat> listingCandidat();
    //ArrayList<Coach> listingCoach();
    //ArrayList<Nutritionniste> listingNutritionniste();
    //ArrayList<t> listing(String type);
    //void ajoutCandidat(Candidat candidat);
    //void modifierCandidat(Candidat candidat);
    //void supprimerCandidat(int numeroInscription);
    //Candidat rechercheCandidat(int numeroInscription);

    Candidat rechercherCandidat(int numeroInscription) throws Exception;
    ArrayList<Candidat> listingCandidats() throws Exception;
    public void ajoutCandidat(Candidat candidat) throws Exception;
    public void supprimerCandidat(int numeroInscription) throws Exception;
}
