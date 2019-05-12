package presentation.vue.recherches.rechercheCoachs;

import business.CoachService;
import business.impl.CoachServiceImpl;
import model.Coach;
import model.Responsable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormulaireTableCoach extends JPanel {
    private JTable tableCoach;
    private List<Coach>coachs;
    private String []colonnes = {"ID","Nom","Prénom","Récompense(s)","Date début coach",
            "Salaire horaire","Salaire Hebdo"};

    public FormulaireTableCoach(){
        setLayout(new BorderLayout());
    }

    public void setResponsable(Responsable responsable) {
        CoachService coachService = CoachServiceImpl.getInstance();
        coachs = coachService.coachsDesCandidatsInscritsParUnResponsable(responsable.getNumeroTravailleur());

        removeAll();

        Object [][]values = new Object[coachs.size()][colonnes.length];
        int numCoach = 0;
        for(Coach coach : coachs){
            values[numCoach][0] = coach.getMatricule();
            values[numCoach][1] = coach.getNom();
            values[numCoach][2] = coach.getPrenom();
            values[numCoach][3] = coach.getRecompenses();
            values[numCoach][4] = coach.getDateDebutCoaching();
            values[numCoach][5] = coach.getSalaireHoraire()+"€";
            values[numCoach][6] = coachService.calculSalaireHebdomadaire(coach.getMatricule())+"€";
            numCoach++;
        }
        tableCoach = new JTable(values,colonnes);
        tableCoach.setFont(new Font("Gras",Font.BOLD,15));

        add(new JScrollPane(tableCoach), BorderLayout.CENTER);
    }
}
