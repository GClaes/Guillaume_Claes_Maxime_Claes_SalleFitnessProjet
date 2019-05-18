package presentation.vue.validateurs;

import org.junit.Test;

import static org.junit.Assert.*;

public class AndValidationTest {
    private Validation validateurVrai;
    private Validation validateurFaux;
    private Validation validateurVraiBis;
    private Validation validateurFauxBis;

    public AndValidationTest(){
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
    public void accepterVraiEtVrai(){
        AndValidation validation = new AndValidation(validateurVrai,validateurVraiBis);

        assertTrue(validation.valider(null));
    }

    @Test
    public void refuserFauxEtVrai(){
        AndValidation validation = new AndValidation(validateurVrai,validateurFaux);

        assertFalse(validation.valider(null));
    }
    @Test
    public void refuserFauxEtFaux(){
        AndValidation validation = new AndValidation(validateurFaux,validateurFauxBis);

        assertFalse(validation.valider(null));
    }

}