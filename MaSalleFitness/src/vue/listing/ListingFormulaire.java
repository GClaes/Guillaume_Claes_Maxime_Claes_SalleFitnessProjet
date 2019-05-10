package vue.listing;

import business.CandidatService;
import business.imp.CandidatServiceImp;
import model.Candidat;
import javax.swing.*;
import java.util.ArrayList;

public class ListingFormulaire extends JPanel {
    private JList<String>listing;
    private ArrayList<Candidat>listeCandidats;

    public ListingFormulaire() {
        listing = new JList<>();
        rafraichir();
        add(listing);
    }

    public int getIdSelect(){
        int index = listing.getAnchorSelectionIndex();
        if(index != -1) {
            return listeCandidats.get(index).getNumInscription();
        }
        else {
            JOptionPane.showMessageDialog(null, "Sélectionnez un candidat");
            return -1;
        }
    }

    public void rafraichir(){
        CandidatService candidatService = new CandidatServiceImp();
        listeCandidats = candidatService.listingCandidats();
        String[]values = new String[listeCandidats.size()];
        int position = 0;
        for(Candidat candidat:listeCandidats){
            values[position] = candidat.getNumInscription().toString()+" "+candidat.getNom()+" "+candidat.getPrenom();
            position++;
        }
        listing.setVisibleRowCount(5);
        listing.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listing.setListData(values);
    }
}
