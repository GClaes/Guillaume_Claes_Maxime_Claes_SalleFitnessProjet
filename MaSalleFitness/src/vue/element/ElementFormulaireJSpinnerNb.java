package vue.element;

import vue.validateur.Validation;

import javax.swing.*;

public class ElementFormulaireJSpinnerNb extends ElementFormulaire<JSpinner> {

    public ElementFormulaireJSpinnerNb(String text, Validation validation) {
        super(text, validation);
        JSpinner nb = new JSpinner();
        setField(nb);
    }
    @Override
    public Object getValue() {
        return getField().getValue();
    }
}
