package presentation.vue.recherches.rechercheNutritionnistes;

import business.NutritionnisteService;
import business.impl.NutritionnisteServiceImpl;
import model.Coach;
import model.Nutritionniste;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormulaireTableNutri extends JPanel {
    private JTable tableNutri;
    private String[] colonnes = {"ID", "Nom", "Prénom", "Avis"};
    private List<Nutritionniste> nutris;
    private Object [][]values;

    public FormulaireTableNutri() {
        setLayout(new BorderLayout());
    }

    public void setCoach(Coach coach) {
        NutritionnisteService nutritionnisteService = NutritionnisteServiceImpl.getInstance();
        nutris = nutritionnisteService.nutritionnistesDesCandidatsEntrainesParUnCoach(coach.getMatricule());

        removeAll();

        values = new Object[nutris.size()][colonnes.length];
        int numCoach = 0;
        for(Nutritionniste nutritionniste : nutris){
            values[numCoach][0] = nutritionniste.getNumReference();
            values[numCoach][1] = nutritionniste.getNom();
            values[numCoach][2] = nutritionniste.getPrenom();
            values[numCoach][3] = nutritionniste.getAvis();
            numCoach++;
        }
        tableNutri = new JTable(values,colonnes);
        tableNutri.setFont(new Font("Gras",Font.BOLD,15));

        add(new JScrollPane(tableNutri), BorderLayout.CENTER);

    }
}
