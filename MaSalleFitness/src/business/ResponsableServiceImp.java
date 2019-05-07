package business;

import dataAccess.ResponsableDao;
import dataAccess.ResponsableDaoImp;

public class ResponsableServiceImp implements ResponsableService {
    private ResponsableDao responsableDao;

    public ResponsableServiceImp() {
        setResponsableDao(new ResponsableDaoImp());
    }

    public void setResponsableDao(ResponsableDao responsableDao) {
        this.responsableDao = responsableDao;
    }
}
