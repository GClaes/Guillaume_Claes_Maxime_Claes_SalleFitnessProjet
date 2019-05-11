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

public class FormulaireListingCoach extends JPanel {
    private JList<String>listeCoachs;
    private List<Coach> coachs;
    private JScrollPane scrollPane;

    public FormulaireListingCoach() {
        listeCoachs = new JList<>();
        scrollPane = new JScrollPane(listeCoachs, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(400,500));
        add(scrollPane);
    }
    public void setResponsable(Responsable responsable) {
        CoachService coachService = CoachServiceImpl.getInstance();
        coachs = coachService.coachsDesCandidatsInscritsParUnResponsable(responsable.getNumeroTravailleur());
        String[]values = new String[coachs.size()];
        int position = 0;
        for(Coach coach : coachs){
            values[position] = "<html>Coach: "+coach.getNom()+" "+coach.getPrenom()+"<br><ul>";
            for (Candidat candidat : CandidatServiceImpl.getInstance().candidatsDUnCoach(coach)){
                values[position] += "   <li>"+"ID: "+candidat.getNumInscription()+" | "+candidat.getNom()+" "+candidat.getPrenom()+"</li></br>";
            }
            values[position]+="</ul></html>";
            position++;
        }
        listeCoachs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeCoachs.setListData(values);
        listeCoachs.setFont(new Font("Gras",Font.BOLD,15));
    }
}
