package vue.recherches.rechercheCoachs;

import business.CoachService;
import business.impl.CandidatServiceImpl;
import business.impl.CoachServiceImpl;
import model.Candidat;
import model.Coach;
import model.Responsable;

import javax.swing.*;

import java.awt.*;
import java.util.List;

public class ListingCoachFormulaire extends JPanel {
    private JList<String>listeCoachs;
    private List<Coach> coachs;

    public ListingCoachFormulaire() {
        listeCoachs = new JList<>();

        add(listeCoachs);
    }
    public void setResponsable(Responsable responsable) {
        CoachService coachService = CoachServiceImpl.getInstance();
        coachs = coachService.coachsDesCandidatsInscritsParUnResponsable(responsable.getNumeroTravailleur());
        String[]values = new String[coachs.size()];
        int position = 0;
        for(Coach coach : coachs){
            values[position] = "Coach: "+coach.getNom()+" "+coach.getPrenom()+"\n";
            for (Candidat candidat : CandidatServiceImpl.getInstance().candidatsDUnCoach(coach)){
                values[position] += "     Candidat: "+candidat.getNom()+" "+candidat.getPrenom()+" ID: "+candidat.getNumInscription()+"\n";
            }
            position++;
        }
        listeCoachs.setVisibleRowCount(6);
        listeCoachs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeCoachs.setListData(values);
        listeCoachs.setFont(new Font("Gras",Font.BOLD,15));
    }

}
