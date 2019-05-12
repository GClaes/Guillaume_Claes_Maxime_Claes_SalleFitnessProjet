package presentation.vue.inscription;

import javax.swing.*;
import java.awt.*;

public class BoutonsInscription extends JButton {
    private JButton boutonGauche;
    private JButton boutonDroite;
    public BoutonsInscription(String textBoutonGauche, String textBoutonDroite){
        setLayout(new GridLayout(1,2));
        boutonGauche = new JButton(textBoutonGauche);
        boutonGauche.setFont(new Font("Gras",Font.BOLD,20));
        boutonDroite = new JButton(textBoutonDroite);
        boutonDroite.setFont(new Font("Gras",Font.BOLD,20));

        add(boutonGauche);
        add(boutonDroite);
    }

    public JButton getBoutonGauche() {
        return boutonGauche;
    }

    public JButton getBoutonDroite() {
        return boutonDroite;
    }
}
