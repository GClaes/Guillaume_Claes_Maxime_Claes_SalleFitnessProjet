package vue.recherches.rechercheAdresse;

import business.ResponsableService;
import business.impl.ResponsableServiceImpl;
import model.Responsable;
import vue.element.ElementFormulaireJComboBox;
import vue.element.ElementFormulaireJSpinnerDate;
import vue.inscription.formulaire.PanelFormulaireBase;
import vue.validateur.DateValidation;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class FormulaireRechercheDates extends PanelFormulaireBase {
    private ResponsableService responsableService = ResponsableServiceImpl.getInstance();
    private List<Responsable> listResponsables;

    public FormulaireRechercheDates(){
        setLayout(new GridLayout(3,2,25,25));
    }

    public void rafraichir(){
        removeAll();
        listResponsables = responsableService.listingResponsables();
        setComposantes("responsable",new ElementFormulaireJComboBox("Responsable",afficherResponsables()));
        setComposantes("dateDebut", new ElementFormulaireJSpinnerDate("Date début"));
        setComposantes("dateFin", new ElementFormulaireJSpinnerDate("Date fin"));
        getComposantes().get("dateDebut").addValidation(new DateValidation((Date)getComposantes().get("dateFin").getValue()));
        initList();
    }
    public Responsable getResponsable(){
        int indice = (int)getComposantes().get("responsable").getValue();
        return listResponsables.get(indice);
    }
    public Date getDateDebut(){
        return (Date)getComposantes().get("dateDebut").getValue();
    }
    public Date getDateFin(){
        return (Date)getComposantes().get("dateFin").getValue();
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
