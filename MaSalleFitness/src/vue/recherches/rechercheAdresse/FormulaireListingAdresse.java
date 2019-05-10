package vue.recherches.rechercheAdresse;

import business.CandidatService;
import business.impl.CandidatServiceImpl;
import model.Adresse;
import model.Candidat;
import model.Responsable;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class FormulaireListingAdresse extends JPanel {
    private JList<String> listeCandidats;
    private List<Candidat>candidats;

    public FormulaireListingAdresse(){
        listeCandidats = new JList<>();

        add(listeCandidats);
    }
    public void setData(Responsable responsable, Date dateDebut, Date dateFin){
        CandidatService candidatService = CandidatServiceImpl.getInstance();
        candidats = candidatService.candidatsInscritsEntreDeuxDates(responsable.getNumeroTravailleur(),dateDebut, dateFin);
        String []values = new String[candidats.size()];
        int position = 0;
        for(Candidat candidat: candidats){
            Adresse adresse = candidat.getAdresse();
            values[position] = "<html><li>ID: "+candidat.getNumInscription()+" | "+candidat.getNom()+" "+candidat.getPrenom()+"<br>" +
                    "Adresse: "+adresse.getNumero()+" rue de "+adresse.getRue()+" "+adresse.getCodePostal()+" "+adresse.getLocalite()+"</li></html>";
            position++;
        }
        listeCandidats.setVisibleRowCount(6);
        listeCandidats.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeCandidats.setListData(values);
        listeCandidats.setFont(new Font("Gras",Font.BOLD,15));
    }
}
