package dataAccess.exceptions;

import model.Candidat;

public class AjoutCandidatException extends Exception {
    private Candidat candidatErrone;

    public AjoutCandidatException(Candidat candidatErrone) {
        this.candidatErrone = candidatErrone;
    }

    @Override
    public String getMessage() {
        return "Erreur lors de l ajout du candidat";
    }
}
