package model.exceptions;

import java.util.Date;

public class DateTestValideException extends IllegalArgumentException {
    private Date dateTestValideErronee;

    public DateTestValideException(Date dateTestValideErronee) {
        this.dateTestValideErronee = dateTestValideErronee;
    }

    @Override
    public String getMessage() {
        return "La date de test valide est erronée et vaut " + dateTestValideErronee;
    }

}
