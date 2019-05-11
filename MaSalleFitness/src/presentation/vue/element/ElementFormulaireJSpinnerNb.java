package presentation.vue.element;

import presentation.vue.validateur.Validation;
import javax.swing.*;

public class ElementFormulaireJSpinnerNb extends ElementFormulaire<JSpinner> {

    public ElementFormulaireJSpinnerNb(String text, Validation validation) {
        super(text, validation);
        JSpinner nb = new JSpinner();
        setField(nb);
    }
    public ElementFormulaireJSpinnerNb(String text, Validation validation, int valeurInit) {
        this(text, validation);
        setValue(valeurInit);
    }

    @Override
    public Object getValue() {
        return getField().getValue();
    }
    private void setValue(int value){
        getField().setValue(value);
    }

}
