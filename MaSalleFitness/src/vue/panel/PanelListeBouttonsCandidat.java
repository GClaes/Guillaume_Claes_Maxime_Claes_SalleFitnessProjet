package vue.panel;

import javax.swing.*;
import java.awt.*;

public class PanelListeBouttonsCandidat extends JPanel{
    private JButton modifier, supprimer, retour;
    private Font font;

    public PanelListeBouttonsCandidat(){
        font = new Font("gras", Font.BOLD, 20);
        setLayout(new GridLayout(1,3,50,50));

        modifier = new JButton("Modifier");
        modifier.setFont(font);
        supprimer = new JButton("Supprimer");
        supprimer.setFont(font);
        retour = new JButton("Retour");
        retour.setFont(font);


        this.add(retour);
        this.add(supprimer);
        this.add(modifier);
    }

    public JButton getModifier() {
        return modifier;
    }

    public JButton getSupprimer() {
        return supprimer;
    }

    public JButton getRetour() {
        return retour;
    }
}
