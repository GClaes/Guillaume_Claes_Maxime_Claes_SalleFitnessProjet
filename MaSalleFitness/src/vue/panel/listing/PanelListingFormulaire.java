package vue.panel.listing;

import business.CandidatService;
import business.CandidatServiceImp;
import model.Candidat;
import vue.element.ElementFormulaireLabel;
import vue.panel.inscription.PanelFormulaireBase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelListingFormulaire extends PanelFormulaireBase {
    public PanelListingFormulaire() {
        CandidatService candidatService = new CandidatServiceImp();
        ArrayList<Candidat>listeCandidats = candidatService.listingCandidats();
        for(Candidat candidat:listeCandidats){
            String idCandidat = candidat.getNumInscription().toString();
            setComposantes(idCandidat,new ElementFormulaireLabel(idCandidat,null,new JLabel(candidat.getNom()+" "+candidat.getPrenom())));
        }
        setLayout(new GridLayout(listeCandidats.size(),2,5,5));
        initList();
    }
}
