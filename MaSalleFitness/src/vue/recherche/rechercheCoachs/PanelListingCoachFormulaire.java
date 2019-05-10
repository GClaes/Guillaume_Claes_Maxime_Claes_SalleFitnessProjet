package vue.recherche.rechercheCoachs;

import business.CoachService;
import business.imp.CoachServiceImp;
import model.Candidat;
import model.Coach;
import model.Responsable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelListingCoachFormulaire extends JPanel {
    private JList<String>listeCoachs;
    private ArrayList<Coach>coachs;

    public PanelListingCoachFormulaire() {
        listeCoachs = new JList<>();

        add(listeCoachs);
    }
    public void setResponsable(Responsable responsable) {
        CoachService coachService = CoachServiceImp.getInstance();
        coachs = coachService.coachsDesCandidatsInscritsParUnResponsable(responsable.getNumeroTravailleur());
        String[]values = new String[coachs.size()];
        int position = 0;
        for(Coach coach : coachs){
            values[position] = "Coach: "+coach.getNom()+" "+coach.getPrenom();
            for (Candidat candidat : coach.getCandidats()){
                values[position] += "     Candidat: "+candidat.getNom()+" "+candidat.getPrenom()+" ID: "+candidat.getNumInscription();
            }
            position++;
        }
        listeCoachs.setVisibleRowCount(6);
        listeCoachs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeCoachs.setListData(values);
        listeCoachs.setFont(new Font("Gras",Font.BOLD,15));
    }

}
