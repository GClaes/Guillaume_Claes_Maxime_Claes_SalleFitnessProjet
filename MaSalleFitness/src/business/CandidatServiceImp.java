package business;

import dataAccess.CandidatDao;
import dataAccess.CandidatDaoImp;

public class CandidatServiceImp implements CandidatService {
    private CandidatDao candidatDao;

    public CandidatServiceImp() {
        setCandidatDao(new CandidatDaoImp());
    }

    public void setCandidatDao(CandidatDao candidatDao) {
        this.candidatDao = candidatDao;
    }
}
