package dataAccess.exceptions;

public class ConnectionException extends Exception {
    public String getMessage(Object s) {
        return "Erreur lors de la connection a la base de données, ";
    }
}
