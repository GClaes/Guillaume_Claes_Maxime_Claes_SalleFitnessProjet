package Vue;

import javax.swing.*;
import java.awt.*;

public class PanelFormulaireRecherche extends JPanel {

    private JLabel nomLabel, prénomLabel;
    private JTextField nom, prénom;
    private Font gras;

    public PanelFormulaireRecherche(){
        setLayout(new GridLayout(2,2,25,25));
        gras = new Font("Gras",Font.BOLD,20);


        nomLabel = new JLabel("<html><h2>Nom</h2></html>");
        nomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nomLabel.setFont(gras);
        nom = new JTextField(30);
        nom.setFont(gras);
        this.add(nomLabel);
        this.add(nom);

        prénomLabel = new JLabel("<html><h2>Prénom</h2></html>");
        prénomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        prénomLabel.setFont(gras);
        prénom = new JTextField(30);
        prénom.setFont(gras);
        this.add(prénomLabel);
        this.add(prénom);

    }
}
