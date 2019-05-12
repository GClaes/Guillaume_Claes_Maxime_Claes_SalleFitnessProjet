package presentation.vue.listing.listingAdresse;

import presentation.controller.listener.RetourMenuListener;
import presentation.vue.FramePrincipale;
import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.rechercheAdresse.EnvoyerCourrierListener;

public class ListingAdresse extends PanelBase<FormulaireListingAdresse> {

    private FormulaireListingAdresse formulaireListingAdresse= new FormulaireListingAdresse();
    private FramePrincipale frame;

    public ListingAdresse(FramePrincipale frame){
        super("<html><h1>Liste des adresses de chaque candidat inscrit par ce responsable</h1></html>","Retour","Envoyer courrier");
        addFormulaire(formulaireListingAdresse);
        this.frame = frame;
        setListenerBouton1(new RetourMenuListener(frame));
        setListenerBouton2(new EnvoyerCourrierListener());
    }


    public void rafraichir(){
        formulaireListingAdresse.rafraichir();
    }
}
