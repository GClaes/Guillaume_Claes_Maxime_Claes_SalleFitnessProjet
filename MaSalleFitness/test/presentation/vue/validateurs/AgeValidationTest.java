package presentation.vue.validateurs;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.*;

public class AgeValidationTest {

    private AgeValidation validation;
    public AgeValidationTest(){
        validation = new AgeValidation();
    }
    @Test
    public void validerAge(){
        LocalDate date = LocalDate.of(1995,10,25);
        boolean retour = validation.valider(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        assertTrue(retour);
    }

    @Test
    public void refuserAgePetit(){
        LocalDate date = LocalDate.of(2012,05,22);
        boolean retour = validation.valider(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        assertFalse(retour);
    }
}