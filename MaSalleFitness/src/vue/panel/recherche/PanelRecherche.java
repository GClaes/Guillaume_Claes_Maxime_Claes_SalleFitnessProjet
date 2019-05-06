package vue.panel.recherche;

import vue.panel.inscription.PanelInscriptionBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRecherche extends PanelInscriptionBase<PanelFormulaireRecherche> {

    private int categorie;
    public PanelRecherche(int categorie){
        super("<html><h1>Recherche d'un "+((categorie == 1)?"candidat":(categorie == 2)?"coach":"responsable"+"</h1></html>"),"Rechercher",new PanelFormulaireRecherche());
        this.categorie = categorie;
        setListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(PanelRecherche.this.categorie){
                    case 1 :
                        if(getFormulaire().validation()) {
                            PanelRecherche.this.removeAll();
                            PanelRecherche.this.add(new PanelCandidat());
                            PanelRecherche.this.repaint();
                            PanelRecherche.this.revalidate();
                        }
                    break;
                    case 2 : System.out.println("Recherche coach");
                    break;
                    case 3 : System.out.println("Recherche responsable");
                    break;
                }
            }
        });
    }
}
