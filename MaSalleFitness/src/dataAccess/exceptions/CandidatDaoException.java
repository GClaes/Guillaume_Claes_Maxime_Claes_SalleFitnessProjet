package dataAccess.exceptions;

public class CandidatDaoException extends RuntimeException {
    public CandidatDaoException(Exception e) {
        super(e);
    }
}
