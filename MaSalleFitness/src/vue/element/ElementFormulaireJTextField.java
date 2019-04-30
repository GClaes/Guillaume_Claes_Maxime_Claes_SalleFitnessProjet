package vue.element;

import vue.validateur.*;

import javax.swing.*;

public class ElementFormulaireJTextField extends ElementFormulaire<JTextField> {

    public ElementFormulaireJTextField(String nom, int tailleField, Validation validation) {
        super(nom, validation);
        setField(new JTextField(tailleField));
    }

    @Override
    public Object getValue() {
        return getField().getText().toLowerCase();
    }


}