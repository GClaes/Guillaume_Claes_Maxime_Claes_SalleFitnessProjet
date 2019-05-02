package vue.panel;

import model.Adresse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInscription2 extends JPanel {
    private JLabel titre;
    private PanelFormulaire2 formulaire;
    private JButton suivant;


    private PanelInscription3 panelInscription3;
    public PanelInscription2(){

        setBounds(10,80,200,400);
        titre = new JLabel("<html><h1>Inscription nouveau candidat [2/3]</h1></html>");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire = new PanelFormulaire2();
        suivant = new JButton("Suivant");
        suivant.addActionListener(new SuivantListener());
        suivant.setFont(new Font("Gras",Font.BOLD,20));

        setLayout(new BorderLayout());
        add(titre, BorderLayout.NORTH);
        add(suivant, BorderLayout.SOUTH);
        add(formulaire, BorderLayout.CENTER);
    }
    private class SuivantListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panelInscription3 = new PanelInscription3();
            PanelInscription2.this.removeAll();
            PanelInscription2.this.add(panelInscription3);
            PanelInscription2.this.repaint();
            PanelInscription2.this.revalidate();


        }
    }
    public Adresse getAdresse(){
        try{
            return new Adresse(formulaire.getLocalite(), formulaire.getCodePostal(), formulaire.getRue(), formulaire.getNumero());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int getNbHeures(){
        return panelInscription3.getNbHeures();
    }
    public String getMaladies(){
        return panelInscription3.getMaladies();
    }
}
