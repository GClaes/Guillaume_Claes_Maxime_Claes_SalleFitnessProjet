package vue.panel.recherche;

import business.CandidatService;
import business.CandidatServiceImp;
import model.Candidat;
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
                            CandidatService candidatService = new CandidatServiceImp();
                            Candidat candidat = candidatService.rechercherCandidat(getFormulaire().getId());
                            if(candidat == null){
                                JOptionPane.showMessageDialog(null,"Le candidat recherché n'existe pas, veuillez entrer un identifiant correct","Erreur lors de la recherche",JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                PanelRecherche.this.removeAll();
                                PanelRecherche.this.add(new PanelCandidat(candidat));
                                PanelRecherche.this.repaint();
                                PanelRecherche.this.revalidate();
                            }
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
