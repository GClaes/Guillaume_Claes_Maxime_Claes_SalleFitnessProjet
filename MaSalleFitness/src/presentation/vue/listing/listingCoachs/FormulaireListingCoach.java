package presentation.vue.listing.listingCoachs;

import business.CoachService;
import business.impl.CandidatServiceImpl;
import business.impl.CoachServiceImpl;
import model.Candidat;
import model.Coach;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
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
    public void rafraichir() {
        CoachService coachService = CoachServiceImpl.getInstance();
        coachs = coachService.listingCoachs();
        DecimalFormat decimales = new DecimalFormat();
        decimales.setMaximumFractionDigits(2);
        String[]values = new String[coachs.size()];
        int position = 0;
        for(Coach coach : coachs){
            values[position] = "<html>Coach: "+coach.getNom()+" "+coach.getPrenom()+"<br>" +
                    "Salaire hebdomadaire: "+decimales.format(coachService.calculSalaireHebdomadaire(coach.getMatricule()))+"€"+"<br><ul>";
            for (Candidat candidat : CandidatServiceImpl.getInstance().candidatsDUnCoach(coach)){
                values[position] += "   <li>"+"Numéro d'inscription: "+candidat.getNumInscription()+" | "+candidat.getNom()+" "+candidat.getPrenom()+"</li></br>";
            }
            values[position]+="</ul></html>";
            position++;
        }
        listeCoachs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeCoachs.setListData(values);
        listeCoachs.setFont(new Font("Gras",Font.BOLD,15));
    }
}
