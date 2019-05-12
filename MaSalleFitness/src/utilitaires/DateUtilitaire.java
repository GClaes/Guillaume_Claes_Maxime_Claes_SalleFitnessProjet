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

    public static int compareDateSansHeures(Date dateUne, Date dateDeux) {
        Calendar date1 = Calendar.getInstance();
        date1.setTime(dateUne);
        Calendar date2= Calendar.getInstance();
        date2.setTime(dateDeux);

        int anneesDifference = date1.get(Calendar.YEAR) - date2.get(Calendar.YEAR);
        int moisDifference = date1.get(Calendar.MONTH) - date2.get(Calendar.MONTH);
        int joursDifference = date1.get(Calendar.DAY_OF_MONTH) - date2.get(Calendar.DAY_OF_MONTH);

        if (anneesDifference < 0) {
            return -1;
        }
        if (anneesDifference > 0) {
            return 1;
        }

        if (moisDifference < 0) {
            return -1;
        }
        if (moisDifference > 0) {
            return 1;
        }

        if (joursDifference < 0) {
            return -1;
        }
        if (joursDifference > 0) {
            return 1;
        }

        return 0;


    }
}
