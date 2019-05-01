package dataAccess.exceptions;

import model.Candidat;

public class AjoutCandidatException extends Exception {
    public String getMessage(String s) {
        return "Erreur lors de l ajout du candidat : " + s;
    }
}
