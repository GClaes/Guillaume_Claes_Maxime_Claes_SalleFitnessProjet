package vue.panel.recherche;

import model.Candidat;
import vue.panel.PanelMenu;
import vue.panel.modification.PanelModification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCandidat extends JPanel {
    private JLabel titre;
    private PanelListeBouttonsCandidat listeBouttonsCandidat;
    private PanelCandidatInfo infoCandidat;
    public PanelCandidat(Candidat candidat){
        setLayout(new BorderLayout());

        titre = new JLabel("Candidat");
        titre.setFont(new Font("Gras",Font.BOLD,30));
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        listeBouttonsCandidat = new PanelListeBouttonsCandidat();
        infoCandidat = new PanelCandidatInfo(candidat);

        //AJOUT LISTENERS
        listeBouttonsCandidat.getRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCandidat.this.removeAll();
                PanelCandidat.this.add(new PanelMenu());
                PanelCandidat.this.repaint();
                PanelCandidat.this.revalidate();
            }
        });
        listeBouttonsCandidat.getModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCandidat.this.removeAll();
                PanelCandidat.this.add(new PanelModification(candidat));
                PanelCandidat.this.repaint();
                PanelCandidat.this.revalidate();
            }
        });
        listeBouttonsCandidat.getSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.add(titre, BorderLayout.NORTH);
        this.add(infoCandidat, BorderLayout.CENTER);
        this.add(listeBouttonsCandidat, BorderLayout.SOUTH);

    }
}
