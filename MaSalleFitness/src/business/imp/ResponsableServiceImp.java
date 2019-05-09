package business.imp;

import business.ResponsableService;
import dataAccess.ResponsableDao;
import dataAccess.imp.ResponsableDaoImp;
import model.Responsable;

import java.util.ArrayList;

public class ResponsableServiceImp implements ResponsableService {
    private final ResponsableDao responsableDao = ResponsableDaoImp.getInstance();
    private static ResponsableService responsableService;

    private ResponsableServiceImp() { }

    public static ResponsableService getInstance() {
        if (responsableService == null) {
            responsableService = new ResponsableServiceImp();
        }
        return responsableService;
    }

    public ArrayList<Responsable> listingResponsables() {
        return responsableDao.listingResponsables();
    }
}
