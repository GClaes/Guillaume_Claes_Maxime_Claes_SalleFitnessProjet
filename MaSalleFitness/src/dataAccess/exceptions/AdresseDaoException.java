package dataAccess.exceptions;

public class AdresseDaoException extends RuntimeException {
    public AdresseDaoException(Exception e) {
        super(e);
    }
}
