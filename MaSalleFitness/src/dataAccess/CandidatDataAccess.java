package dataAccess;

import dataAccess.exceptions.AjoutCandidatException;
import model.Candidat;

public interface CandidatDataAccess {
    void modifierCandidat(Candidat candidat) throws AjoutCandidatException;
    Candidat rechercheCandidat(int numeroInscription) throws Exception;
}
