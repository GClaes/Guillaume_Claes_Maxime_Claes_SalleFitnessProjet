package presentation.vue.validateurs;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrValidationTest {
    private Validation validateurVrai;
    private Validation validateurFaux;
    private Validation validateurVraiBis;
    private Validation validateurFauxBis;

    public OrValidationTest(){
        validateurVrai = new Validation() {
            @Override
            public boolean valider(Object o) {
                return true;
            }
        };

        validateurFaux = new Validation() {
            @Override
            public boolean valider(Object o) {
                return false;
            }
        };
        validateurVraiBis = new Validation() {
            @Override
            public boolean valider(Object o) {
                return true;
            }
        };
        validateurFauxBis = new Validation() {
            @Override
            public boolean valider(Object o) {
                return false;
            }
        };
    }

    @Test
    public void accepterVraiOuVrai(){
        OrValidation validation = new OrValidation(validateurVrai,validateurVraiBis);

        assertTrue(validation.valider(null));
    }

    @Test
    public void refuserFauxOuVrai(){
        OrValidation validation = new OrValidation(validateurVrai,validateurFaux);

        assertTrue(validation.valider(null));
    }
    @Test
    public void refuserFauxOuFaux(){
        OrValidation validation = new OrValidation(validateurFaux,validateurFauxBis);

        assertFalse(validation.valider(null));
    }

}