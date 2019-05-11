package presentation.vue.inscription;

import javax.swing.*;
import java.awt.*;

public class BoutonsInscription extends JButton {
    private JButton bouton1;
    private JButton bouton2;
    public BoutonsInscription(String textBouton1, String textBouton2){
        setLayout(new GridLayout(1,2));
        bouton1 = new JButton(textBouton1);
        bouton1.setFont(new Font("Gras",Font.BOLD,20));
        bouton2 = new JButton(textBouton2);
        bouton2.setFont(new Font("Gras",Font.BOLD,20));

        add(bouton1);
        add(bouton2);
    }

    public JButton getBouton1() {
        return bouton1;
    }

    public JButton getBouton2() {
        return bouton2;
    }
}
