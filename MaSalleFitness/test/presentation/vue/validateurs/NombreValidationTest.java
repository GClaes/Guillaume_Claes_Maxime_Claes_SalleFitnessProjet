package presentation.vue.validateurs;

import org.junit.Test;

import static org.junit.Assert.*;

public class NombreValidationTest {

    @Test
    public void validerNombrePlusGrand(){
        NombreValidation validation = new NombreValidation(10, NombreValidation.Sens.PLUS_GRAND);

        assertTrue(validation.valider(15));
    }

    @Test
    public void validerNombresEgauxPlusGrand(){
        NombreValidation validation = new NombreValidation(10, NombreValidation.Sens.PLUS_GRAND);

        assertTrue(validation.valider(10));
    }

    @Test
    public void refuserNombrePlusGrand(){
        NombreValidation validation = new NombreValidation(10, NombreValidation.Sens.PLUS_GRAND);

        assertFalse(validation.valider(5));
    }

    @Test
    public void validerNombrePlusPetit(){
        NombreValidation validation = new NombreValidation(10, NombreValidation.Sens.PLUS_PETIT);

        assertTrue(validation.valider(7));
    }

    @Test
    public void refuserNombrePlusPetit(){
        NombreValidation validation = new NombreValidation(10, NombreValidation.Sens.PLUS_PETIT);

        assertFalse(validation.valider(15));
    }

    @Test
    public void validerNombresEgauxPlusPetit(){
        NombreValidation validation = new NombreValidation(10, NombreValidation.Sens.PLUS_PETIT);

        assertTrue(validation.valider(10));
    }
}