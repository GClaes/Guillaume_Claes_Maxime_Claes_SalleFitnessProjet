package vue.panel.listing;

import business.CandidatService;
import business.CandidatServiceImp;
import model.Candidat;
import vue.element.ElementFormulaireLabel;
import vue.panel.inscription.PanelFormulaireBase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelListingFormulaire extends JPanel {
    private JList<String>listing;
    public PanelListingFormulaire() {
        CandidatService candidatService = new CandidatServiceImp();
        ArrayList<Candidat>listeCandidats = candidatService.listingCandidats();
        String[]values = new String[listeCandidats.size()];
        int position = 0;
        for(Candidat candidat:listeCandidats){
            values[position] = candidat.getNumInscription().toString()+" "+candidat.getNom()+" "+candidat.getPrenom();
            position++;
            //setComposantes(idCandidat,new ElementFormulaireLabel(idCandidat,null,new JLabel(candidat.getNom()+" "+candidat.getPrenom())));
        }
        listing = new JList<>(values);
        listing.setVisibleRowCount(5);
        listing.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(listing);
    }
}
