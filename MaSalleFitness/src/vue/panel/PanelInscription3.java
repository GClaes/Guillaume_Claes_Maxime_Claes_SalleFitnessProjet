package vue.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelInscription3 extends JPanel {
    private JLabel titre;
    private PanelFormulaire3 formulaire;
    private JButton envoyer;

    public PanelInscription3(){
        setBounds(10,80,200,400);
        titre = new JLabel("<html><h1>Inscription nouveau candidat [3/3]</h1></html>");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire = new PanelFormulaire3();
        envoyer = new JButton("Suivant");
        envoyer.addActionListener(new EnvoyerListener());
        envoyer.setFont(new Font("Gras",Font.BOLD,20));

        setLayout(new BorderLayout());
        add(titre, BorderLayout.NORTH);
        add(envoyer, BorderLayout.SOUTH);
        add(formulaire, BorderLayout.CENTER);
    }

    private class EnvoyerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PanelInscription3.this.removeAll();
            JLabel texteEnvoi = new JLabel("<html><h2>Candidature envoyée avec succès!</h2></html>");
            JButton ok = new JButton("Ok");
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PanelInscription3.this.removeAll();
                    PanelInscription3.this.add(new PanelMenu());
                    PanelInscription3.this.repaint();
                    PanelInscription3.this.revalidate();

                }
            });
            texteEnvoi.setBounds(150, 80, 500, 150);
            ok.setBounds(350, 500, 100, 40);
            texteEnvoi.setHorizontalAlignment(SwingConstants.CENTER);
            PanelInscription3.this.add(texteEnvoi);
            PanelInscription3.this.add(ok);
            PanelInscription3.this.repaint();
        }
    }

    public int getNbHeures(){
        return formulaire.getNbHeures();
    }
    public String getMaladies(){
        return formulaire.getMaladies();
    }
}
