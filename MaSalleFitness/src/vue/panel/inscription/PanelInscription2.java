package vue.panel;

import model.Adresse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInscription2 extends PanelInscriptionBase<PanelFormulaire2> {
    private JLabel titre;
    private PanelFormulaire2 formulaire;
    private JButton suivant;


    private PanelInscription3 panelInscription3;
    public PanelInscription2(){
        super("<html><h1>Inscription nouveau candidat [2/3]</h1></html>","Suivant", new PanelFormulaire2());
        setListener(new SuivantListener());
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
