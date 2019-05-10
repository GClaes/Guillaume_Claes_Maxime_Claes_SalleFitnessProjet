package business.imp;

import business.CandidatService;
import dataAccess.CandidatDao;
import dataAccess.imp.CandidatDaoImp;
import model.Candidat;

import java.util.ArrayList;
import java.util.Date;

public class CandidatServiceImp implements CandidatService {
    private final CandidatDao candidatDao = CandidatDaoImp.getInstance();
    private static CandidatService candidatService;

    private CandidatServiceImp() { }

    public static CandidatService getInstance() {
        if (candidatService == null) {
            candidatService = new CandidatServiceImp();
        }
        return candidatService;
    }

    public Candidat rechercherCandidat(int numeroInscription) {
        return candidatDao.rechercherCandidat(numeroInscription);
    }

    public ArrayList<Candidat> listingCandidats() {
        return candidatDao.listingCandidats();
    }

    public void ajoutCandidat(Candidat candidat) {
        candidatDao.ajouterCandidat(candidat);
    }

    public void supprimerCandidat(int numeroInscription) {
        candidatDao.supprimerCandidat(numeroInscription);
    }

    public void modifierCandidat(Candidat candidat) {
        candidatDao.modifierCandidat(candidat);
    }
    public ArrayList<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin) {
        return candidatDao.candidatsInscritsEntreDeuxDates(responsableMatricule, debut, fin);
    }
}
