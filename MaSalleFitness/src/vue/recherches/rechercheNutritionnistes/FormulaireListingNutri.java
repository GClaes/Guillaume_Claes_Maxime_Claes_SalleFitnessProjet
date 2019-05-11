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
    private JScrollPane scrollPane;

    public FormulaireListingNutri() {
        listeNutris = new JList<>();
        scrollPane = new JScrollPane(listeNutris, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(400,500));
        add(scrollPane);
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
        listeNutris.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeNutris.setListData(values);
        listeNutris.setFont(new Font("Gras",Font.BOLD,15));
    }
}
