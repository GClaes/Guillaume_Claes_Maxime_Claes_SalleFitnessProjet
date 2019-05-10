package business.impl;

import business.AdresseService;
import dataAccess.AdresseDao;
import dataAccess.impl.AdresseDaoImpl;

public class AdresseServiceImpl implements AdresseService {
    private final AdresseDao adresseDao = AdresseDaoImpl.getInstance();
    private static AdresseService adresseService;

    private AdresseServiceImpl() { }

    public static AdresseService getInstance() {
        if (adresseService == null) {
            adresseService = new AdresseServiceImpl();
        }
        return adresseService;
    }
}
