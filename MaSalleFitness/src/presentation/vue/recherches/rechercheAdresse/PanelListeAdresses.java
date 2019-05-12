package presentation.vue.recherches.rechercheAdresse;

import model.Responsable;
import presentation.controleurs.rechercheAdresse.EnvoyerCourrierListener;
import presentation.vue.inscription.PanelBase;
import presentation.controleurs.rechercheAdresse.RetourMenuListener;

import java.util.Date;

public class PanelListeAdresses extends PanelBase<FormulaireTableAdresse> {

    private FormulaireTableAdresse formulaireTableAdresse = new FormulaireTableAdresse();

    public PanelListeAdresses(RechercheAdresse rechercheAdresse){
        super("<html><h1>Liste des adresses de chaque candidat inscrit par ce responsable</h1></html>","Retour","Envoyer courrier");
        addFormulaire(formulaireTableAdresse);

        setListenerBoutonGauche(new RetourMenuListener(rechercheAdresse));
        setListenerBoutonDroite(new EnvoyerCourrierListener());
    }

    public void setData(Responsable responsable, Date dateDebut, Date dateFin){
        formulaireTableAdresse.setData(responsable,dateDebut,dateFin);
    }
}
