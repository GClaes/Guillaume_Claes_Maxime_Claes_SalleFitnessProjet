package dataAccess.exceptions;

public class ConnectionException extends Exception {
    @Override
    public String getMessage() {
        return "Erreur lors de la connection a la base de données";
    }
}
