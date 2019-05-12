package presentation.vue.listing.listingCandidats;

import business.CandidatService;
import business.impl.CandidatServiceImpl;
import model.Candidat;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListingFormulaire extends JPanel {
    private JList<String>listing;
    private List<Candidat>listeCandidats;

    public ListingFormulaire() {
        listing = new JList<>(new DefaultListModel<>());
        rafraichir();
        JScrollPane scrollPane = new JScrollPane(listing,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(400,500));
        add(scrollPane);
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
        CandidatService candidatService = CandidatServiceImpl.getInstance();
        listeCandidats = candidatService.listingCandidats();
        String[]values = new String[listeCandidats.size()];
        int position = 0;
        for(Candidat candidat:listeCandidats){
            values[position] = "<html><li>ID: "+candidat.getNumInscription()+" | "+candidat.getNom()+" "+candidat.getPrenom()+"</li></html>";
            position++;
        }
        listing.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listing.setListData(values);
        listing.setFont(new Font("Gras",Font.BOLD,20));
    }
}
