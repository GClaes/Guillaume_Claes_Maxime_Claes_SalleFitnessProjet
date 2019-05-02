package dataAccess.exceptions;

import model.Candidat;

public class AjoutCandidatException extends Exception {
    public AjoutCandidatException(Exception e) {
        super(e);
    }
}
