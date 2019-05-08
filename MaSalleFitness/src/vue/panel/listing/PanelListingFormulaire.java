package vue.panel.listing;

import business.CandidatService;
import business.CandidatServiceImp;
import model.Candidat;
import vue.panel.Raffraichissable;

import javax.swing.*;
import java.util.ArrayList;

public class PanelListingFormulaire extends JPanel implements Raffraichissable {
    private JList<String>listing;

    @Override
    public void raffraichir() {
        CandidatService candidatService = new CandidatServiceImp();
        ArrayList<Candidat>listeCandidats = candidatService.listingCandidats();
        String[]values = new String[listeCandidats.size()];
        int position = 0;
        for(Candidat candidat:listeCandidats){
            values[position] = candidat.getNumInscription().toString()+" "+candidat.getNom()+" "+candidat.getPrenom();
            position++;
        }
        listing = new JList<>(values);
        listing.setVisibleRowCount(5);
        listing.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(listing);
    }
}
