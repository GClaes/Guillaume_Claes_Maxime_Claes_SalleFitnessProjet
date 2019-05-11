package presentation.vue.recherches;

import model.Candidat;
import presentation.vue.inscription.PanelBase;
import presentation.controller.listener.recherche.AccesPanelModifierListener;
import presentation.controller.listener.recherche.SupprimerCandidatListener;
import presentation.vue.recherches.rechercheCandidat.Recherche;

public class PanelCandidatInfo extends PanelBase<CandidatFormulaire> {
    private CandidatFormulaire candidatFormulaire = new CandidatFormulaire();
    private Candidat candidat;
    private Recherche recherche;

    public PanelCandidatInfo(Recherche recherche) {
        super("<html><h1>Fiche du candidat recherché</h1></html>", "Supprimer","Modifier");
        this.addFormulaire(candidatFormulaire);
        this.recherche = recherche;
        setListenerBouton1(new SupprimerCandidatListener(this));
        setListenerBouton2(new AccesPanelModifierListener(this));
    }

    public void setCandidat(Candidat candidat){
        this.candidat = candidat;
        candidatFormulaire.setCandidat(candidat);
    }

    public void supprimerCandidat(){
        recherche.supprimer(candidat);
    }
    public void modifierCandidat(){
        recherche.modifier(candidat);
    }
}
