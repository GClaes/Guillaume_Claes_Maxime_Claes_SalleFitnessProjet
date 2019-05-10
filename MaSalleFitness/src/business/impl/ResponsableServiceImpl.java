package business.impl;

import business.ResponsableService;
import dataAccess.ResponsableDao;
import dataAccess.impl.ResponsableDaoImpl;
import model.Responsable;

import java.util.List;

public class ResponsableServiceImpl implements ResponsableService {
    private final ResponsableDao responsableDao = ResponsableDaoImpl.getInstance();
    private static ResponsableService responsableService;

    private ResponsableServiceImpl() { }

    public static ResponsableService getInstance() {
        if (responsableService == null) {
            responsableService = new ResponsableServiceImpl();
        }
        return responsableService;
    }

    public List<Responsable> listingResponsables() {
        return responsableDao.listingResponsables();
    }
}
