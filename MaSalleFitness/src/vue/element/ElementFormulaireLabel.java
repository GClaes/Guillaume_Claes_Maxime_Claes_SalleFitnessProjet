package vue.element;

import vue.validateur.Validation;

import javax.swing.*;

public class ElementFormulaireLabel extends ElementFormulaire<JLabel> {
    public ElementFormulaireLabel(String text, Validation validation, JLabel label) {
        super(text, validation);
        setField(label);
    }

    @Override
    public Object getValue() {
        return null;
    }
}
