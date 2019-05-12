package presentation.vue.elements;

import javax.swing.*;

public class ElementFormulaireJComboBox extends ElementFormulaire<JComboBox> {

    public ElementFormulaireJComboBox(String label, String []values) {
        super(label, null);
        setField(new JComboBox<>(values));
    }

    public ElementFormulaireJComboBox(String label,String []values, int valeurInit) {
        this(label, values);
        setValue(valeurInit);
    }

    @Override
    public Object getValue() {
        return getField().getSelectedIndex();
    }
    private void setValue(int i){
        getField().setSelectedIndex(i);
    }
}
