package model.exceptions;

import java.util.Date;

public class DateTestValideException extends Exception {
    private Date dateTestValideErrone;

    public DateTestValideException(Date dateTestValideErrone) {
        this.dateTestValideErrone = dateTestValideErrone;
    }

    @Override
    public String getMessage() {
        return "La date du test valide est errone et vaut " + dateTestValideErrone;
    }
}
