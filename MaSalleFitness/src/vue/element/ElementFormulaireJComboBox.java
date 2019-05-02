package vue.element;

import vue.validateur.Validation;

import javax.swing.*;

public class ElementFormulaireJComboBox extends ElementFormulaire<JComboBox>{

    public ElementFormulaireJComboBox(String nom, String []values, Validation validation) {
        super(nom, validation);
        setField(new JComboBox(values));
    }

    @Override
    public Object getValue() {
        return getField().getSelectedIndex();
    }
}
