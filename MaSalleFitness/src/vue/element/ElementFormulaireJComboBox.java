package vue.element;

import vue.validateur.Validation;

import javax.swing.*;

public class ElementFormulaireJComboBox extends ElementFormulaire<JComboBox>{

    public ElementFormulaireJComboBox(String nom, String []valuesSexe, Validation validation) {
        super(nom, validation);
        setField(new JComboBox(valuesSexe));
    }

    @Override
    public Object getValue() {
        return getField().getSelectedIndex();
    }
}
