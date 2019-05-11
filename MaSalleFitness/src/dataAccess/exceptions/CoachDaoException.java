package dataAccess.exceptions;

public class CoachDaoException extends RuntimeException {
    public CoachDaoException(Exception e) {
        super(e);
    }
}
