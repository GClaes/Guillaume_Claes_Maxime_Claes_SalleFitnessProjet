package presentation.vue.inscription;

import presentation.controleurs.inscription.RetourMenuListener;

import javax.swing.*;
import java.awt.*;

public class PanelRecap extends JPanel {
    private Inscription inscription;
    private JLabel label;
    private JButton valider;

    public PanelRecap(Inscription inscription) {
        setLayout(new BorderLayout());
        this.inscription = inscription;
        label = new JLabel("Candidature envoyée avec succès!");
        label.setFont(new Font("Gras",Font.BOLD,20));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        valider = new JButton("Valider");
        valider.setFont(new Font("Gras",Font.BOLD,20));
        valider.addActionListener(new RetourMenuListener(inscription));
        add(label, BorderLayout.CENTER);
    }
}
