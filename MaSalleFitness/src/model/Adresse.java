package model;

import model.exceptions.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Adresse {
    private String code;
    private String localite;
    private String codePostal;
    private String rue;
    private String numero;
    private ArrayList<Candidat> candidats = new ArrayList <>();

    public Adresse(String localite, String codePostal, String rue, String numero) throws Exception {
        setLocalite(localite);
        setCodePostal(codePostal);
        setRue(rue);
        setNumero(numero);
        setCode();
    }

    public void setCodePostal(String codePostal) throws CodePostalException {
        Integer codePostalCast = Integer.parseInt(codePostal);

        if (codePostalCast == null || codePostalCast < 1000 || codePostalCast > 9992) {
            throw new CodePostalException(codePostal);
        }
        this.codePostal = codePostal.toLowerCase();
    }

    public void setLocalite(String localite) throws LocaliteException {
        if (localite == null) {
            throw new LocaliteException(localite);
        }
        this.localite = localite.toLowerCase();
    }

    public void setRue(String rue) throws RueException {
        if (rue == null) {
            throw new RueException(rue);
        }
        this.rue = rue.toLowerCase();
    }

    public void setNumero(String numero) throws NumeroException {
        if (numero == null) {
            throw new NumeroException(numero);
        }
        this.numero = numero.toLowerCase();
    }

    public void setCode() {
        MessageDigest m = null;
        String adr = localite + codePostal + rue + numero;
        byte[] adrByte = adr.getBytes();

        try {
            m = MessageDigest.getInstance("SHA-1");
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        this.code = convertionTableauBytesEnHexa(m.digest(adrByte));
    }

    private String convertionTableauBytesEnHexa(byte[] b) {
        String resultat = "";

        for (int i = 0 ; i < b.length ; i++) {
            resultat += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return resultat;
    }

    public String getCode() {
        return code;
    }
}
