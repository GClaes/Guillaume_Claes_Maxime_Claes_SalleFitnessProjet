package business;

import dataAccess.CandidatDao;
import dataAccess.CandidatDaoImp;
import model.Candidat;

import java.util.ArrayList;

public class CandidatServiceImp implements CandidatService {
    private CandidatDao candidatDao;

    public CandidatServiceImp() {
        setCandidatDao(CandidatDaoImp.getInstance());
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

    public void setCandidatDao(CandidatDao candidatDao) {
        this.candidatDao = candidatDao;
    }
}
