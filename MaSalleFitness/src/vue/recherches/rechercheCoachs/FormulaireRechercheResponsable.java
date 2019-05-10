package vue.recherches.rechercheCoachs;

import business.ResponsableService;
import business.impl.ResponsableServiceImpl;
import model.Responsable;
import vue.element.ElementFormulaireJComboBox;
import vue.inscription.formulaire.PanelFormulaireBase;

import java.awt.*;
import java.util.List;

public class FormulaireRechercheResponsable extends PanelFormulaireBase {
    private ResponsableService responsableService = ResponsableServiceImpl.getInstance();
    private List<Responsable> listResponsables;

    public FormulaireRechercheResponsable() {
        setLayout(new GridLayout(1,2,25,25));
    }

    public void rafraichir(){
        removeAll();
        listResponsables = responsableService.listingResponsables();
        setComposantes("responsable",new ElementFormulaireJComboBox("Responsable",afficherResponsables()));
        initList();
    }

    public Responsable getResponsable(){
        int indice = (int)getComposantes().get("responsable").getValue();
        return listResponsables.get(indice);
    }

    public String[] afficherResponsables(){
        int position = 0;
        String[]values = new String[listResponsables.size()];
        for(Responsable responsable: listResponsables){
            values[position] = responsable.getNom()+" "+responsable.getPrenom();
            position++;
        }
        return values;
    }
}
