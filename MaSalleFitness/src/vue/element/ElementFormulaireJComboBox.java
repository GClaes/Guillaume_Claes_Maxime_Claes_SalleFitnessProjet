package vue.element;

import vue.validateur.Validation;

import javax.swing.*;

public class ElementFormulaireJComboBox extends ElementFormulaire<JComboBox>{

    public ElementFormulaireJComboBox(String nom, String []values, Validation validation) {
        super(nom, validation);
        setField(new JComboBox(values));
    }

    public ElementFormulaireJComboBox(String nom,String []values, Validation validation, int valeurInit) {
        this(nom, values, validation);
        setValue(valeurInit);
    }

    @Override
    public Object getValue() {
        return getField().getSelectedIndex();
    }
    private void setValue(int i){
        getField().setSelectedItem(i);
    }
}
