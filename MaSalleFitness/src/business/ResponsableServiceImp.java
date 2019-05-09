package business;

import dataAccess.ResponsableDao;
import dataAccess.ResponsableDaoImp;
import model.Responsable;

import java.util.ArrayList;

public class ResponsableServiceImp implements ResponsableService {
    private ResponsableDao responsableDao;

    public ResponsableServiceImp() {
        setResponsableDao(ResponsableDaoImp.getInstance());
    }

    public ArrayList<Responsable> listingResponsables() {
        return responsableDao.listingResponsables();
    }

    public void setResponsableDao(ResponsableDao responsableDao) {
        this.responsableDao = responsableDao;
    }
}
