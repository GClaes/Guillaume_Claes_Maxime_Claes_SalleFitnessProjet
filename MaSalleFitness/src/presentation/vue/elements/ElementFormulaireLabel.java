package presentation.vue.elements;

import javax.swing.*;

public class ElementFormulaireLabel extends ElementFormulaire<JLabel> {
    public ElementFormulaireLabel(String text, JLabel label) {
        super(text, null);
        setField(label);
    }

    @Override
    public Object getValue() {
        return null;
    }
}
