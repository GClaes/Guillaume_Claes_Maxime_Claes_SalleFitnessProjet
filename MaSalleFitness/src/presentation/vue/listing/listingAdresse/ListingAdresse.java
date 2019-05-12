package presentation.vue.listing.listingAdresse;

import presentation.controleurs.RetourMenuListener;
import presentation.vue.FramePrincipale;
import presentation.vue.inscription.PanelBase;
import presentation.controleurs.rechercheAdresse.EnvoyerCourrierListener;

public class ListingAdresse extends PanelBase<FormulaireListingAdresse> {

    private FormulaireListingAdresse formulaireListingAdresse= new FormulaireListingAdresse();

    public ListingAdresse(FramePrincipale frame){
        super("<html><h1>Liste des adresses de chaque candidat inscrit par ce responsable</h1></html>","Retour","Envoyer courrier");
        addFormulaire(formulaireListingAdresse);
        setListenerBoutonGauche(new RetourMenuListener(frame));
        setListenerBoutonDroite(new EnvoyerCourrierListener());
    }


    public void rafraichir(){
        formulaireListingAdresse.rafraichir();
    }
}
