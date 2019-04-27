package model.exceptions;

public class MaladiesChroniquesException extends Exception {
    private String maladiesChroniquesErronee;

    public MaladiesChroniquesException(String maladiesChroniquesErronee) {
        this.maladiesChroniquesErronee = maladiesChroniquesErronee;
    }

    public String getMessage() {
        return "La/les maladie(s) chronique(s) est/sont erronee(s) et vaut/valent " + maladiesChroniquesErronee;
    }
}
