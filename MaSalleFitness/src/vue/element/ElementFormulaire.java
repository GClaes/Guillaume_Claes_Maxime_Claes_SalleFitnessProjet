package vue;

import javax.swing.*;
import java.awt.*;

public abstract class ElementFormulaire<T extends  JComponent> extends JComponent {
    private JLabel label;
    private T field;

    public ElementFormulaire(String text){
        label = new JLabel(text);
        label.setFont(new Font("Gras",Font.BOLD,20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
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

}
