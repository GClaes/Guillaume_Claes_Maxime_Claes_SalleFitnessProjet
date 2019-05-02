package vue.panel;

import model.Adresse;
import model.Candidat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PanelInscription extends JPanel {
    private JLabel titre;
    private JButton suivant;
    private PanelFormulaire formulaire;

    private PanelInscription2 panelInscription2;

    public PanelInscription(){

        setBounds(10,80,200,400);
        titre = new JLabel("<html><h1>Inscription nouveau candidat [1/3]</h1></html>");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire = new PanelFormulaire();
        suivant = new JButton("Suivant");
        suivant.setFont(new Font("Gras",Font.BOLD,20));
        suivant.addActionListener(new SuivantListener());


        setLayout(new BorderLayout());
        add(titre, BorderLayout.NORTH);
        add(suivant, BorderLayout.SOUTH);
        add(formulaire, BorderLayout.CENTER);

    }
    private class SuivantListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //VERIFICATION
            boolean validé = true;

            if(!formulaire.nomValide()){
                validé = false;
            }
            if(!formulaire.prénomValide()){
                validé = false;
            }

            //if(formulaire.dateNaissanceValide()){ //A MODIFIER
              //  validé = false;
            //}

            if(!formulaire.numTelValide()){
                validé = false;
            }

            if(!validé){

            }
            else{
                //TEMPORAIRE
                String nom = formulaire.getNom();
                String prénom = formulaire.getPrénom();
                Date dateNaissance = formulaire.getDateNaissance();
                String numTel = formulaire.getNumTel();
                int sexe = formulaire.getSexe();
                int experience = formulaire.getExperience();
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
    public Candidat getCandidat(){
        try {
            return new Candidat(
                    panelInscription2.getNbHeures(),
                    formulaire.getNom(),
                    formulaire.getPrénom(),
                    panelInscription2.getMaladies(),
                    formulaire.getDateNaissance(),
                    formulaire.getExperience() == 0,
                    formulaire.getSexe() == 0 ? 'M' : 'F',
                    null, null, null,
                    panelInscription2.getAdresse()
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
