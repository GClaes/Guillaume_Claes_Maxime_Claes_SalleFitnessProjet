package utilitaires;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtilitaire {
    public static int age(Date dateNaissance) {
        int anneesDifference;
        int moisDifference;
        int joursDifference;

        GregorianCalendar today = new GregorianCalendar();
        Calendar naissance = Calendar.getInstance();
        naissance.setTime(dateNaissance);

        anneesDifference = today.get(Calendar.YEAR) - naissance.get(Calendar.YEAR);
        moisDifference = today.get(Calendar.MONTH) - naissance.get(Calendar.MONTH);
        joursDifference = today.get(Calendar.DAY_OF_MONTH) - naissance.get(Calendar.DAY_OF_MONTH);

        if (moisDifference < 0) {
            return anneesDifference - 1;
        }

        if (moisDifference > 0) {
            return anneesDifference;
        }

        if (joursDifference < 0) {
            return anneesDifference - 1;
        }

        return anneesDifference;
    }

    public static int compareDate(Date dateUne, Date dateDeux) {
        return 1;
    }
}
