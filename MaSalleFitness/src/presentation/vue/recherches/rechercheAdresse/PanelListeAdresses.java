package presentation.vue.recherches.rechercheAdresse;

import model.Responsable;
import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.rechercheAdresse.EnvoyerCourrierListener;
import presentation.controller.listener.rechercheAdresse.RetourMenuListener;

import java.util.Date;

public class PanelListeAdresses extends PanelBase<FormulaireTableAdresse> {

    private FormulaireTableAdresse formulaireTableAdresse = new FormulaireTableAdresse();

    public PanelListeAdresses(RechercheAdresse rechercheAdresse){
        super("<html><h1>Liste des adresses de chaque candidat inscrit par ce responsable</h1></html>","Retour","Envoyer courrier");
        addFormulaire(formulaireTableAdresse);

        setListenerBouton1(new RetourMenuListener(rechercheAdresse));
        setListenerBouton2(new EnvoyerCourrierListener());
    }

    public void setData(Responsable responsable, Date dateDebut, Date dateFin){
        formulaireTableAdresse.setData(responsable,dateDebut,dateFin);
    }
}
