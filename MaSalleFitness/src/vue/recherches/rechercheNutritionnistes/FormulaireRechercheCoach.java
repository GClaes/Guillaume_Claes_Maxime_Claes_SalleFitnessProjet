package vue.recherches.rechercheNutritionnistes;

import business.CoachService;
import business.impl.CoachServiceImpl;
import model.Coach;
import vue.element.ElementFormulaireJComboBox;
import vue.inscription.formulaire.PanelFormulaireBase;

import java.awt.*;
import java.util.List;

public class FormulaireRechercheCoach extends PanelFormulaireBase {
    private CoachService coachService = CoachServiceImpl.getInstance();
    private List<Coach> listCoachs;

    public FormulaireRechercheCoach() {
        setLayout(new GridLayout(1,2,25,25));
    }
    public void rafraichir(){
        removeAll();
        listCoachs = coachService.listingCoachs();
        setComposantes("coach", new ElementFormulaireJComboBox("Coach", afficherCoachs()));
        initList();
    }

    public Coach getCoach(){
        int indice = (int)getComposantes().get("coach").getValue();
        System.out.println(listCoachs.get(indice));
        return listCoachs.get(indice);
    }
    public String[] afficherCoachs(){
        int position = 0;
        String[]values = new String[listCoachs.size()];
        for(Coach coach: listCoachs){
            values[position] = coach.getNom()+" "+coach.getPrenom();
            position++;
        }
        return values;
    }
}
