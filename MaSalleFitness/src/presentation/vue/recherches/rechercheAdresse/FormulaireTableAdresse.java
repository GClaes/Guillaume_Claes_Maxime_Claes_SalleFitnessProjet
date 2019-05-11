package presentation.vue.recherches.rechercheAdresse;

import business.CandidatService;
import business.impl.CandidatServiceImpl;
import model.Candidat;
import model.Responsable;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class FormulaireTableAdresse extends JPanel{
    private JTable tableAdresse;
    private String[]colonnes={"ID","Nom","Prénom","Rue","Numero","Code postal","Localité"};
    private List<Candidat>candidats;

    public FormulaireTableAdresse() {
        setLayout(new BorderLayout());
    }

    public void setData(Responsable responsable, Date dateDebut, Date dateFin){
        CandidatService candidatService = CandidatServiceImpl.getInstance();
        candidats = candidatService.candidatsInscritsEntreDeuxDates(responsable.getNumeroTravailleur(),dateDebut, dateFin);

        removeAll();

        Object [][]values = new Object[candidats.size()][colonnes.length];
        int numCoach = 0;
        for(Candidat candidat : candidats){
            values[numCoach][0] = candidat.getNumInscription();
            values[numCoach][1] = candidat.getNom();
            values[numCoach][2] = candidat.getPrenom();
            values[numCoach][3] = candidat.getAdresse().getRue();
            values[numCoach][4] = candidat.getAdresse().getNumero();
            values[numCoach][5] = candidat.getAdresse().getCodePostal();
            values[numCoach][6] = candidat.getAdresse().getLocalite();
            numCoach++;
        }
        tableAdresse = new JTable(values,colonnes);
        tableAdresse.setFont(new Font("Gras",Font.BOLD,15));

        add(new JScrollPane(tableAdresse), BorderLayout.CENTER);
    }
}
