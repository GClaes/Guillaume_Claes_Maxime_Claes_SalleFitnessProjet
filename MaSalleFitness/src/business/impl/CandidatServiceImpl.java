package business.impl;

import business.CandidatService;
import dataAccess.CandidatDao;
import dataAccess.impl.CandidatDaoImpl;
import model.Candidat;
import model.Coach;
import model.Nutritionniste;

import java.util.Date;
import java.util.List;

public class CandidatServiceImpl implements CandidatService {
    private final CandidatDao candidatDao = CandidatDaoImpl.getInstance();
    private static CandidatService candidatService;

    private CandidatServiceImpl() { }

    public static CandidatService getInstance() {
        if (candidatService == null) {
            candidatService = new CandidatServiceImpl();
        }
        return candidatService;
    }

    public Candidat rechercherCandidat(int numeroInscription) {
        return candidatDao.rechercherCandidat(numeroInscription);
    }

    public List<Candidat> listingCandidats() {
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

    public List<Candidat> candidatsInscritsEntreDeuxDates(int responsableMatricule, Date debut, Date fin) {
        return candidatDao.candidatsInscritsEntreDeuxDates(responsableMatricule, debut, fin);
    }

    public List<Candidat> candidatsDUnCoach(Coach coach) {
        return candidatDao.candidatsDUnCoach(coach);
    }

    public List<Candidat> candidatsDUnNutritionniste(Nutritionniste nutritionniste) {
        return candidatDao.candidatsDUnNutritionniste(nutritionniste);
    }
}
