package presentation.vue.validateurs;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasVideValidationTest {
    private PasVideValidation validation;

    public PasVideValidationTest(){
        validation = new PasVideValidation();
    }

    @Test
    public void validerStringNonvide() {
        assertTrue(validation.valider("test valide"));
    }

    @Test
    public void refuserStringVide(){
        assertFalse(validation.valider(""));
    }

    @Test
    public void refuserStringNull(){
        assertFalse(validation.valider(null));
    }

    @Test
    public void refuserStringEspace(){
        assertFalse(validation.valider(" "));
    }
}