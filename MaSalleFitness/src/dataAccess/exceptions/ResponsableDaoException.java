package dataAccess.exceptions;

public class ResponsableDaoException extends RuntimeException {
    public ResponsableDaoException(Exception e) {
        super(e);
    }
}
