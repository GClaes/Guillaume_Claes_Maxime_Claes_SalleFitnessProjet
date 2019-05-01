package dataAccess;

import dataAccess.exceptions.ConnectionException;
import model.Candidat;

public interface CandidatDataAccess {
    void ajoutCandidat(Candidat candidat) throws ConnectionException;

}
