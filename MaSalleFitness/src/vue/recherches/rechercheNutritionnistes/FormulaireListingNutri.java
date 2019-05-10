package vue.recherches.rechercheNutritionnistes;

import business.NutritionnisteService;
import business.impl.CandidatServiceImpl;
import business.impl.NutritionnisteServiceImpl;
import model.Candidat;
import model.Coach;
import model.Nutritionniste;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormulaireListingNutri extends JPanel {
    private JList<String>listeNutris;
    private List<Nutritionniste> nutris;

    public FormulaireListingNutri() {
        listeNutris = new JList<>();

        add(listeNutris);
    }

    public void setCoach(Coach coach){
        NutritionnisteService nutritionnisteService = NutritionnisteServiceImpl.getInstance();
        nutris = nutritionnisteService.nutritionnistesDesCandidatsEntrainesParUnCoach(coach.getMatricule());
        String[]values = new String[nutris.size()];
        int position = 0;
        for(Nutritionniste nutritionniste: nutris){
            values[position] = "<html>Nutritonniste: "+nutritionniste.getNom()+" "+nutritionniste.getPrenom()+"<br><ul>";
            for(Candidat candidat : CandidatServiceImpl.getInstance().candidatsDUnNutritionniste(nutritionniste)){
                values[position] += "    <li>"+"ID: "+candidat.getNumInscription()+" | "+candidat.getNom()+" "+candidat.getPrenom()+"</li><br>";
            }
            values[position]+="</ul></html>";
            position++;
        }
        listeNutris.setVisibleRowCount(6);
        listeNutris.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeNutris.setListData(values);
        listeNutris.setFont(new Font("Gras",Font.BOLD,15));
    }
}
