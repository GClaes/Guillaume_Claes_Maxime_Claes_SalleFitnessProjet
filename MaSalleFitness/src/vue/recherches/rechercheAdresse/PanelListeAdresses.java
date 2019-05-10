package vue.recherches.rechercheAdresse;

import model.Responsable;
import vue.inscription.PanelBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PanelListeAdresses extends PanelBase<FormulaireListingAdresse> {
    private ListingAdresse listingAdresse;
    private FormulaireListingAdresse formulaireListingAdresse= new FormulaireListingAdresse();

    public PanelListeAdresses(ListingAdresse listingAdresse){
        super("<html><h1>Liste des adresses de chaque candidat inscrit par ce responsable</h1></html>","Retour","Envoyer courrier");
        addFormulaire(formulaireListingAdresse);
        this.listingAdresse = listingAdresse;

        setListenerBouton1(new RetourListener());
        setListenerBouton2(new EnvoyerListener());
    }

    public class RetourListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            listingAdresse.retour();
        }
    }
    public class EnvoyerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"Une lettre va être envoyée!","Envoi de lettre",1);
        }
    }

    public void setData(Responsable responsable, Date dateDebut, Date dateFin){
        formulaireListingAdresse.setData(responsable, dateDebut, dateFin);
    }
}
