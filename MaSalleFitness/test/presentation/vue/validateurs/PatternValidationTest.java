package presentation.vue.validateurs;

import org.junit.Test;

import static org.junit.Assert.*;

public class PatternValidationTest {

    private String pattern = "[0-9]";
    private PatternValidation validation;
    public PatternValidationTest(){
        validation = new PatternValidation(pattern);
    }

    @Test
    public void accepterPatternChiffre(){
        assertTrue(validation.valider("7"));
    }

    @Test
    public void refuserPatternLettre(){
        assertFalse(validation.valider("c"));
    }

    @Test
    public void refuserPatternEspace(){
        assertFalse(validation.valider(" "));
    }

    @Test
    public void refuserPatternChiffreTropGrand(){
        assertFalse(validation.valider("15"));
    }

}