package vue;

import javax.swing.*;
import java.awt.*;

public class ComposanteFormulaire extends Component {
    private JLabel label;
    private JTextField field;

    public ComposanteFormulaire(String nom, int tailleField) {
        label = new JLabel(nom);
        field = new JTextField(tailleField);
    }
}
