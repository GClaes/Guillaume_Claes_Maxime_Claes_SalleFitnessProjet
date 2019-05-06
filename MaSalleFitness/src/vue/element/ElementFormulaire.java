package vue.element;

import vue.validateur.Validation;

import javax.swing.*;
import java.awt.*;

public abstract class ElementFormulaire<T extends  JComponent> extends JComponent {
    private JLabel label;
    private T field;
    private Validation validation;

    public ElementFormulaire(String text, Validation validation){
        label = new JLabel(text);
        label.setFont(new Font("Gras",Font.BOLD,20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.validation = validation;
    }

    public abstract Object getValue();

    protected void setField(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }

    public JLabel getLabel() {
        return label;
    }
    public void setLabel(JLabel nvLabel){
        label = nvLabel;
    }
    public boolean valider(){
        return validation.valider(getValue());
    }

}
