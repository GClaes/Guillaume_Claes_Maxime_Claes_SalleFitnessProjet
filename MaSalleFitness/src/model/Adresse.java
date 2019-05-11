package model;

import model.exceptions.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class Adresse {
    private String code;
    private String localite;
    private String codePostal;
    private String rue;
    private String numero;

    public Adresse(String localite, String codePostal, String rue, String numero) {
        setLocalite(localite);
        setCodePostal(codePostal);
        setRue(rue);
        setNumero(numero);
        genereCode();
    }

    public void setLocalite(String localite) {
        if (localite == null) {
            throw new LocaliteException(localite);
        }
        this.localite = localite;
    }

    public void setCodePostal(String codePostal) {
        Integer codePostalCast = Integer.parseInt(codePostal);

        if (codePostalCast == null || codePostalCast < 1000 || codePostalCast > 9992) {
            throw new CodePostalException(codePostal);
        }
        this.codePostal = codePostal;
    }

    public void setRue(String rue) {
        if (rue == null) {
            throw new RueException(rue);
        }
        this.rue = rue;
    }

    public void setNumero(String numero) {
        if (numero == null ) {
            throw new NumeroException(numero);
        }
        this.numero = numero;
    }

    public void genereCode() {
        MessageDigest m = null;
        String adr = localite.toLowerCase() + codePostal.toLowerCase() + rue.toLowerCase() + numero.toLowerCase();
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

    public String getLocalite() {
        return localite;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getRue() {
        return rue;
    }

    public String getNumero() {
        return numero;
    }

}
