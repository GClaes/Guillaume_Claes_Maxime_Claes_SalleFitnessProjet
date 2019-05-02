package vue.panel;

import model.Adresse;
import model.Candidat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PanelInscription extends PanelInscriptionBase<PanelFormulaire> {
    private JLabel titre;
    private JButton suivant;
    private PanelFormulaire formulaire;

    private PanelInscription2 panelInscription2;

    public PanelInscription() {
        super("<html><h1>Inscription nouveau candidat [1/3]</h1></html>", "Suivant", new PanelFormulaire());
        setListener(new SuivantListener());
    }


    private class SuivantListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //VERIFICATION
            boolean validé = true;

            if(!getFormulaire().nomValide()){
                validé = false;
            }
            if(!getFormulaire().prénomValide()){
                validé = false;
            }

            //if(getFormulaire().dateNaissanceValide()){ //A MODIFIER
              //  validé = false;
            //}

            if(!getFormulaire().numTelValide()){
                validé = false;
            }

            if(!validé){

            }
            else{
                //TEMPORAIRE
                String nom = getFormulaire().getNom();
                String prénom = getFormulaire().getPrénom();
                Date dateNaissance = getFormulaire().getDateNaissance();
                String numTel = getFormulaire().getNumTel();
                int sexe = getFormulaire().getSexe();
                int experience = getFormulaire().getExperience();
                //

                panelInscription2 = new PanelInscription2();
                PanelInscription.this.removeAll();
                PanelInscription.this.add(panelInscription2);
                PanelInscription.this.repaint();
                PanelInscription.this.revalidate();


                Adresse adresse = panelInscription2.getAdresse();
                int nbHeures = panelInscription2.getNbHeures();
                String maladies = panelInscription2.getMaladies();
            }
        }
    }
}
