package vue;

import javax.swing.*;
import java.awt.*;

public class PanelInfo extends JPanel {
    private JLabel titre;
    private JLabel texte;
    public PanelInfo(){
        this.setBounds(10,80,500,150);
        this.setLayout(new BorderLayout());
        titre = new JLabel("<html><h2>Ceci est un programme réalisé par les frères Claes.</h2></html>");
        texte = new JLabel("<html><h3>Ce programme a pour but de gérer les inscriptions dans une salle de sport, " +
                "ainsi que de gérer les différentes interactions possibles entre les responsables, " +
                "coachs et candidats.</h3></html>");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        texte.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
        this.add(texte, BorderLayout.CENTER);
    }
}
