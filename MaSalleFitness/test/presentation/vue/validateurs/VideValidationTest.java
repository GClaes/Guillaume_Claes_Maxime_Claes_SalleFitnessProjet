package presentation.vue.validateurs;

import org.junit.Test;

import static org.junit.Assert.*;

public class VideValidationTest {
    private VideValidation validation;

    public VideValidationTest(){
        validation = new VideValidation();
    }

    @Test
    public void accepterVide(){
        assertTrue(validation.valider(""));
    }

    @Test
    public void accepterNull(){
        assertTrue(validation.valider(null));
    }

    @Test
    public void accepterEspace(){
        assertTrue(validation.valider("  "));
    }

    @Test
    public void refuserContenu(){
        assertFalse(validation.valider("Ceci est un test"));
    }

}