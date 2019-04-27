package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

public class PanelInscription extends JPanel {
    private JLabel titre;
    private JButton envoyer;
    private PanelFormulaire formulaire;

    public PanelInscription(){

        this.setBounds(10,80,200,400);
        titre = new JLabel("<html><h1>Inscription nouveau candidat</h1></html>");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire = new PanelFormulaire();
        envoyer = new JButton("Envoyer");
        envoyer.setFont(new Font("Gras",Font.BOLD,20));
        EnvoyerListener envoyerListener = new EnvoyerListener();
        envoyer.addActionListener(envoyerListener);


        this.setLayout(new BorderLayout());
        this.add(titre, BorderLayout.NORTH);
        this.add(envoyer, BorderLayout.SOUTH);
        this.add(formulaire, BorderLayout.CENTER);

    }
    private class EnvoyerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //VERIFICATION
            boolean validé = true;
            if(!Pattern.matches("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$",formulaire.getNom().toLowerCase())){
                formulaire.setNomLabel(new JLabel("<html><h2> <font color='red'>Nom</font></h2></html>"));
                //formulaire.getNomLabel();
                validé = false;
            }

            if(!Pattern.matches("^[a-z]+[ \\-']?[[a-z]+[ \\-']?]*[a-z]+$",formulaire.getPrénom().toLowerCase())){
                //AFFICHER ERREUR PRENOM
                validé = false;
            }

            if(formulaire.getDateNaissance() == null){ //A MODIFIER
                //Afficher ERREUR DATE
                validé = false;
            }

            if(!Pattern.matches("(0|\\+32|0032)[1-9][0-9]{8}",formulaire.getNumTel())){
                //Afficher Erreur NumTel
                validé = false;
            }

            if(!validé){
                titre = new JLabel("<html><h1>Inscription nouveau candidat</h1>" +
                        "<br><h3><font color='red'>Veuillez remplir/corriger les champs en rouge!</font></h3></html>");
                titre.repaint();
            }
            else{
                PanelInscription.this.removeAll();
                JLabel texteEnvoi = new JLabel("<html><h2>Candidature envoyée avec succès!</h2></html>");
                JButton ok = new JButton("Ok");
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PanelInscription.this.removeAll();
                        PanelInscription.this.add(new PanelMenu());
                        PanelInscription.this.repaint();
                        PanelInscription.this.revalidate();

                    }
                });
                texteEnvoi.setBounds(150, 80, 500, 150);
                ok.setBounds(350, 500, 100, 40);
                texteEnvoi.setHorizontalAlignment(SwingConstants.CENTER);
                PanelInscription.this.add(texteEnvoi);
                PanelInscription.this.add(ok);
                PanelInscription.this.repaint();
            }
            //AFFICHER
        }
    }
}
