package dataAccess;

import dataAccess.exceptions.AjoutCandidatException;
import model.Candidat;

public interface CandidatDataAccess {
    void ajoutCandidat(Candidat candidat) throws AjoutCandidatException;

}
